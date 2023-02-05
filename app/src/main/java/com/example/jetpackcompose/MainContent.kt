package com.example.jetpackcompose

import Home
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun ComposeWithXML() {
    Column {
        AndroidView(
            factory = {
                View.inflate(it, R.layout.activity_main, null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            update = { view ->
                val name = view.findViewById<TextView>(R.id.nameTV)
                name.setOnClickListener {
                    Toast.makeText(view.context, "This is Singh", Toast.LENGTH_SHORT).show()
                }
            }
        )
        MainContent()
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = NAV_HOME,
            builder = {
                composable(NAV_HOME) { Home(navController) }
                composable("Task/{item}") { Task(navController) }
            }
        )
    }
}


@Preview
@Composable
fun PreviewMainContent() {
    ComposeWithXML()
}