package appometric.meteoros.feature.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appometric.meteoros.feature.weather.data.model.ForecastDto
import appometric.meteoros.feature.weather.data.source.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val _forecastList: MutableLiveData<List<ForecastDto>> = MutableLiveData()
    val forecastList: LiveData<List<ForecastDto>> = _forecastList

    private val _forecast: MutableLiveData<ForecastDto> = MutableLiveData()
    val forecast: LiveData<ForecastDto> = _forecast

    fun updateSavedForecasts() {
        // TODO implement
    }

    fun fetchForecastByCityName(cityName: String) {
        if (cityName.isEmpty() || cityName.isBlank()) return

        viewModelScope.launch {
            val geocodingList = forecastRepository.fetchGeocodingByCityName(
                cityName = cityName
            )

            if (geocodingList.isEmpty().not()) {

                val geocoding = geocodingList[0]

                val forecast = forecastRepository.fetchForecastByCoordinates(
                    longitude = geocoding.longitude,
                    latitude = geocoding.latitude
                )
                _forecast.postValue(forecast)
            }
        }
    }
}