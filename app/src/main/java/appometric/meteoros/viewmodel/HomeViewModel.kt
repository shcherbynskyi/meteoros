package appometric.meteoros.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import appometric.meteoros.App
import appometric.meteoros.model.Forecast
import appometric.meteoros.repository.RoomRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {

    private val _forecasts = MutableLiveData<List<Forecast>>()
    val forecasts: LiveData<List<Forecast>> = _forecasts

    init {
        _forecasts.postValue(roomRepository.getForecastData())
    }

    fun getForecastData() = _forecasts

    fun saveForecastData(forecast: Forecast) {

        // Save data to local repository
        roomRepository.saveForecastData(forecast)

        // Create temporary list of data to add new item to mutable live data list
        val tempData = mutableListOf<Forecast>()
        tempData.addAll(_forecasts.value!!)
        tempData.addAll(listOf(forecast))

        // Save live data within ViewModel
        _forecasts.postValue(tempData)
    }

    fun deleteForecastData(pos: Int) {
        roomRepository.deleteForecastData(_forecasts.value!!.get(pos))
        _forecasts.value = roomRepository.getForecastData()
    }
}