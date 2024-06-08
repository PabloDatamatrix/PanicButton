package com.globalseguridad.panicbutton.presentation.screens.splash


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.navigation.NavController
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(800, easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            })
        )
        //reemplazar el delay por alguna accion
        delay(3000L)
        //Linea para probar Formularios
        navController.navigate(ScreensNavigation.LoginScreen.name)

//        try {
//            val user = FirebaseAuth.getInstance().currentUser
//            // Navega a la pantalla de login si el usuario no está autenticado, o a la pantalla principal si lo está
//            if (user?.email.isNullOrEmpty()) {
//                navController.navigate(ScreensNavigation.LoginScreen.name)
//            } else {
//                navController.navigate(ScreensNavigation.HomeScreen.name) {
//                    // Elimina la pantalla de splash del back stack para evitar que el usuario pueda volver a ella
//                    popUpTo(ScreensNavigation.SplashScreen.name) { inclusive = true }
//                }
//            }
//        } catch (e: Exception) {
//            // Maneja posibles errores de autenticación aquí
//            // Ejemplo: Mostrar un mensaje de error al usuario
//        }

    }

    val color = MaterialTheme.colorScheme.primary
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                // Opcional: puedes agregar una barra superior aquí si lo deseas
            },
            bottomBar = {
                // Opcional: puedes agregar una barra inferior aquí si lo deseas
            },
            floatingActionButton = {
                // Opcional: puedes agregar un botón flotante aquí si lo deseas
            },
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .scale(scale.value),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Global",
                        style = MaterialTheme.typography.displayMedium, onTextLayout = { },
                        color = color.copy(alpha = 0.5F)
                    )
                    Text(
                        text = "Seguridad",
                        style = MaterialTheme.typography.headlineMedium, onTextLayout = { },
                        color = color.copy(alpha = 0.5F)
                    )
                }
            }
        }
    }
}


