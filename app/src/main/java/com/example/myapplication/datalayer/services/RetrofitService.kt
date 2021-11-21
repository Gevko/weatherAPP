package com.example.myapplication.datalayer.services

import com.example.myapplication.data.models.WeatherInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "https://api.openweathermap.org"

class RetrofitService {

    private val apiKey = "fe42c7afd39554c9a12d13f5f4fe4d49"

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var service: WeatherApiService = retrofit.create(WeatherApiService::class.java)

    suspend fun getInfoByCoordinates(lat: String, lon: String): WeatherInfo {
        return service.getInfoByCoordinates(lat, lon, apiKey)
    }

    suspend fun getInfoByName(name: String): WeatherInfo {
        return service.getInfoByName(name, apiKey)
    }

}