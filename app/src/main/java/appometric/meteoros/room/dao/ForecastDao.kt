package appometric.meteoros.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import appometric.meteoros.model.Forecast

@Dao
interface ForecastDao {

    @Insert
    fun create(forecast: Forecast)

    @Query("select * from forecasts")
    fun readAll(): List<Forecast>

    @Delete
    fun delete(forecast: Forecast)

}