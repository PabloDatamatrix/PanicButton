package com.globalseguridad.panicbutton.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globalseguridad.panicbutton.presentation.screens.setting.ActivityHistory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ActivityHistoryViewModel : ViewModel() {

    private val _activityHistoryList = MutableStateFlow<List<ActivityHistory>>(emptyList())
    val activityHistoryList: StateFlow<List<ActivityHistory>> get() = _activityHistoryList

    init {
        // Simulación de datos, reemplazar con datos reales
        viewModelScope.launch {
            _activityHistoryList.value = listOf(
                ActivityHistory("1", "Actividad 1", "2024-01-01", "Detalles de la actividad 1..."),
                ActivityHistory("2", "Actividad 2", "2024-01-02", "Detalles de la actividad 2..."),
                ActivityHistory("3", "Actividad 3", "2024-01-03", "Detalles de la actividad 3...")
            )
        }
    }
}
