package appometric.meteoros.util.listener

import android.widget.Toast
import appometric.meteoros.App
import appometric.meteoros.model.Forecast
import appometric.meteoros.network.RetrofitClient
import appometric.meteoros.viewmodel.HomeViewModel
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceAutoCompleteListener(
        val viewModel: HomeViewModel
): PlaceSelectionListener {

    override fun onPlaceSelected(place: Place) {

        val name = place.name!!
        val coords = place.latLng!!

        val call = RetrofitClient.getWeatherMapAPI().getWeather(coords.longitude, coords.latitude)
        call.enqueue(object: Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                val res = response.body()!!

                val city = name
                val country = res.getAsJsonObject("sys")
                        .get("country").asString
                val temperature = res.getAsJsonObject("main")
                        .get("temp").asInt

                val forecast = Forecast(city, country, coords.longitude, coords.latitude, temperature)
                viewModel.saveForecastData(forecast)
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(App.getAppContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onError(message: Status) {
        Toast.makeText(App.getAppContext(), message.statusMessage, Toast.LENGTH_SHORT).show()
    }

}