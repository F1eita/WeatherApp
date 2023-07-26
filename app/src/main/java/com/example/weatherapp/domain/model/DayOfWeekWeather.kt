package com.example.weatherapp.domain.model

import com.example.weatherapp.R

data class DayOfWeekWeather(val date: String, val dayOfWeek: String, val condition: String,
                            val icon: Int = R.drawable.sunny, val maxTemperature: Float,
                            val minTemperature: Float)
