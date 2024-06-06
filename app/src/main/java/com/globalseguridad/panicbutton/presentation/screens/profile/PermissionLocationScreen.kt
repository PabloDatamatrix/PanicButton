package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun PermissionLocationScreen(navController: NavHostController) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Permisos de Localización",
        backgroundColor = Color.Gray
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)
        ) {
            Text(text = "Aquí puedes gestionar los permisos de localización", color = Color.Black)

            // Agrega tus componentes para gestionar permisos de localización aquí
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PermissionLocationScreenPreview() {
    val navController = rememberNavController()
    PermissionLocationScreen(navController)
}
