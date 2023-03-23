package appometric.meteoros.feature.weather.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sys(
    @SerializedName("type")
    val type: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("message")
    val message: Float,
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int
): Serializable