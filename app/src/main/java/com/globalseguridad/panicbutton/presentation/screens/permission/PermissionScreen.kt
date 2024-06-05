package com.globalseguridad.panicbutton.presentation.screens.permission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PermissionScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3B4A6B)) // Background color of the screen
            .padding(16.dp), // Padding inside the screen
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Permisos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(bottom = 16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            PermissionItem(
                title = "Permiso para Mensajes de Texto (SMS)",
                description = "Este permiso permite que la app envíe y reciba mensajes de texto. Se utiliza para enviar alertas de emergencia y comunicarse con tutores o servicios de emergencia directamente desde la aplicación."
            )
            PermissionItem(
                title = "Permiso de Bluetooth",
                description = "Este permiso permite que la app se conecte a dispositivos Bluetooth cercanos. Es necesario para accesorios de seguridad que funcionan con la app, como dispositivos de alerta portátiles o sistemas de seguridad en el hogar."
            )
            PermissionItem(
                title = "Permiso de GPS",
                description = "Este permiso permite que la app acceda a la ubicación de tu dispositivo. Se utiliza para enviar tu ubicación exacta a tutores o servicios de emergencia cuando se activa el botón de pánico."
            )
            PermissionItem(
                title = "Permiso de Notificaciones",
                description = "Este permiso permite que la app envíe notificaciones push a tu dispositivo. Se utiliza para alertarte sobre actualizaciones de seguridad, cambios en la configuración de la app y comunicaciones urgentes de tutores."
            )
        }



        Button(
            onClick = {
                // Handle button click
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(2.dp) // Adjust the corner radius as needed
        ) {
            Text(text = "Aceptar", color = Color(0xFF3B4A6B))
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Composable
fun PermissionItem(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PermissionScreenPreview() {
    val navController = rememberNavController()
    PermissionScreen(navController)
}
