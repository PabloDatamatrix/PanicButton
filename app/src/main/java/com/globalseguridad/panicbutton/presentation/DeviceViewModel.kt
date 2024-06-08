package com.globalseguridad.panicbutton.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globalseguridad.panicbutton.domain.DeviceUseCases
import com.minew.beaconplus.sdk.MTPeripheral
import com.minew.beaconplus.sdk.enums.BluetoothState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DeviceViewModel(private val deviceUseCases: DeviceUseCases) : ViewModel() {

    private val _bluetoothState = MutableStateFlow<BluetoothState?>(null)
    val bluetoothState: StateFlow<BluetoothState?> = _bluetoothState

    private val _devices = MutableStateFlow<List<MTPeripheral>>(emptyList())
    val devices: StateFlow<List<MTPeripheral>> = _devices

    fun initializeBluetoothListener() {
        deviceUseCases.setBluetoothStateChangedListener { state ->
            _bluetoothState.value = state
        }
    }

    fun startScanning() {
        viewModelScope.launch {
            deviceUseCases.startScan { peripherals ->
                _devices.value = peripherals
            }
        }
    }

    fun stopScanning() {
        deviceUseCases.stopScan()
    }

    fun clearCache() {
        deviceUseCases.clearCache()
    }

    fun isScanning(): Boolean {
        return deviceUseCases.isScanning()
    }
}
