package com.globalseguridad.panicbutton.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.globalseguridad.panicbutton.presentation.screens.setting.*

fun NavGraphBuilder.settingNavGraph(navController: NavHostController) {
    navigation(
        startDestination = ScreensNavigation.SettingScreen.name,
        route = "setting"
    ) {
        composable(ScreensNavigation.SettingScreen.name) {
            SettingScreen(navController = navController)
        }
        composable(ScreensNavigation.TutorRegistrationScreen.name) {
            TutorRegistrationScreen(navController=navController,null)
        }
        composable(ScreensNavigation.WardScreen.name) {
            // Implement your WardScreen composable here
        }
        composable(ScreensNavigation.ActivityHistoryScreen.name) {
            ActivityHistoryScreen(navController=navController)
        }
        composable(ScreensNavigation.NotificationScreen.name) {
            NotificationScreen(navController=navController)
        }
        composable(ScreensNavigation.DeviceListScreen.name) {
            DeviceListScreen()
        }
    }
}
