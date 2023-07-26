package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.data.location.LocationRepositoryImpl
import com.example.weatherapp.data.location.LocationStorage
import com.example.weatherapp.data.WeatherRepositoryImpl
import com.example.weatherapp.data.WeatherStorage
import com.example.weatherapp.data.remote.WeatherAPI
import com.example.weatherapp.domain.repository.LocationRepository
import com.example.weatherapp.domain.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun provideWeatherAPI(): WeatherAPI{
    return Retrofit.Builder()
        .baseUrl("http://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create()
}

fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
    return LocationServices.getFusedLocationProviderClient(app)
}

val dataModule = module {

    single<LocationStorage>{
        LocationStorage(androidApplication())
    }

    single<WeatherStorage>{
        WeatherStorage(androidApplication())
    }

    single<WeatherRepository>{
        WeatherRepositoryImpl(weatherAPI = provideWeatherAPI(), weatherStorage = get())
    }

    single<LocationRepository>{
        LocationRepositoryImpl(locationClient = provideFusedLocationProviderClient(androidApplication()),
            application = androidApplication(), storage = get())
    }


}