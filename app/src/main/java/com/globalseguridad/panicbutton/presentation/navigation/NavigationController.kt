package com.globalseguridad.panicbutton.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.globalseguridad.panicbutton.presentation.screens.permission.PermissionScreen
import com.globalseguridad.panicbutton.presentation.screens.profile.Profile
import com.globalseguridad.panicbutton.presentation.screens.setting.Setting
import com.globalseguridad.panicbutton.presentation.screens.splash.SplashScreen
import com.globalseguridad.panicbutton.presentation.screens.ubication.Ubication
import com.globalseguridad.panicbutton.presentation.screens.home.Home
import com.globalseguridad.panicbutton.presentation.screens.login.LoginScreen
import com.globalseguridad.panicbutton.presentation.screens.ubication.UserDetailsScreen

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
        composable("${ScreensNavigation.UserDetailsScreen.name}/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            UserDetailsScreen(navController = navController, userId = userId ?: "")
        }
    }
}


