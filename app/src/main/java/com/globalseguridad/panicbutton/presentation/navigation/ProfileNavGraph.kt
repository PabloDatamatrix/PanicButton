package com.globalseguridad.panicbutton.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.globalseguridad.panicbutton.presentation.screens.profile.BasicInfoScreen1
import com.globalseguridad.panicbutton.presentation.screens.profile.BasicInfoScreen2
import com.globalseguridad.panicbutton.presentation.screens.profile.MedicalInfoScreen
import com.globalseguridad.panicbutton.presentation.screens.profile.Profile
import com.globalseguridad.panicbutton.presentation.screens.profile.SecurityInfoScreen

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(
        startDestination = ScreensNavigation.ProfileScreen.name,
        route = "profile"
    ) {
        composable(ScreensNavigation.ProfileScreen.name) {
            Profile(navController = navController)
        }
        composable(ScreensNavigation.BasicInfoScreen1.name) {
            BasicInfoScreen1(navController = navController,null)
        }
        composable(ScreensNavigation.BasicInfoScreen2.name) {
            BasicInfoScreen2(navController = navController,null)
        }
        composable(ScreensNavigation.MedicalInfoScreen.name) {
            MedicalInfoScreen(navController = navController,null)
        }
        composable(ScreensNavigation.SecurityInfoScreen.name) {
            SecurityInfoScreen(navController = navController)
        }
    }
}
