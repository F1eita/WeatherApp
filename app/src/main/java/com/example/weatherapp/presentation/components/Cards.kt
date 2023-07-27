package com.example.weatherapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.WeatherState

@Composable
fun Cards(state: WeatherState){
    Column(modifier = Modifier
        .fillMaxSize()){
        Row(modifier = Modifier.fillMaxHeight(0.5f)){
            InfoCard(header = "Humidity",
                information = "${state.weather.currentWeather.humidity}%",
                modifier = Modifier.fillMaxWidth(0.5f))
            InfoCard(header = "UV",
                information = state.weather.currentWeather.uv.toInt().toString(),
                modifier = Modifier.fillMaxWidth())
        }
        Row(modifier = Modifier.fillMaxHeight()){
            InfoCard(header = "Wind speed",
                information = "${state.weather.currentWeather.windSpeed.toInt()} m/s",
                modifier = Modifier.fillMaxWidth(0.5f))
            InfoCard(header = "Wind direction",
                information = state.weather.currentWeather.windDirection,
                modifier = Modifier.fillMaxWidth())
        }
    }
}