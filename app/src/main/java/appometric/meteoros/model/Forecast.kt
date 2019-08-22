package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Forecast(
    @SerializedName("coord")
    private var coord: Coord? = null,
    @SerializedName("weather")
    private var weather: List<Weather>? = null,
    @SerializedName("base")
    private var base: String? = null,
    @SerializedName("main")
    private var main: Main? = null,
    @SerializedName("visibility")
    private var visibility: Int = 0,
    @SerializedName("wind")
    private var wind: Wind? = null,
    @SerializedName("clouds")
    private var clouds: Clouds? = null,
    @SerializedName("dt")
    private var dt: Int = 0,
    @SerializedName("sys")
    private var sys: Sys? = null,
    @SerializedName("timezone")
    private var timezone: Int = 0,
    @SerializedName("id")
    private var cityId: Int = 0,
    @SerializedName("name")
    private var name: String? = null,
    @SerializedName("cod")
    private var cod: Int = 0
): Serializable {
    fun getCoord() = coord
    fun getWeather() = weather
    fun getBase() = base
    fun getMain() = main
    fun getVisibility() = visibility
    fun getWind() = wind
    fun getClouds() = clouds
    fun getDt() = dt
    fun getSys() = sys
    fun getTimezone() = timezone
    fun getCityId() = cityId
    fun getName() = name
    fun getCod() = cod
}