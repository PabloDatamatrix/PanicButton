package com.globalseguridad.panicbutton.data

import android.content.Context
import com.minew.beaconplus.sdk.MTCentralManager
import com.minew.beaconplus.sdk.MTFrameHandler
import com.minew.beaconplus.sdk.MTPeripheral
import com.minew.beaconplus.sdk.enums.BluetoothState
import com.minew.beaconplus.sdk.interfaces.MTCentralManagerListener
import com.minew.beaconplus.sdk.interfaces.OnBluetoothStateChangedListener

class MTCentralManagerDataSource(context: Context) {

    private val mtCentralManager = MTCentralManager.getInstance(context)

    fun setBluetoothStateChangedListener(listener: (BluetoothState) -> Unit) {
        mtCentralManager.setBluetoothChangedListener(object : OnBluetoothStateChangedListener {
            override fun onStateChanged(state: BluetoothState) {
                listener(state)
            }
        })
    }

    fun startScan(onDevicesScanned: (List<MTPeripheral>) -> Unit) {
        mtCentralManager.startScan()
        mtCentralManager.setMTCentralManagerListener(object : MTCentralManagerListener {
            override fun onScanedPeripheral(peripherals: List<MTPeripheral>) {
                onDevicesScanned(peripherals)
            }
        })
    }

    fun stopScan() {
        mtCentralManager.stopScan()
    }

    fun clearCache() {
        mtCentralManager.clear()
    }

    fun isScanning(): Boolean {
        return mtCentralManager.isScanning
    }
}
