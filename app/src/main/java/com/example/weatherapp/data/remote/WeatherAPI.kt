package com.example.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
@GET("forecast.json")
    suspend fun getWeatherData(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherData
}