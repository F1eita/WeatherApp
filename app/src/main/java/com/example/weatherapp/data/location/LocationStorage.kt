package com.example.weatherapp.data.location

import android.content.Context
import com.example.weatherapp.data.Storage

const val SHARED_PREF = "shared_pref"
const val LOC_INFO = "loc_info"
class LocationStorage(context: Context): Storage<String?> {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    override fun get(): String? {
        return sharedPreferences.getString(LOC_INFO, "0, 0")
    }

    override fun save(value: String?) {
        sharedPreferences.edit().putString(LOC_INFO, value).apply()
    }
}