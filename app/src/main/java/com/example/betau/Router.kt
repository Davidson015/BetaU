package com.example.betau

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Router() {
    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = "home") {
        // Adding Screens to the NavHost
        composable("home") {

        }

        composable("profile") {

        }

        composable("activities") {

        }

        composable("history") {

        }

        composable("community") {

        }
    }
}