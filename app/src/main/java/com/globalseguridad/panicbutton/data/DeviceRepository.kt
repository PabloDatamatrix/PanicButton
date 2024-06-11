package com.globalseguridad.panicbutton.data

import com.minew.beaconplus.sdk.MTPeripheral
import com.minew.beaconplus.sdk.enums.BluetoothState

class DeviceRepository(
    private val mtCentralManagerDataSource: MTCentralManagerDataSource
) {

    fun setBluetoothStateChangedListener(listener: (BluetoothState) -> Unit) {
        mtCentralManagerDataSource.setBluetoothStateChangedListener(listener)
    }

    fun startScan(onDevicesScanned: (List<MTPeripheral>) -> Unit) {
        mtCentralManagerDataSource.startScan(onDevicesScanned)
    }

    fun stopScan() {
        mtCentralManagerDataSource.stopScan()
    }

    fun clearCache() {
        mtCentralManagerDataSource.clearCache()
    }

    fun isScanning(): Boolean {
        return mtCentralManagerDataSource.isScanning()
    }
}
