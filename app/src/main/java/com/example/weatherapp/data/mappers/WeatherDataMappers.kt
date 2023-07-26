package com.example.weatherapp.data.remote

import com.example.weatherapp.R
import com.example.weatherapp.domain.model.CurrentWeather
import com.example.weatherapp.domain.model.DayOfWeekWeather
import com.example.weatherapp.domain.model.Weather
import java.time.LocalDate

fun WeatherData.toCurrentWeather(): CurrentWeather{
    return CurrentWeather(location = location.name,
        temperature = current.temp_c,
        condition = current.condition.text,
        humidity = current.humidity,
        icon = getIcon(condition = current.condition.text),
        uv = current.uv,
        windSpeed = current.wind_mph * 0.44704,
        windDirection = current.wind_dir)
}

fun WeatherData.toDayOfWeekWeather(i: Int): DayOfWeekWeather{
    val dayOfWeek: String
    when (i){
        0 -> dayOfWeek = "Today"
        1 -> dayOfWeek = "Tomorrow"
        else -> {
            val date = LocalDate.parse(forecast.forecastday[i].date)
            dayOfWeek = date.dayOfWeek.name
        }
    }
    val date = forecast.forecastday[i].date.slice(8..9) + "/" +
            forecast.forecastday[i].date.slice(5..6)
    return DayOfWeekWeather(date = date,
        dayOfWeek = dayOfWeek.lowercase().capitalize(),
        condition = forecast.forecastday[i].day.condition.text,
        icon = getIcon(condition = forecast.forecastday[i].day.condition.text),
        maxTemperature = forecast.forecastday[i].day.maxtemp_c,
        minTemperature = forecast.forecastday[i].day.mintemp_c)
}

fun WeatherData.toWeekWeather(): List<DayOfWeekWeather>{
    return List(forecast.forecastday.size){toDayOfWeekWeather(it)}
}

fun WeatherData.toWeather(): Weather{
    return Weather(toCurrentWeather(), toWeekWeather())
}

fun getIcon(condition: String): Int{
    if (condition.contains("rain", ignoreCase = true)) return R.drawable.rainy
    if (condition.contains("drizzle", ignoreCase = true)) return R.drawable.rainy
    if (condition.contains("partly cloudy", ignoreCase = true)) return R.drawable.semi_cloud
    if (condition.contains("cloud", ignoreCase = true)) return R.drawable.cloud
    if (condition.contains("sunny", ignoreCase = true)) return R.drawable.sunny
    if (condition.contains("thunder", ignoreCase = true)) return R.drawable.thunder
    if (condition.contains("snow", ignoreCase = true)) return R.drawable.snowfall
    return R.drawable.cloud
}