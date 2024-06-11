package com.globalseguridad.panicbutton.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globalseguridad.panicbutton.data.DeviceRepository
import com.minew.beaconplus.sdk.MTPeripheral
import com.minew.beaconplus.sdk.enums.BluetoothState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DeviceViewModel(private val deviceRepository: DeviceRepository) : ViewModel() {
    private val _bluetoothState = MutableStateFlow(BluetoothState.BluetoothStatePowerOn)
    val bluetoothState: StateFlow<BluetoothState> get() = _bluetoothState

    private val _devices = MutableStateFlow<List<MTPeripheral>>(emptyList())
    val devices: StateFlow<List<MTPeripheral>> get() = _devices

    fun initializeBluetoothListener() {
        deviceRepository.setBluetoothStateChangedListener { state ->
            _bluetoothState.value = state
        }
    }

    fun startScanning() {
        viewModelScope.launch {
            deviceRepository.startScan { devices ->
                _devices.value = devices
            }
        }
    }

    fun stopScanning() {
        deviceRepository.stopScan()
    }
}
