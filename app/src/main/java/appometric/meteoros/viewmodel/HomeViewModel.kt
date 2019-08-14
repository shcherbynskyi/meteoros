package appometric.meteoros.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import appometric.meteoros.App
import appometric.meteoros.model.Forecast
import appometric.meteoros.repository.RoomRepository
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    @Inject protected lateinit var roomRepository: RoomRepository
    private val forecastData = MutableLiveData<List<Forecast>>()

    init {
        // Injecting ViewModel
        App.getAppComponent().inject(this)

        // Get data from repository
        forecastData.value = roomRepository.getForecastData()
    }

    fun getForecastData() = forecastData

    fun saveForecastData(forecast: Forecast) {
        // Save data to local repository
        roomRepository.saveForecastData(forecast)

        // Create temporary list of data to add new item to mutable live data list
        val tempData = mutableListOf<Forecast>()
        tempData.addAll(forecastData.value!!)
        tempData.addAll(listOf(forecast))

        // Save live data within ViewModel
        forecastData.value = tempData
    }

    fun deleteForecastData(pos: Int) {
        roomRepository.deleteForecastData(forecastData.value!!.get(pos))
        forecastData.value = roomRepository.getForecastData()
    }

}