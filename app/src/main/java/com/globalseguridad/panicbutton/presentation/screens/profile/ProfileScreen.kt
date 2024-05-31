package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun Profile(navController: NavHostController){
    BaseScreen(
        navController = navController,
        //topBarTitle = "Perfil"
    ) {
        // Contenido de la pantalla
        Text(text = "Perfil Reutilizable")
    }
}