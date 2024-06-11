package com.globalseguridad.panicbutton.presentation.screens.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen
import com.globalseguridad.panicbutton.viewmodel.ProfileViewModel

data class SettingSection(val title: String, val screen: ScreensNavigation)

val settingSections = listOf(
    SettingSection("Registro de tutor", ScreensNavigation.TutorRegistrationScreen),
    SettingSection("Tutelados", ScreensNavigation.WardScreen),
    SettingSection("Historial de actividades", ScreensNavigation.ActivityHistoryScreen),
    SettingSection("Notificaciones", ScreensNavigation.NotificationScreen),
    SettingSection("Dispositivo MINEW", ScreensNavigation.DeviceListScreen)
)

@Composable
fun SettingScreen(navController: NavHostController, viewModel: ProfileViewModel = viewModel()) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Ajustes",
        backgroundColor = Color.Gray
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(settingSections) { section ->
                SettingSectionItem(section = section) {
                    viewModel.navigateToSection(navController, section.screen)
                }
            }
        }
    }
}

@Composable
fun SettingSectionItem(section: SettingSection, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.secondary_gs))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Forward Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
