package com.globalseguridad.panicbutton.utils

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun NavegacionInferior(
    navController: NavHostController
) {
    val menuItems = listOf(
        Items_menu.Home,
        Items_menu.Ubication,
        Items_menu.Profile,
        Items_menu.Setting
    )

    NavigationBar {
        val currentRoute = currentRoute(navController = navController)
        menuItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.ruta,
                onClick = { navController.navigate(item.ruta) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        item.title,
                        style = MaterialTheme.typography.titleMedium,
                        onTextLayout = { })
                }
            )
        }
    }
}