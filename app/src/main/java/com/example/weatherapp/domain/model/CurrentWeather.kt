package com.example.weatherapp.domain.model


data class CurrentWeather(val location: String, val temperature: Double,
                          val condition: String,
                          val icon: Int,
                          val humidity: Int, val uv: Double, val windSpeed: Double,
                          val windDirection: String)
