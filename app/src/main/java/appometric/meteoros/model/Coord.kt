package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Coord(
    @SerializedName("lon")
    private var lon: Float,
    @SerializedName("lat")
    private var lat: Float
): Serializable {
    fun getLon() = lon
    fun getLat() = lat
}