package com.example.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.example.weatherapp.data.toQ
import com.example.weatherapp.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.suspendCancellableCoroutine

class LocationRepositoryImpl(private val locationClient: FusedLocationProviderClient,
                             private val application: Application,
                             private val storage: LocationStorage
): LocationRepository {
    override suspend fun getLocation(): String {
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if(!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled) {
            return storage.get() ?: "0, 0"
        }

        return suspendCancellableCoroutine<Location?> { cont ->
            locationClient.lastLocation.apply {
                if(isComplete) {
                    if(isSuccessful) {
                        storage.save(result.toQ())
                        cont.resume(result, onCancellation = null)
                    } else {
                        cont.resume(null,  onCancellation = null)
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    storage.save(result.toQ())
                    cont.resume(it, onCancellation = null)
                }
                addOnFailureListener {
                    cont.resume(null,  onCancellation = null)
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }?.toQ() ?: storage.get() ?: "0, 0"

    }
}