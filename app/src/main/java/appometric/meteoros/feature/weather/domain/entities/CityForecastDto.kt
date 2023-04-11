package appometric.meteoros.feature.weather.domain.entities

import android.os.Parcelable
import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityForecastDto(
    // root
    var cityId: Int = 0,
    var name: String? = "",
    var fetchTimestamp: String,

    // coordinates
    var longitude: Double = 0.0,
    var latitude: Double = 0.0,

    // system
    var countryCode: String = "",
    var sunrise: String = "",
    var sunset: String = "",

    // main
    var tempCurrent: Int = 0,
    var tempFeelsLike: Int = 0,
    var tempMin: Int = 0,
    var tempMax: Int = 0,
    var pressure: Int = 0,
    var humidity: Int = 0,

    // weather
    var weatherTitle: String = "",
    var weatherDescription: String = "",
    var weatherIcon: String = "",

    // wind
    var windSpeed: Int = 0,
    var windDegree: Int = 0,

    // parted forecast
    var partedForecast: List<ForecastApiResponse>? = null
): Parcelable