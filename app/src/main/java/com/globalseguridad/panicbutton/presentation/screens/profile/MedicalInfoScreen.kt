package com.globalseguridad.panicbutton.presentation.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.globalseguridad.panicbutton.data.models.Gender
import com.globalseguridad.panicbutton.viewmodel.UserViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.R
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun MedicalInfoScreen(navController: NavHostController, viewModel: UserViewModel?) {
    val photoUrl = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf(Gender.OTHER) }
    val allergies = remember { mutableStateOf("") }
    val medicalConditions = remember { mutableStateOf("") }
    val currentMedications = remember { mutableStateOf("") }
    val bloodTypeOptions = listOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")
    val selectedBloodTypes = remember { mutableStateOf(emptyList<String>()) }

    BaseScreen(
        navController = navController,
        topBarTitle = "Información Básica",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Implementar un componente para subir foto
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text("Alergias")
                    TextField(
                        value = allergies.value,
                        onValueChange = { allergies.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp)),
                        textStyle = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                        colors = TextFieldDefaults.colors(Color.Gray),
                        singleLine = true
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text("Condiciones médicas preexistentes")
                    TextField(
                        value = medicalConditions.value,
                        onValueChange = { medicalConditions.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp)),
                        textStyle = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                        colors = TextFieldDefaults.colors(Color.White),
                        singleLine = true
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text("Medicamentos actuales")
                    TextField(
                        value = currentMedications.value,
                        onValueChange = { currentMedications.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp)),
                        textStyle = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                        colors = TextFieldDefaults.colors(Color.Gray),
                        singleLine = true
                    )
                }
            }

            item {
                Text("Tipo de sangre:")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val rows = bloodTypeOptions.chunked(4)
                    rows.forEach { row ->
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.Start
                        ) {
                            row.forEach { bloodType ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Checkbox(
                                        checked = selectedBloodTypes.value.contains(bloodType),
                                        onCheckedChange = {
                                            selectedBloodTypes.value =
                                                if (selectedBloodTypes.value.contains(bloodType))
                                                    selectedBloodTypes.value - bloodType
                                                else
                                                    selectedBloodTypes.value + bloodType
                                        },
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color.Blue,
                                            uncheckedColor = Color.Gray
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))  // Separación entre el Checkbox y el texto
                                    Text(bloodType)
                                }
                            }
                        }
                    }
                }
            }

            item {
                Button(
                    onClick = {
                        // Handle button click
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.secondary_gs)),
                    shape = RoundedCornerShape(6.dp) // Adjust the corner radius as needed
                ) {
                    Text(text = "Guardar", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicalInfoScreenPreview() {
    val navController = rememberNavController()
    val viewModel = UserViewModel()
    MedicalInfoScreen(navController = navController, viewModel = viewModel)
}
