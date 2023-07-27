package com.example.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun WeekDayCard(weekDay: String = "",
date: String = "", id: Int = 0, weather: String = "", minMaxTemp: String = "") {

    Box(modifier = Modifier
            .padding(4.dp)
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxHeight().width(150.dp)
            .clip(MaterialTheme.shapes.small)){
        Column(modifier = Modifier.padding(4.dp).fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = weekDay, style = MaterialTheme.typography.h4)
                    Text(text = date, style = MaterialTheme.typography.h6)
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = id), contentDescription = "",
                            modifier = Modifier.size(48.dp))
                Text(text = weather, style = MaterialTheme.typography.h5)
            }
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            Text(text = minMaxTemp, style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(16.dp))
        }
    }

}