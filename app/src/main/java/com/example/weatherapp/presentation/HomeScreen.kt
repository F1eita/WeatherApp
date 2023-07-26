package com.example.weatherapp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.StiffnessLow
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.components.*
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()

    val thumbOffsetY = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    val dragLimitVerticalPxTop = 0.dp.dpToPx()
    val dragLimitVerticalPxBottom = 30.dp.dpToPx()

    if (state.isShowProgressBar){
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = Color.Gray.copy(alpha = 0.5f)
            )
        }
    }

    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .offset {
            IntOffset(0, thumbOffsetY.value.toInt())
        }
        .pointerInput(Unit) {
            forEachGesture {
                awaitPointerEventScope {
                    awaitFirstDown()
                    do {
                        val event = awaitPointerEvent()
                        event.changes.forEach { pointerInputChange ->
                            scope.launch {
                                val targetValue =
                                    thumbOffsetY.value + pointerInputChange.positionChange().y

                                val targetValueWithinBounds = targetValue.coerceIn(
                                    dragLimitVerticalPxTop,
                                    dragLimitVerticalPxBottom
                                )

                                thumbOffsetY.snapTo(targetValueWithinBounds)

                            }
                        }
                    } while (event.changes.any { it.pressed })

                    if (thumbOffsetY.value.absoluteValue >= dragLimitVerticalPxBottom) {
                        viewModel.updateWeather()
                    }

                    scope.launch {
                        if (thumbOffsetY.value != 0f) {
                            thumbOffsetY.animateTo(
                                targetValue = 0f,
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = StiffnessLow
                                )
                            )
                        }
                    }
                }
            }
        }) {
        Text(
            text = "Today.",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(4.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            CurrentWeatherCard(state)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            Text(
                text = "Information:",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(4.dp)
            )
            Cards(state)
        }
        Text(
            text = "Week:",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(4.dp)
        )
        WeekCards(state)
    }
}

@Composable
private fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }

