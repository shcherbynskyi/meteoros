package appometric.meteoros.feature.weather.domain.usecases

import appometric.meteoros.feature.weather.data.models.LocationApiResponse
import appometric.meteoros.feature.weather.data.source.ForecastRepository
import javax.inject.Inject

class FetchGeoUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(cityName: String): LocationApiResponse = forecastRepository
        .fetchGeoByCityName(cityName).firstOrNull() ?: throw Exception("No geo data for $cityName")
}