package com.example.weatherapp.data

import android.content.Context
import android.util.Log
import com.example.weatherapp.data.remote.WeatherData
import com.google.gson.Gson
import java.io.InputStreamReader

class WeatherStorage(private val context: Context): Storage<WeatherData?> {

    private val path = "weatherStorage.json"
    private val gson = Gson()

    override fun get(): WeatherData? {
        return try{
            val fileInputStream = context.openFileInput(path)
            val streamReader = InputStreamReader(fileInputStream)
            gson.fromJson(streamReader, WeatherData::class.java)
        }catch (e: Exception){
            Log.d("testGET", e.message ?: "")
            null
        }
    }

    override fun save(value: WeatherData?) {
        val jsonString = gson.toJson(value)
        try{
            val fileOutputStream = context.openFileOutput(path, Context.MODE_PRIVATE)
            fileOutputStream.flush()
            fileOutputStream.write(jsonString.toByteArray())
        }catch (e: Exception) {
            Log.d("testSAVE", e.message ?: "")
            e.printStackTrace()
        }
    }
}