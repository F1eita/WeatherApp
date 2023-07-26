package com.example.weatherapp.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapp.presentation.WeatherState

@Composable
fun WeekCards(state: WeatherState){
    val scrollState = rememberScrollState()
    Row(modifier = Modifier
        .fillMaxSize()
        .horizontalScroll(state = scrollState)){
        state.weather.weekWeather.forEach{
                day -> WeekDayCard(weekDay = day.dayOfWeek, date = day.date,
            id = day.icon, weather = day.condition,
            minMaxTemp = "${day.maxTemperature.toInt()}/${day.minTemperature.toInt()}°C")
        }
    }
}