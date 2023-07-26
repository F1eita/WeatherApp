package com.example.weatherapp.domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getLocation(): String
}