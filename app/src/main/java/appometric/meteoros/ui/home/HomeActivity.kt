package appometric.meteoros.ui.home

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.App
import appometric.meteoros.R
import appometric.meteoros.extensions.toast
import appometric.meteoros.model.Forecast
import appometric.meteoros.network.WeatherMapAPI
import appometric.meteoros.ui.map.MapActivity
import appometric.meteoros.util.adapter.ForecastAdapter
import appometric.meteoros.util.adapter.RecyclerItemTouchHelper
import appometric.meteoros.util.listener.ForecastRecyclerClickListener
import appometric.meteoros.viewmodel.HomeViewModel
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    private lateinit var viewModel: HomeViewModel
    @Inject lateinit var weatherAPI: WeatherMapAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        App.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViewModel()
        initAutoCompleteFragment()
        initRecyclerView()

        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback =
            RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rv_weather)
    }


    /**
     * Initialize ViewModel and create observer for LiveData
     */
    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getForecastData().observe(this, Observer { updateUI(it) })
    }


    /**
     * Initialize fragment with autocomplete EditText which contains Google places
     */
    private fun initAutoCompleteFragment() {

        if (!Places.isInitialized())
            Places.initialize(App.getAppContext(), App.GOOGLE_PACES_API_KEY)

        val etPlaces = supportFragmentManager
                .findFragmentById(R.id.et_places) as AutocompleteSupportFragment

        etPlaces.setPlaceFields(listOf(Place.Field.ID, Place.Field.LAT_LNG, Place.Field.NAME))
        etPlaces.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {

                val coords = place.latLng!!

                /*
                val result = viewModel.getForecastData().value!!.filter {
                    it.getLongitude() == coords.longitude
                    it.getLatitude() == coords.latitude
                }

                if (!result.isEmpty())
                    toast("City already exists")

                */


                val forecast: Call<Forecast> = weatherAPI.getWeather(coords.longitude, coords.latitude)

                print(forecast.execute())

                /*
                call.enqueue(object: Callback<JsonObject> {

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                        val res = response.body()!!

                        val country = res.getAsJsonObject("sys")
                            .get("country").asString
                        val temperature = res.getAsJsonObject("main")
                            .get("temp").asInt

                        val weather = res.getAsJsonArray("weather")
                            .get(0).asJsonObject.get("main").asString

                        val forecast = Forecast(place.name!!, country, coords.longitude, coords.latitude, temperature, weather)

                        viewModel.saveForecastData(forecast)
                        etPlaces.setText("")
                    }
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        toast(t.localizedMessage.toString())
                    }
                })
                */

            }

            override fun onError(message: Status) {
                toast(message.statusMessage.toString())
            }
        })
    }


    private fun initRecyclerView() {
        rv_weather.addOnItemTouchListener(ForecastRecyclerClickListener(applicationContext, rv_weather,
            object : ForecastRecyclerClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {

                    if (isConnectedToInternet()) {

                        val forecast = viewModel.getForecastData().value!!.get(position)

                        val activityIntent = Intent(applicationContext, MapActivity::class.java)
                            .putExtra("FORECAST", forecast)

                        startActivity(activityIntent)
                    }
                    else
                        Toast.makeText(applicationContext, "No connection", Toast.LENGTH_LONG).show()
                }

                override fun onItemLongClick(view: View?, position: Int) { }
            }
        ))

        rv_weather.setItemAnimator(DefaultItemAnimator())
    }


    /**
     * Handle swipe of RecyclerView item event
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        viewModel.deleteForecastData(position)
        rv_weather.adapter!!.notifyDataSetChanged()
    }


    private fun updateUI(list: List<Forecast>) {
        rv_weather.adapter = ForecastAdapter(this, list)
    }


    private fun isConnectedToInternet(): Boolean {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .activeNetworkInfo?.isConnected == true
    }
}