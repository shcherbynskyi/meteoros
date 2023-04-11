package appometric.meteoros.feature.weather.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastApiResponse(
    @SerializedName("id")
    val cityId: Int = 0,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("timezone")
    val timezone: Int = 0,
    @SerializedName("dt")
    val timestamp: Int = 0,
    @SerializedName("coord")
    val coordinates: Coordinates? = null,
    @SerializedName("sys")
    val sysInfo: SysInfo? = null,
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
    @SerializedName("wind")
    val wind: Wind? = null,
) : Parcelable

@Parcelize
data class Coordinates(
    @SerializedName("lon")
    val longitude: Double,
    @SerializedName("lat")
    val latitude: Double
) : Parcelable

@Parcelize
data class SysInfo(
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long
) : Parcelable

@Parcelize
data class Main(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("pressure")
    val pressure: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double
) : Parcelable

@Parcelize
data class Weather(
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
) : Parcelable

@Parcelize
data class Wind(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val degree: Double
) : Parcelable