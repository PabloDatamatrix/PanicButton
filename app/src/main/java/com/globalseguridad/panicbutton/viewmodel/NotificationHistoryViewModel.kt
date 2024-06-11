package com.globalseguridad.panicbutton.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotificationHistoryViewModel : ViewModel() {

    private val _notificationHistoryList = MutableStateFlow<List<String>>(emptyList())
    val notificationHistoryList: StateFlow<List<String>> get() = _notificationHistoryList

    init {
        // Simulación de datos, reemplazar con datos reales si es necesario
        viewModelScope.launch {
            _notificationHistoryList.value = listOf(
                "Notificación 1: Detalles de la notificación 1...",
                "Notificación 2: Detalles de la notificación 2...",
                "Notificación 3: Detalles de la notificación 3..."
            )
        }
    }

    fun addNotification(notification: String) {
        val updatedList = _notificationHistoryList.value.toMutableList()
        updatedList.add(notification)
        _notificationHistoryList.value = updatedList
    }

    fun clearHistory() {
        _notificationHistoryList.value = emptyList()
    }
}
