package appometric.meteoros.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Main(
    @SerializedName("temp")
    private var temp: Int,
    @SerializedName("pressure")
    private var pressure: Int,
    @SerializedName("humidity")
    private var humidity: Int,
    @SerializedName("temp_min")
    private var tempMin: Int,
    @SerializedName("temp_max")
    private var tempMax: Int
): Serializable {
    fun getTemp() = temp
    fun getPressure() = pressure
    fun getHumidity() = humidity
    fun getTempMin() = tempMin
    fun getTempMax() = tempMax
}
