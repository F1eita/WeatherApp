package com.example.weatherapp.presentation

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.usecase.UpdateWeatherUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(private val updateWeatherUseCase: UpdateWeatherUseCase): ViewModel() {

    private var _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState>
        get() = _state

    init{
        updateWeather()
    }

    fun updateWeather(){
        CoroutineScope(Dispatchers.IO).launch {
            _state.update{weatherState ->
                weatherState.copy(isShowProgressBar = true)}
            _state.update {  weatherState ->
                weatherState.copy(weather = updateWeatherUseCase.execute() ?: state.value.weather)
            }
            _state.update{weatherState ->
                weatherState.copy(isShowProgressBar = false)}
        }
    }
}