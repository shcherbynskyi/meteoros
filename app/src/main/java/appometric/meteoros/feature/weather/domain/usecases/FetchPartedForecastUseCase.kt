package appometric.meteoros.feature.weather.domain.usecases

import appometric.meteoros.feature.weather.data.models.PartedForecastApiResponse
import appometric.meteoros.feature.weather.data.source.ForecastRepository
import javax.inject.Inject

class FetchPartedForecastUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository,
) {

    suspend operator fun invoke(
        longitude: Double,
        latitude: Double,
    ): PartedForecastApiResponse = forecastRepository.fetchPartedForecastByCoordinates(
        latitude = latitude,
        longitude = longitude,
    )
}