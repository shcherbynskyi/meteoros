package appometric.meteoros.feature.weather.data.source.remote

import appometric.meteoros.App
import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.data.models.PartedForecastApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    /**
     * Method that fetches forecast for a specific city, judging by the coordinates.
     *
     * @param latitude latitude of the city to get the forecast for
     * @param longitude longitude of the city to get the forecast for
     * @param unit measurement units ("metric", "imperial" or "default")
     * @param appId app id for weather api
     */
    @GET("data/2.5/weather")
    suspend fun fetchCurrentForecastByCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") unit: String = "metric",
        @Query("appid") appId: String = App.OPEN_WEATHER_MAP_API_KEY,
    ): ForecastApiResponse

    /**
     * Method that fetches parted forecast (3 hour forecast for 5 days) for a specific city, judging
     * by the coordinates.
     *
     * @param latitude latitude of the city to get the forecast for
     * @param longitude longitude of the city to get the forecast for
     * @param unit measurement units ("metric", "imperial" or "default")
     * @param appId app id for weather api
     */
    @GET("data/2.5/forecast")
    suspend fun fetchPartedForecastByCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") unit: String = "metric",
        @Query("appid") appId: String = App.OPEN_WEATHER_MAP_API_KEY,
    ): PartedForecastApiResponse
}