package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.remote.WeatherData
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.DayOfWeekWeather

interface WeatherRepository {

    suspend fun getWeather(q: String): WeatherData?

}