package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecurityInfoScreen(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Text(text = "Security Info Screen", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SecurityInfoScreenPreview() {
    val navController = rememberNavController()
    SecurityInfoScreen(navController)
}
