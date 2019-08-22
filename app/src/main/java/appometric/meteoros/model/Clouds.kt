package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Clouds(
    @SerializedName("all")
    private var all: Int
): Serializable {
    fun getAll() = all
}
