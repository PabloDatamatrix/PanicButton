package com.globalseguridad.panicbutton.presentation.screens.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.globalseguridad.panicbutton.viewmodel.ActivityHistoryViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.globalseguridad.panicbutton.presentation.screens.BaseScreen

data class ActivityHistory(
    val id: String,
    val title: String,
    val date: String, val details: String
)

@Composable
fun ActivityHistoryScreen(
    navController: NavHostController,
    viewModel: ActivityHistoryViewModel = viewModel()
) {
    val activityHistoryList by viewModel.activityHistoryList.collectAsState()

    BaseScreen(
        navController = navController,
        topBarTitle = "Historial de Actividades",
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(activityHistoryList) { activity ->
                ActivityHistoryItem(activity)
            }
        }
    }
}

@Composable
fun ActivityHistoryItem(activity: ActivityHistory) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = activity.title,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        text = activity.date,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
            if (expanded) {
                Text(
                    text = activity.details,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityHistoryScreenPreview() {
    val navController = rememberNavController()
    val viewModel = ActivityHistoryViewModel()
    ActivityHistoryScreen(navController = navController, viewModel = viewModel)
}
