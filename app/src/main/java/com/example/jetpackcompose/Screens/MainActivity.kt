package com.example.jetpackcompose.Screens

import Home
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.*
import com.example.jetpackcompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController) },
        drawerContent = { Text(text = "Drawer") }
    ) {
        NavHost(
            navController = navController,
            startDestination = NAV_HOME,
            modifier = Modifier.padding(it)
        ) {
            composable(NAV_HOME) { ComposeWithXML() }
            composable(NAV_FAV) { Screen(text = "Favourite Screen") }
            composable(NAV_FEED) { Screen(text = "Feed Screen") }
            composable(NAV_PROFILE) { MainData() }
        }
    }

}

@Composable
fun Screen(text: String) =
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = text,
        fontSize = 25.sp,
        modifier = Modifier.padding(start = 32.dp, top = 32.dp))
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        MainScreen()
    }
}