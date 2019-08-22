package appometric.meteoros.ui.map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import appometric.meteoros.R
import appometric.meteoros.extensions.toast
import appometric.meteoros.model.Forecast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!

        // val forecast = intent.getSerializableExtra("FORECAST") as Forecast

        /*
        val point = LatLng(forecast.getLatitude(), forecast.getLongitude())
        map.addMarker(MarkerOptions().position(point).title("${forecast.getCity()} ${forecast.getTemperature()}°C"))
        map.moveCamera(CameraUpdateFactory.newLatLng(point))
        */
    }

}