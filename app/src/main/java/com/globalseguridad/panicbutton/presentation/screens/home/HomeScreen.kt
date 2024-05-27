package com.globalseguridad.panicbutton.presentation.screens.home


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen
@Composable
fun Home( navController: NavHostController) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Home"
    ) {
        // Contenido de la pantalla
        Text(text = "Home")
    }
}