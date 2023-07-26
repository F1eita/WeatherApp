package com.example.weatherapp.di

import com.example.weatherapp.presentation.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

    viewModel<WeatherViewModel>{
        WeatherViewModel(updateWeatherUseCase = get())
    }

}