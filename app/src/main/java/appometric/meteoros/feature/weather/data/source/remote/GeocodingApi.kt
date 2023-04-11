package appometric.meteoros.feature.weather.data.source.remote

import appometric.meteoros.App
import appometric.meteoros.feature.weather.data.models.LocationApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    /**
     * Method that fetches geolocation of a specific city, judging by the city name, state code
     * (only for the US) and country code divided by comma.
     *
     * @param cityName city name (optional - state code (only for the US) and country code divided
     * by comma)
     * @param appId app id for weather api
     */
    @GET("geo/1.0/direct")
    suspend fun fetchGeoByCityName(
        @Query("q") cityName: String,
        @Query("appid") appId: String = App.OPEN_WEATHER_MAP_API_KEY
    ): List<LocationApiResponse>
}