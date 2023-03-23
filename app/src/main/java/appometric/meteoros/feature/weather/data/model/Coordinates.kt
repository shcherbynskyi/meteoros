package appometric.meteoros.feature.weather.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coordinates(
    @SerializedName("lon")
    val lon: Float,
    @SerializedName("lat")
    val lat: Float
): Serializable