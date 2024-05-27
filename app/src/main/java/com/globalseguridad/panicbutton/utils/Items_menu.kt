package com.globalseguridad.panicbutton.utils

import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object Home : Items_menu(
        R.drawable.baseline_home_24,
        "Inicio",
        ScreensNavigation.HomeScreen.toString()
    )

    object Ubication : Items_menu(
        R.drawable.baseline_location_pin_24,
        "ubicación",
        ScreensNavigation.UbicationScreen.toString()
    )

    object Profile : Items_menu(
        R.drawable.baseline_person_24,
        "Perfil",
        ScreensNavigation.ProfileScreen.toString()
    )
    object Setting : Items_menu(
        R.drawable.baseline_settings_24,
        "Ajustes",
        ScreensNavigation.SettingScreen.toString()
    )
}