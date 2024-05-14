package com.globalseguridad.panicbutton.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.screens.SplashScreen
import com.globalseguridad.panicbutton.screens.home.Home
import com.globalseguridad.panicbutton.screens.login.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ScreensNavigation.SplashScreen.name.toString()
    ) {
        composable(ScreensNavigation.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(ScreensNavigation.LoginScreen.name){
            LoginScreen(navController = navController)
        }
        composable(ScreensNavigation.HomeScreen.name){
            Home(navController = navController)
        }
    }
}