package com.example.jetpackcompose

import TaskCard
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Task(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
    ) {
        Text(
            text = "My Tasks",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn {
            var i = 0
            items((1..5).toList()) {
                TaskCard("Details Item - ${++i}", navController,R.drawable.ic_task)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTasks() {
        Task()
}