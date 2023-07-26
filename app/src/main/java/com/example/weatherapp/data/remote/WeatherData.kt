package com.example.weatherapp.data.remote

data class WeatherData(
    val location: LocalData,
    val current: CurrentData,
    val forecast: ForecastData)

data class LocalData(
    val name: String,
    val localtime: String)

data class CurrentData(
    val temp_c: Double,
    val condition: ConditionData,
    val wind_mph: Double,
    val wind_dir: String,
    val humidity: Int,
    val uv: Double)

data class ConditionData(
    val text: String,
    val icon: String)

data class ForecastData(
    val forecastday: List<ForecastdayData>
)

data class ForecastdayData(
    val date: String,
    val day: DayData
)

data class DayData(
    val maxtemp_c: Float,
    val mintemp_c: Float,
    val condition: ConditionData
)