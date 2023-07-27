package com.example.weatherapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.weatherapp.presentation.HomeScreen
import com.example.weatherapp.presentation.WeatherViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        askLocationPermission()
        val viewModel by viewModel<WeatherViewModel>()
        setContent {
            WeatherAppTheme() {
                Surface {
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }


    private fun askLocationPermission() {
        if ((ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) or
            (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
        ) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION),1)
        }

    }


}


