package com.example.jetpackcompose

import Home
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "Home",
            builder = {
                composable("Home") {
                    Home(navController)
                }
                composable(
                    "Task/{item}",      // Task "/{item}" -> this is how pass arguments
                    arguments = listOf(
                        /* This is how you set DataType
                         By default Data type is string
                         */

                        navArgument("item") {
                            type = NavType.StringType
                        },
                   /*      ******   If you have multiple arguments   ******
                        // for multiple arguments =>   Task "/{item1} /{item2} /{item3} /{item4}"
                       navArgument("item1") {
                            type = NavType.BoolType
                        },
                        navArgument("item2") {
                            type = NavType.IntType
                        },
                        navArgument("item3") {
                            type = NavType.IntArrayType
                     }  */

                    /*
                    How to pass optional Arguments  -> Task "?item={item}" ->
                      navArgument("item") {
                            type = NavType.StringType
                            either use;
                            defaultValue = "Item Not available"
                            or make -> nullable = true
                        },
                     */
                    )
                ) {
                    val item = it.arguments?.getString("item")
                    Task(item = item)
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewMainContent() {
    MainContent()
}