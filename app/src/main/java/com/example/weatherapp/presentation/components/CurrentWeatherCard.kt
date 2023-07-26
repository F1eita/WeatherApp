package com.example.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.WeatherState

@Composable
fun CurrentWeatherCard(state: WeatherState) {
    Row(){
        Column(
            horizontalAlignment = Alignment.End
        ){
            Text(text = state.weather.currentWeather.location,
                style = MaterialTheme.typography.h3, textAlign = TextAlign.End)
            Text(text = "${state.weather.currentWeather.temperature.toInt()}°",
                style = MaterialTheme.typography.h1)
        }
        Column(){
            Image(modifier = Modifier.size(72.dp).padding(2.dp),
                painter = painterResource(id = state.weather.currentWeather.icon),
                contentDescription = "Weather Type", alignment = Alignment.Center,
                contentScale = ContentScale.Crop)
        }

    }
}