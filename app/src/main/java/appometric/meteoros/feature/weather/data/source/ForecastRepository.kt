package appometric.meteoros.feature.weather.data.source

import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.data.models.LocationApiResponse
import appometric.meteoros.feature.weather.data.models.PartedForecastApiResponse
import appometric.meteoros.feature.weather.data.source.remote.GeocodingApi
import appometric.meteoros.feature.weather.data.source.remote.WeatherApi
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val geocodingApi: GeocodingApi,
) {

    suspend fun fetchGeoByCityName(
        cityName: String,
    ): List<LocationApiResponse> = geocodingApi.fetchGeoByCityName(
        cityName = cityName,
    )

    suspend fun fetchCurrentForecastByCoordinates(
        longitude: Double,
        latitude: Double,
    ): ForecastApiResponse = weatherApi.fetchCurrentForecastByCoordinates(
        latitude = latitude,
        longitude = longitude,
    )

    suspend fun fetchPartedForecastByCoordinates(
        longitude: Double,
        latitude: Double,
    ): PartedForecastApiResponse = weatherApi.fetchPartedForecastByCoordinates(
        latitude = latitude,
        longitude = longitude,
    )
}