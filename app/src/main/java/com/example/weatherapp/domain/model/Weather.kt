package com.example.weatherapp.domain.model

data class Weather(val currentWeather: CurrentWeather,
    val weekWeather: List<DayOfWeekWeather>)
