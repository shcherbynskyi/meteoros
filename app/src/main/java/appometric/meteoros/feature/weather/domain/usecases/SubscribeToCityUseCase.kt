package appometric.meteoros.feature.weather.domain.usecases

import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.data.models.LocationApiResponse
import appometric.meteoros.feature.weather.domain.entities.CityForecastDto
import javax.inject.Inject
import kotlin.math.roundToInt

class SubscribeToCityUseCase @Inject constructor(
    private val fetchGeoUseCase: FetchGeoUseCase,
    private val fetchCurrentForecastUseCase: FetchCurrentForecastUseCase,
    private val fetchPartedForecastUseCase: FetchPartedForecastUseCase,
) {

    suspend operator fun invoke(cityName: String): CityForecastDto {

        // fetch the city's location if it exists
        val cityGeo: LocationApiResponse = fetchGeoUseCase(
            cityName = cityName,
        )

        // fetch current forecast for the city
        val cityForecast: ForecastApiResponse = fetchCurrentForecastUseCase(
            longitude = cityGeo.longitude,
            latitude = cityGeo.latitude,
        )

        val cityPartedForecast = fetchPartedForecastUseCase(
            longitude = cityGeo.longitude,
            latitude = cityGeo.latitude,
        )

        // map LocationApiResponse and ForecastApiResponse to CityForecastDto
        return CityForecastDto(
            cityId = cityForecast.cityId,
            name = cityGeo.name,
            fetchTimestamp = cityForecast.timestamp.toString(),
            longitude = cityGeo.longitude,
            latitude = cityGeo.latitude,
            countryCode = cityGeo.country,
            sunrise = cityForecast.sysInfo?.sunrise.toString(),
            sunset = cityForecast.sysInfo?.sunset.toString(),
            tempCurrent = cityForecast.main?.temp?.roundToInt() ?: 0,
            tempFeelsLike = cityForecast.main?.feelsLike?.roundToInt() ?: 0,
            tempMin = cityForecast.main?.tempMin?.roundToInt() ?: 0,
            tempMax = cityForecast.main?.tempMax?.roundToInt() ?: 0,
            pressure = cityForecast.main?.pressure?.roundToInt() ?: 0,
            humidity = cityForecast.main?.humidity?.roundToInt() ?: 0,
            weatherTitle = cityForecast.weather?.firstOrNull()?.main ?: "",
            weatherDescription = cityForecast.weather?.firstOrNull()?.description ?: "",
            weatherIcon = cityForecast.weather?.firstOrNull()?.icon ?: "",
            windSpeed = cityForecast.wind?.speed?.roundToInt() ?: 0,
            windDegree = cityForecast.wind?.degree?.roundToInt() ?: 0,
            partedForecast = cityPartedForecast.partedForecastForFiveDays
        )
    }
}