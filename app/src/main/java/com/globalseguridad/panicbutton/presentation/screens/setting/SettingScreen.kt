package com.globalseguridad.panicbutton.presentation.screens.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun Setting(navController: NavHostController){
    BaseScreen(
        navController = navController,
        topBarTitle = "Ajustes"
    ) {
        // Contenido de la pantalla
        Text(text = "Ajustes")
    }
}