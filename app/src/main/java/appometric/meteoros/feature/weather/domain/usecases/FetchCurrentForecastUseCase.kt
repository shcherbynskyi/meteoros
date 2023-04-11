package appometric.meteoros.feature.weather.domain.usecases

import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.data.source.ForecastRepository
import javax.inject.Inject

class FetchCurrentForecastUseCase @Inject constructor(
    private val forecastRepository: ForecastRepository
) {

    suspend operator fun invoke(
        longitude: Double,
        latitude: Double
    ): ForecastApiResponse = forecastRepository.fetchCurrentForecastByCoordinates(
        latitude = latitude,
        longitude = longitude,
    )
}