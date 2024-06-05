package com.globalseguridad.panicbutton.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation

class ProfileViewModel : ViewModel() {
    fun navigateToSection(navController: NavController, section: ScreensNavigation) {
        navController.navigate(section.name)
    }
}
