package com.globalseguridad.panicbutton.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
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