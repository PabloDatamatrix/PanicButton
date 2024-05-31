package com.globalseguridad.panicbutton.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.globalseguridad.panicbutton.presentation.screens.PermissionScreen
import com.globalseguridad.panicbutton.presentation.screens.Profile
import com.globalseguridad.panicbutton.presentation.screens.Setting
import com.globalseguridad.panicbutton.presentation.screens.SplashScreen
import com.globalseguridad.panicbutton.presentation.screens.ubication.Ubication
import com.globalseguridad.panicbutton.presentation.screens.home.Home
import com.globalseguridad.panicbutton.presentation.screens.login.LoginScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreensNavigation.SplashScreen.name,
    ) {
        composable(ScreensNavigation.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(ScreensNavigation.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(ScreensNavigation.PermissionScreen.name) {
            PermissionScreen(navController = navController)
        }
        composable(ScreensNavigation.HomeScreen.name) {
            Home(navController = navController)
        }
        composable(ScreensNavigation.UbicationScreen.name) {
            Ubication(navController = navController)
        }
        composable(ScreensNavigation.ProfileScreen.name) {
            Profile(navController = navController)
        }
        composable(ScreensNavigation.SettingScreen.name) {
            Setting(navController = navController)
        }
    }
}


