package com.globalseguridad.panicbutton.data.repository

import com.minew.beaconplus.sdk.MTPeripheral
import kotlinx.coroutines.flow.StateFlow

interface BeaconRepository {
    fun startScanning()
    fun stopScanning()
    fun connectToDevice(beacon: MTPeripheral, callback: (Boolean) -> Unit)
    fun getBeacons(): StateFlow<List<MTPeripheral>>
}
