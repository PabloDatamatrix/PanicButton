package com.globalseguridad.panicbutton.domain

import com.globalseguridad.panicbutton.data.DeviceRepository
import com.minew.beaconplus.sdk.MTPeripheral
import com.minew.beaconplus.sdk.enums.BluetoothState

class DeviceUseCases(private val repository: DeviceRepository) {

    fun setBluetoothStateChangedListener(listener: (BluetoothState) -> Unit) {
        repository.setBluetoothStateChangedListener(listener)
    }

    fun startScan(onDevicesScanned: (List<MTPeripheral>) -> Unit) {
        repository.startScan(onDevicesScanned)
    }

    fun stopScan() {
        repository.stopScan()
    }

    fun clearCache() {
        repository.clearCache()
    }

    fun isScanning(): Boolean {
        return repository.isScanning()
    }
}
