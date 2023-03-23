package appometric.meteoros.feature.weather.data.source.remote

import appometric.meteoros.App
import appometric.meteoros.feature.weather.data.model.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun fetchForecastByCoordinates(
        @Query("lon") longitude: Double,
        @Query("lat") latitude: Double,
        @Query("units") unit: String = "metric",
        @Query("appid") appId: String = App.OPEN_WEATHER_MAP_API_KEY
    ): ForecastDto
}