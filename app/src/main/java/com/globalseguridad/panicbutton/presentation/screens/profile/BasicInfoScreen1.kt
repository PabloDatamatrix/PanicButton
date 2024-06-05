package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.globalseguridad.panicbutton.viewmodel.UserViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun BasicInfoScreen1(navController: NavHostController, viewModel: UserViewModel?) {
    val documentId = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val surname = remember { mutableStateOf("") }
    val birthdate = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    BaseScreen(
        navController = navController,
        topBarTitle = "Información Básica",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = documentId.value,
                onValueChange = { documentId.value = it },
                label = { Text("Documento de identidad") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = surname.value,
                onValueChange = { surname.value = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = birthdate.value,
                onValueChange = { birthdate.value = it },
                label = { Text("Fecha de nacimiento") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = phone.value,
                onValueChange = { phone.value = it },
                label = { Text("Número de teléfono") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Dirección de correo electrónico") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )

            Button(
                onClick = {
                    navController.navigate(ScreensNavigation.BasicInfoScreen2.name)
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Continuar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicInfoScreen1Preview() {
    val navController = rememberNavController()
    val viewModel = UserViewModel()
    BasicInfoScreen1(navController = navController, viewModel = viewModel)
}
