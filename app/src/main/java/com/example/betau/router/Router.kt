package com.example.betau.router

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.betau.screens.CommunityScreen
import com.example.betau.screens.HomeScreen
import com.example.betau.screens.JournalScreen
import com.example.betau.screens.MedicsScreen
import com.example.betau.screens.ProfileScreen

@Composable
fun Router() {
    val controller = rememberNavController()
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by controller.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                                  controller.navigate(navItem.route) {
                                      popUpTo(controller.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = controller, 
            startDestination = "home",
            modifier = Modifier
                .padding(paddingValues)
        ) {
            // Adding Screens to the NavHost
            composable(route = Routes.HomeScreen.route) {
                HomeScreen(controller = controller)
            }

            composable(route = Routes.ProfileScreen.route) {
                ProfileScreen(controller = controller)
            }

            composable(route = Routes.JournalScreen.route) {
                JournalScreen(controller = controller)
            }

            composable(route = Routes.MedicsScreen.route) {
                MedicsScreen(controller = controller)
            }

            composable("community") {
                CommunityScreen(controller = controller)
            }
        }
    }

    
}