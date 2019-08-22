package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weather(
    @SerializedName("id")
    private var id: Int,
    @SerializedName("main")
    private var main: String,
    @SerializedName("description")
    private var description: String,
    @SerializedName("icon")
    private var icon: String
): Serializable {
    fun getId() = id
    fun getMain() = main
    fun getDescription() = description
    fun getIcon() = icon
}