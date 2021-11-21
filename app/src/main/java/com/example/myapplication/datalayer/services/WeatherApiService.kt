package com.example.myapplication.datalayer.services

import com.example.myapplication.data.models.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("data/2.5/weather")
    suspend fun getInfoByCoordinates(@Query("lat") lat: String, @Query("lon") lon: String, @Query("appid") apiId: String): WeatherInfo

    @GET("data/2.5/weather")
    suspend fun getInfoByName(@Query("q") name: String, @Query("appid") apiId: String): WeatherInfo
}