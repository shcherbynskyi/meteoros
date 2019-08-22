package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Sys(
    @SerializedName("type")
    private var type: Int,
    @SerializedName("id")
    private var id: Int,
    @SerializedName("message")
    private var message: Float,
    @SerializedName("country")
    private var country: String,
    @SerializedName("sunrise")
    private var sunrise: Int,
    @SerializedName("sunset")
    private var sunset: Int
): Serializable {
    fun getType() = type
    fun getId() = id
    fun getMessage() = message
    fun getCountry() = country
    fun getSunrise() = sunrise
    fun getSunset() = sunset
}
