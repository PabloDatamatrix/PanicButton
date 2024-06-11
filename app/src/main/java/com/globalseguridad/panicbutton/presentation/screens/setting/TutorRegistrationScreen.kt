package com.globalseguridad.panicbutton.presentation.screens.setting

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen
import com.globalseguridad.panicbutton.viewmodel.UserViewModel

@Composable
fun TutorRegistrationScreen(navController: NavHostController, viewModel: UserViewModel?) {
    val idDocument = remember { mutableStateOf("") }
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val primaryPhoneNumber = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val contactPreference = remember { mutableStateOf("Email") }

    BaseScreen(
        navController = navController,
        topBarTitle = "Registro de Tutor",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = idDocument.value,
                onValueChange = { idDocument.value = it },
                label = { Text("Documento de Identidad") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            TextField(
                value = firstName.value,
                onValueChange = { firstName.value = it },
                label = { Text("Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            TextField(
                value = lastName.value,
                onValueChange = { lastName.value = it },
                label = { Text("Apellido") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            TextField(
                value = primaryPhoneNumber.value,
                onValueChange = { primaryPhoneNumber.value = it },
                label = { Text("Número de Teléfono Principal") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Correo Electrónico") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Text("¿Cómo prefiere ser contactado?")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = contactPreference.value == "Email",
                    onClick = { contactPreference.value = "Email" }
                )
                Text("Email")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = contactPreference.value == "Teléfono",
                    onClick = { contactPreference.value = "Teléfono" }
                )
                Text("Teléfono")
            }

            Button(
                onClick = {
                    // TODO: Implementar lógica para guardar los datos en Firebase
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Guardar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutorRegistrationScreenPreview() {
    val navController = rememberNavController()
    TutorRegistrationScreen(navController = navController, viewModel = null)
}
