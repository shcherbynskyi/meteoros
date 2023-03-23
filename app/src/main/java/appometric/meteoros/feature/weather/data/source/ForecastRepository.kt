package appometric.meteoros.feature.weather.data.source

import appometric.meteoros.feature.weather.data.model.ForecastDto
import appometric.meteoros.feature.weather.data.model.LocationDto
import appometric.meteoros.feature.weather.data.source.remote.GeocodingApi
import appometric.meteoros.feature.weather.data.source.remote.WeatherApi
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val geocodingApi: GeocodingApi
) {

    fun saveForecastData(forecast: ForecastDto) {
        // TODO
    }

    suspend fun fetchGeocodingByCityName(cityName: String): List<LocationDto> =
        geocodingApi.fetchForecastByCityName(cityName)

    suspend fun fetchForecastByCoordinates(longitude: Double, latitude: Double) =
        weatherApi.fetchForecastByCoordinates(longitude, latitude)

    fun getForecastData(): List<ForecastDto> {
        // TODO
        return listOf()
    }

    fun deleteForecastData(forecast: ForecastDto) {
        // TODO
    }
}