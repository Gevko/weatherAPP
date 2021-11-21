package com.example.myapplication.datalayer.repositories

import android.util.Log
import com.example.myapplication.data.models.WeatherInfo
import com.example.myapplication.datalayer.services.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val LISBON = "Lisbon"
private const val MADRID = "Madrid"
private const val PARIS = "Paris"
private const val BERLIN = "Berlin"
private const val COPENHAGEN = "Copenhagen"
private const val ROME = "Rome"
private const val LONDON = "London"
private const val DUBLIN = "Dublin"
private const val PRAGUE = "Prague"
private const val VIENNA = "Vienna"

class WeatherRepository {

    private val service = RetrofitService()

    suspend fun getWeatherCitiesInfo(currentLat: String?, currentLon: String?): List<WeatherInfo> = withContext(Dispatchers.IO) {
        val citiesList = listOf(LISBON, MADRID, PARIS, BERLIN, COPENHAGEN, ROME,LONDON, DUBLIN, PRAGUE, VIENNA)

        val weatherInfos = mutableListOf<WeatherInfo>()

        if(!currentLat.isNullOrBlank() && !currentLon.isNullOrBlank())
        {
            weatherInfos.add(getInfoByCoordinates(currentLat, currentLon))
        }

        citiesList.forEach {
            val weatherResponse = getInfoByName(it)
            weatherInfos.add(weatherResponse)
        }

        return@withContext weatherInfos
    }

    private suspend fun getInfoByCoordinates(lat: String, lon: String): WeatherInfo {
        return service.getInfoByCoordinates(lat, lon)
    }

    private suspend fun getInfoByName(name: String): WeatherInfo {
        return service.getInfoByName(name)
    }
}