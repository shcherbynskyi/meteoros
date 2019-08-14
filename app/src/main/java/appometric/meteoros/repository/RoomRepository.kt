package appometric.meteoros.repository

import appometric.meteoros.App
import appometric.meteoros.model.Forecast
import appometric.meteoros.room.AppDatabase

class RoomRepository {

    fun saveForecastData(forecast: Forecast) {
        AppDatabase.getDatabase(App.getAppContext())
                .forecastDao()
                .create(forecast)
    }

    fun getForecastData(): List<Forecast> {
        return AppDatabase.getDatabase(App.getAppContext())
                .forecastDao()
                .readAll()
    }

    fun deleteForecastData(forecast: Forecast) {
        AppDatabase.getDatabase(App.getAppContext())
                .forecastDao()
                .delete(forecast)
    }

}