package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.globalseguridad.panicbutton.data.models.Gender
import com.globalseguridad.panicbutton.viewmodel.UserViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun BasicInfoScreen2(navController: NavHostController, viewModel: UserViewModel?) {
    val photoUrl = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf(Gender.OTHER) }

    BaseScreen(
        navController = navController,
        topBarTitle = "Información Básica",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Implementar un componente para subir foto
            TextField(
                value = photoUrl.value,
                onValueChange = { photoUrl.value = it },
                label = { Text("Foto URL") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
            TextField(
                value = address.value,
                onValueChange = { address.value = it },
                label = { Text("Dirección de residencia") },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Sexo:")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = gender.value == Gender.FEMALE, onClick = { gender.value = Gender.FEMALE })
                    Text("Mujer")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = gender.value == Gender.MALE, onClick = { gender.value = Gender.MALE })
                    Text("Hombre")
                }
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
fun BasicInfoScreen2Preview() {
    val navController = rememberNavController()
    val viewModel = UserViewModel()
    BasicInfoScreen2(navController = navController, viewModel = viewModel)
}
