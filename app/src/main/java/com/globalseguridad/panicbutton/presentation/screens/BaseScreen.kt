package com.globalseguridad.panicbutton.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.utils.NavegacionInferior
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.globalseguridad.panicbutton.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun BaseScreen(
    navController: NavHostController,
    topBarTitle: String? = null,
    backgroundColor: Color? = null, // Color de fondo predeterminado como nullable
    content: @Composable () -> Unit,
) {
    val defaultBackgroundColor = colorResource(id = R.color.secondary_gs)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (topBarTitle != null) {
                SmallTopAppBar(title = topBarTitle)
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ) {
                NavegacionInferior(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                shape = CircleShape,
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.elevation()
            ) { Icon(Icons.Filled.Emergency, "Localized description") }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    color = backgroundColor ?: defaultBackgroundColor
                ) // Usar el color predeterminado si no se proporciona ninguno
        ) {
            content()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(
    title: String,
    icon: ImageVector? = null,
    onIconClick: () -> Unit = {},
    backgroundColor: Color = Color.Transparent // Agregamos el parámetro backgroundColor con un valor predeterminado transparente
) {
    TopAppBar(
        // backgroundColor = backgroundColor, // Usamos el backgroundColor proporcionado
        colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (icon != null) {
                    Box(
                        modifier = Modifier
                            .clickable { onIconClick() }
                            .padding(8.dp)
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                colorResource(id = R.color.secondary_gs),
                                RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    )
}

//@Preview(showBackground = true)
//@Composable
//fun SmallTopAppBarPreview() {
//    // Vista previa de SmallTopAppBar sin icono y color de fondo personalizado
//    SmallTopAppBar(title = "Title", backgroundColor = Color.Gray)
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun SmallTopAppBarPreviewWithIcon() {
//    // Vista previa de SmallTopAppBar con un icono y color de fondo personalizado
//    SmallTopAppBar(title = "Title", icon = Icons.Default.Menu, backgroundColor = Color.LightGray)
//
//}


@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ) {
                NavegacionInferior(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                shape = CircleShape,
                containerColor = colorResource(id = R.color.primary_gs), // Color rojo para el FAB
                elevation = FloatingActionButtonDefaults.elevation()
            ) {
                Icon(
                    Icons.Filled.Campaign,
                    "Localized description",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}
