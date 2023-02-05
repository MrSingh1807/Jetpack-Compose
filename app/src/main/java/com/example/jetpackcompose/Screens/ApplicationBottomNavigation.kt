package com.example.jetpackcompose.Screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpackcompose.NavItems

@Composable
fun AppBottomNavigation(navController: NavController? = null) {
    val navItems = listOf(NavItems.Home, NavItems.Favourite, NavItems.Feed, NavItems.Profile)

    BottomNavigation(backgroundColor = Color.DarkGray,
    elevation = 4.dp) {
        val navBackStackEntry by navController!!.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {item ->
            BottomNavigationItem(
                selected = currentRoute == item.navRoute,
                icon = { Icon(painter = painterResource(id = item.icon),
                        contentDescription = stringResource(item.title)) },
                label =  { Text(text = stringResource(id = item.title), fontSize = 9.sp) },
                selectedContentColor = Color.White ,
                unselectedContentColor =  Color.White.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navController?.navigate(item.navRoute){
                        navController.graph.startDestinationRoute?.let {screen_route ->
                            popUpTo(screen_route){
                                saveState =true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowBottomNavigation(){
    AppBottomNavigation()
}