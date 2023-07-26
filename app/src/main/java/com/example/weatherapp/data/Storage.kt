package com.example.weatherapp.data

interface Storage<T> {

    fun get(): T
    fun save(value: T)

}