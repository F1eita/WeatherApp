package com.example.weatherapp.data

import android.location.Location

fun Location.toQ(): String{
    return "$latitude, $longitude"
}