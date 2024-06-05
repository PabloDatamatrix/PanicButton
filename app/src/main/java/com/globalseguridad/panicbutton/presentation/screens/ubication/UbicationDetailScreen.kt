package com.globalseguridad.panicbutton.presentation.screens.ubication



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen


@Composable
fun UserDetailsScreen(navController: NavHostController, userId: String) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Detalles del Usuario",
        backgroundColor = colorResource(id = R.color.bg_gray_gs)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pantalla de Detalles de ubicación", style = MaterialTheme.typography.bodyLarge)
            Text("User ID: $userId", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserDetailsScreen() {
    val navController = rememberNavController()
    val userId = "123456789"
    UserDetailsScreen(navController = navController, userId = userId)
}