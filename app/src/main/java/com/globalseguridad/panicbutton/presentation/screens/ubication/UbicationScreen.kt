package com.globalseguridad.panicbutton.presentation.screens.ubication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.globalseguridad.panicbutton.data.models.User
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.globalseguridad.panicbutton.R
import com.globalseguridad.panicbutton.presentation.navigation.ScreensNavigation
import com.globalseguridad.panicbutton.viewmodel.UserViewModel


@Composable
fun Ubication(navController: NavHostController, viewModel: UserViewModel = viewModel()) {
    BaseScreen(
        navController = navController,
        topBarTitle = "Ubicación",
        backgroundColor = Color.Gray
    ) {
        val users = viewModel.users.value ?: emptyList()

        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.bg_gray_gs))
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(users) { user ->
                    UserRow(user = user, onUserClick = { selectedUser ->
                        val userId = user.id
                        navController.navigate("${ScreensNavigation.UserDetailsScreen.name}/$userId")

                    })
                }
            }
        }
    }
}

@Composable
fun UserRow(user: User, onUserClick: (User) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onUserClick(user) },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.secondary_gs))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = user.photo.path),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))  // Bordes redondeados
                    .background(colorResource(id = R.color.bg_gray_gs))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "${user.name} ${user.surname}",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Forward Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewUbication() {
    val navController = rememberNavController()
    val viewModel = UserViewModel()
    Ubication(navController = navController, viewModel = viewModel)
}
