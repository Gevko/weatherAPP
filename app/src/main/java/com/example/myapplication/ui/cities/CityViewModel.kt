package com.example.myapplication.ui.cities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.models.Event
import com.example.myapplication.data.models.WeatherInfo
import com.example.myapplication.datalayer.repositories.WeatherRepository
import kotlinx.coroutines.launch

class CityViewModel : ViewModel() {

    private val _goToWeatherDetails: MutableLiveData<Event<WeatherInfo>> = MutableLiveData()
    val goToWeatherDetails: LiveData<Event<WeatherInfo>> = _goToWeatherDetails

    private val _weatherInfoList = MutableLiveData<List<WeatherInfo>>()
    val weatherInfoList: LiveData<List<WeatherInfo>> = _weatherInfoList

    private val weatherRepository = WeatherRepository()

    fun onCitySelected(weatherInfo: WeatherInfo) {
        _goToWeatherDetails.value = Event(weatherInfo)
    }

    fun getCitiesWeatherInfo(currentLat: String?, currentLon: String?) {
        viewModelScope.launch {
            _weatherInfoList.value = weatherRepository.getWeatherCitiesInfo(currentLat, currentLon)
        }
    }
}