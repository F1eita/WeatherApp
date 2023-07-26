package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.appModule
import com.example.weatherapp.di.dataModule
import com.example.weatherapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApp)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }
}