package com.globalseguridad.panicbutton.presentation.screens.setting

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.globalseguridad.panicbutton.data.DeviceRepository
import com.globalseguridad.panicbutton.data.MTCentralManagerDataSource
import com.globalseguridad.panicbutton.presentation.DeviceViewModel
import com.minew.beaconplus.sdk.MTPeripheral

@Composable
fun DeviceListScreen() {
    val context = LocalContext.current
    val mtCentralManagerDataSource = remember { MTCentralManagerDataSource(context) }
    val deviceRepository = remember { DeviceRepository(mtCentralManagerDataSource) }
    val deviceViewModel: DeviceViewModel = viewModel(factory = viewModelFactory {
        initializer {
            DeviceViewModel(deviceRepository)
        }
    })

    val bluetoothState by deviceViewModel.bluetoothState.collectAsState()
    val devices by deviceViewModel.devices.collectAsState()

    DisposableEffect(Unit) {
        deviceViewModel.initializeBluetoothListener()
        deviceViewModel.startScanning()

        onDispose {
            deviceViewModel.stopScanning()
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Bluetooth State: $bluetoothState")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(devices) { device ->
                DeviceItem(device)
            }
        }
    }
}

@Composable
fun DeviceItem(device: MTPeripheral) {
    val mtFrameHandler = device.mMTFrameHandler
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${mtFrameHandler.getName()}")
            Text(text = "MAC: ${mtFrameHandler.getMac()}")
            Text(text = "Battery: ${mtFrameHandler.getBattery()}")
            Text(text = "RSSI: ${mtFrameHandler.getRssi()}")
            Text(text = "Last Update: ${mtFrameHandler.getLastUpdate()}")
        }
    }
}
