package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Forecast(
    @SerializedName("coord")
    val coord: Coord? = null,
    @SerializedName("weather")
    val weather: List<Weather>? = null,
    @SerializedName("base")
    val base: String? = null,
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("visibility")
    val visibility: Int = 0,
    @SerializedName("wind")
    val wind: Wind? = null,
    @SerializedName("clouds")
    val clouds: Clouds? = null,
    @SerializedName("dt")
    val dt: Int = 0,
    @SerializedName("sys")
    val sys: Sys? = null,
    @SerializedName("timezone")
    val timezone: Int = 0,
    @SerializedName("id")
    val cityId: Int = 0,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("cod")
    val cod: Int = 0
): Serializable