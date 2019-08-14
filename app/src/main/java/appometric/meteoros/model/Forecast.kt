package appometric.meteoros.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "forecasts")
data class Forecast(
    @ColumnInfo(name = "city")
    private var city: String,

    @ColumnInfo(name = "country")
    private var country: String,

    @ColumnInfo(name = "longitude")
    private var longitude: Double,

    @ColumnInfo(name = "latitude")
    private var latitude: Double,

    @ColumnInfo(name = "temperature")
    private var temperature: Int
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    fun getCity() = city

    fun getCountry() = country

    fun getLongitude() = longitude

    fun getLatitude() = latitude

    fun getTemperature() = temperature

}