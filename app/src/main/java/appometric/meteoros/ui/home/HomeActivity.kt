package appometric.meteoros.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.App
import appometric.meteoros.R
import appometric.meteoros.extensions.toast
import appometric.meteoros.model.Forecast
import appometric.meteoros.network.WeatherMapAPI
import appometric.meteoros.util.adapter.ForecastAdapter
import appometric.meteoros.util.adapter.RecyclerItemTouchHelper
import appometric.meteoros.viewmodel.HomeViewModel
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViewModel()
//        initAutoCompleteFragment()
//        initRecyclerView()

//        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback =
//            RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this)
//        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rv_weather)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getForecastData().observe(this, Observer { updateUI(it) })
    }

//    private fun initAutoCompleteFragment() {
//
//        if (!Places.isInitialized())
//            Places.initialize(App.getAppContext(), App.GOOGLE_PACES_API_KEY)
//
//        val etPlaces = supportFragmentManager
//                .findFragmentById(R.id.et_places) as AutocompleteSupportFragment
//
//        etPlaces.setPlaceFields(listOf(Place.Field.ID, Place.Field.LAT_LNG, Place.Field.NAME))
//        etPlaces.setOnPlaceSelectedListener(object : PlaceSelectionListener {
//            override fun onPlaceSelected(place: Place) {
//
//                val coords = place.latLng!!
//                val forecast: Call<Forecast> = weatherAPI.getWeather(coords.longitude, coords.latitude)
//                print(forecast.execute())
//
//            }
//
//            override fun onError(message: Status) {
//                toast(message.statusMessage.toString())
//            }
//        })
//    }


//    private fun initRecyclerView() {
//        rv_weather.addOnItemTouchListener(ForecastRecyclerClickListener(applicationContext, rv_weather,
//            object : ForecastRecyclerClickListener.OnItemClickListener {
//                override fun onItemClick(view: View, position: Int) {
//
//                    if (isConnectedToInternet()) {
//
//                        val forecast = viewModel.getForecastData().value!!.get(position)
//
//                        val activityIntent = Intent(applicationContext, MapActivity::class.java)
//                            .putExtra("FORECAST", forecast)
//
//                        startActivity(activityIntent)
//                    }
//                    else
//                        Toast.makeText(applicationContext, "No connection", Toast.LENGTH_LONG).show()
//                }
//
//                override fun onItemLongClick(view: View?, position: Int) { }
//            }
//        ))
//
//        rv_weather.setItemAnimator(DefaultItemAnimator())
//    }

    private fun updateUI(list: List<Forecast>) {
        rv_weather.adapter = ForecastAdapter(this, list)
    }
}