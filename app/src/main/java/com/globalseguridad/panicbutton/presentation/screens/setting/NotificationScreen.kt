package com.globalseguridad.panicbutton.presentation.screens.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.viewmodel.NotificationHistoryViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun NotificationScreen(
    navController: NavHostController,
    viewModel: NotificationHistoryViewModel = viewModel()
) {
    val notificationHistoryList by viewModel.notificationHistoryList.collectAsState()

    BaseScreen(
        navController = navController,
        topBarTitle = "Historial de Notificaciones",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notificationHistoryList) { notification ->
                NotificationItem(notification)
            }
        }
    }
}

@Composable
fun NotificationItem(notification: String) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = notification,
                style = MaterialTheme.typography.titleMedium,
            )
            if (expanded) {
                // Puedes agregar más detalles de la notificación aquí si lo deseas
                // Por ejemplo, fecha, hora, etc.
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    val navController = rememberNavController()
    NotificationScreen(navController = navController)
}
