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
import androidx.recyclerview.widget.LinearLayoutManager
import appometric.meteoros.App
import appometric.meteoros.R
import appometric.meteoros.model.Forecast
import appometric.meteoros.ui.map.MapActivity
import appometric.meteoros.util.adapter.ForecastAdapter
import appometric.meteoros.util.listener.ForecastRecyclerClickListener
import appometric.meteoros.util.listener.PlaceAutoCompleteListener
import appometric.meteoros.viewmodel.HomeViewModel
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        App.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViewModel()
        initAutoCompleteFragment()

        rv_weather.layoutManager = LinearLayoutManager(this)
        rv_weather.addOnItemTouchListener(ForecastRecyclerClickListener(applicationContext, rv_weather,
                object : ForecastRecyclerClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                        if (isConnectedToInternet()) {

                            val name = viewModel.getForecastData().value!!.get(position).getCity()
                            val temp = viewModel.getForecastData().value!!.get(position).getTemperature()
                            val latitude = viewModel.getForecastData().value!!.get(position).getLatitude()
                            val longitude = viewModel.getForecastData().value!!.get(position).getLongitude()

                            val activityIntent = Intent(applicationContext, MapActivity::class.java)

                            activityIntent.putExtra("NAME", name)
                            activityIntent.putExtra("TEMP", temp)
                            activityIntent.putExtra("LAT", latitude)
                            activityIntent.putExtra("LON", longitude)

                            startActivity(activityIntent)
                        }
                        else
                            Toast.makeText(applicationContext, "No connection", Toast.LENGTH_LONG).show()
                    }
                    override fun onItemLongClick(view: View?, position: Int) {
                        viewModel.deleteForecastData(position)
                        rv_weather.adapter!!.notifyItemRemoved(position)
                    }
                }
        ))
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
        etPlaces.setOnPlaceSelectedListener(PlaceAutoCompleteListener(viewModel))
    }


    /**
     *
     */
    private fun updateUI(list: List<Forecast>) {
        rv_weather.adapter = ForecastAdapter(this, list)
    }


    private fun isConnectedToInternet(): Boolean {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                .activeNetworkInfo?.isConnected == true
    }
}