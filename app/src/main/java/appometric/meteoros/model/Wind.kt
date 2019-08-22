package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wind(
    @SerializedName("speed")
    private var speed: Int,
    @SerializedName("deg")
    private var deg: Int
): Serializable {
    fun getSpeed() = speed
    fun getDeg() = deg
}