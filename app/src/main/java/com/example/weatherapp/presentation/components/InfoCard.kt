package com.example.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InfoCard(modifier:Modifier = Modifier, header: String = "", information: String = "") {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier.padding(4.dp).background(MaterialTheme.colors.primary).width(145.dp)
                .fillMaxHeight().clip(MaterialTheme.shapes.small)
        ) {
            Text(text = header, style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(6.dp).fillMaxWidth(), textAlign = TextAlign.Center)
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(text = information, style = MaterialTheme.typography.h2)
            }
        }
    }
}