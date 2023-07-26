package com.example.weatherapp.di

import com.example.weatherapp.domain.usecase.UpdateWeatherUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<UpdateWeatherUseCase>{
        UpdateWeatherUseCase(weatherRepository = get(), locationRepository = get())
    }

}