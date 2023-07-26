package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.remote.toWeather
import com.example.weatherapp.data.toQ
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.LocationRepository
import com.example.weatherapp.domain.repository.WeatherRepository

class UpdateWeatherUseCase(private val weatherRepository: WeatherRepository,
                           private val locationRepository: LocationRepository) {

    suspend fun execute(): Weather? {
        return weatherRepository.getWeather(locationRepository.getLocation())?.toWeather()
    }

}