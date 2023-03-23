package appometric.meteoros.feature.weather.data.source.remote

import appometric.meteoros.App
import appometric.meteoros.feature.weather.data.model.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("geo/1.0/direct")
    suspend fun fetchForecastByCityName(
        @Query("q") cityName: String,
        @Query("appid") appId: String = App.OPEN_WEATHER_MAP_API_KEY
    ): List<LocationDto>
}