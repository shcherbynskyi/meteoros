package appometric.meteoros.network

import appometric.meteoros.App
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherMapAPI {

    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("units") unit: String = "metric",
        @Query("appid") appid: String = App.OPEN_WEATHER_MAP_API_KEY
    ): Call<JsonObject>

}