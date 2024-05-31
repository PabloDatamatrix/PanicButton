package com.globalseguridad.panicbutton.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

@Composable
fun Home(navController: NavHostController) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Home"
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.secondary_gs))
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly, // Espacio uniforme entre elementos
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserInfo(
                    userName = "Juan Lopéz",
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible para centrar los botones verticalmente

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center, // Centra los botones verticalmente
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StyledButton(
                    text = "S O S",
                    backgroundColor = colorResource(id = R.color.primary_gs),
                    showIcon = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(bottom = 16.dp),
                    onClick = { /* TODO: Add action */ }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StyledButton(
                        text = "Emergencia",
                        backgroundColor = colorResource(id = R.color.yellow_gs),
                        icon = Icons.Default.LocalHospital,
                        showIcon = true,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        onClick = { /* TODO: Add action */ }
                    )
                    StyledButton(
                        text = "En Camino",
                        backgroundColor = colorResource(id = R.color.green_gs),
                        icon = Icons.AutoMirrored.Filled.DirectionsRun,
                        showIcon = true,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        onClick = { /* TODO: Add action */ }
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible para centrar los botones verticalmente
        }
    }
}


@Composable
fun UserInfo(
    userName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "User Icon",
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                fontSize = 24.sp,
                text = userName,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification Icon",
            modifier = Modifier.size(30.dp),
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledButton(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    showIcon: Boolean,
    icon: ImageVector? = null
) {
    Card(
        modifier = modifier
            .border(BorderStroke(16.dp, colorResource(id = R.color.bg_gray_gs)), shape = RoundedCornerShape(16.dp))
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    backgroundColor,
                    RoundedCornerShape(16.dp)
                ),
        ) {
            if (showIcon && icon != null) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(70.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Text(
                    text = text,
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(backgroundColor, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewStyledButton() {
//    StyledButton(
//        text = "S O S",
//        backgroundColor = colorResource(id = R.color.primary_gs),
//        showIcon = false,
//        onClick = { }
//    )
//}

@Preview
@Composable
fun PreviewHome() {
    Home(navController = NavHostController(LocalContext.current))
}
