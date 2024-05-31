package com.globalseguridad.panicbutton.utils

import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object Home : Items_menu(
        R.drawable.home_gs,
        "Inicio",
        ScreensNavigation.HomeScreen.toString()
    )

    object Ubication : Items_menu(
        R.drawable.ubication_gs,
        "ubicación",
        ScreensNavigation.UbicationScreen.toString()
    )

    object Profile : Items_menu(
        R.drawable.profile_gs,
        "Perfil",
        ScreensNavigation.ProfileScreen.toString()
    )
    object Setting : Items_menu(
        R.drawable.setting_gs,
        "Ajustes",
        ScreensNavigation.SettingScreen.toString()
    )
}