package com.example.weatherapp.presentation

import com.example.weatherapp.R
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.DayOfWeekWeather
import com.example.weatherapp.domain.model.Weather

data class WeatherState(
    val weather: Weather = Weather(CurrentWeather(location = "",
        condition = "cloudy", icon = R.drawable.cloud, humidity = 0, temperature = 0.0,
        uv =0.0, windSpeed = 0.0, windDirection = ""),
        emptyList()),
    val isShowProgressBar: Boolean = false
)