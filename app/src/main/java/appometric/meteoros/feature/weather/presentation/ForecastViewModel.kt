package appometric.meteoros.feature.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.data.source.ForecastRepository
import appometric.meteoros.feature.weather.domain.entities.CityForecastDto
import appometric.meteoros.feature.weather.domain.usecases.SubscribeToCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val subscribeToCityUseCase: SubscribeToCityUseCase,
) : ViewModel() {

    private val _forecast: MutableLiveData<CityForecastDto> = MutableLiveData()
    val forecast: LiveData<CityForecastDto> = _forecast

    fun updateSavedForecasts() {
        // TODO implement
    }

    fun fetchForecastByCityName(cityName: String) {
        if (cityName.isEmpty() || cityName.isBlank()) return

        viewModelScope.launch {
            val cityForecastDto = subscribeToCityUseCase(cityName)
            _forecast.postValue(cityForecastDto)
        }
    }
}