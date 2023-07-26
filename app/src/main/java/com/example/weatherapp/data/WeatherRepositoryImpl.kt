package com.example.weatherapp.data


import com.example.weatherapp.data.remote.WeatherAPI
import com.example.weatherapp.data.remote.WeatherData
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val weatherAPI: WeatherAPI,
                            private val weatherStorage: WeatherStorage): WeatherRepository {

    override suspend fun getWeather(q: String): WeatherData? {
        return try{
            val value = weatherAPI.getWeatherData(key = "787fec47e2fc4542a36131612232407", q = q, days = 7)
            weatherStorage.save(value)
            return value

        }
        catch(e: Exception){
            weatherStorage.get()
        }

    }

}