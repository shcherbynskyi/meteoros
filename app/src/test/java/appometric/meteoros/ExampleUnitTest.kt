package appometric.meteoros

import appometric.meteoros.model.Forecast
import com.google.android.gms.maps.model.LatLng
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkList() {

        val forecast = Forecast("Kyiv", "UA", 25.0, 45.7, 45, "Clouds")

        val list = mutableListOf<Forecast>()

        list.add(Forecast("Kyiv", "UA", 25.0, 45.7, 19, "Clouds"))
        list.add(Forecast("Lviv", "UA", 35.0, 42.7, 18, "Clouds"))
        list.add(Forecast("Odesa", "UA", 45.0, 40.7, 23, "Sunny"))
        list.add(Forecast("Kharkiv", "UA", 55.0, 38.7, 21, "Sunny"))
        list.add(Forecast("Dnipro", "UA", 65.0, 36.7, 15, "Raining"))

        val result = list.filter {
            it.getLatitude() == forecast.getLatitude()
            it.getLongitude() == forecast.getLongitude()
        }

        println(result)

    }

}