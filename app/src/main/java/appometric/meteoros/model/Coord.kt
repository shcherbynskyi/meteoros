package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coord(
    @SerializedName("lon")
    val lon: Float,
    @SerializedName("lat")
    val lat: Float
): Serializable