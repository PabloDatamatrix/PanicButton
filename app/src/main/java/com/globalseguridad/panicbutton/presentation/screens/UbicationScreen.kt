package com.globalseguridad.panicbutton.presentation.screens


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Ubication(navController: NavHostController){
    BaseScreen(
        navController = navController,
        topBarTitle = "Ubicación"
    ) {
        // Contenido de la pantalla
        Text(text = "Ubicación")
    }
}