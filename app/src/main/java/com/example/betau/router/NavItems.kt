package com.example.betau.router

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.betau.R

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        label = "Journal",
        icon = Icons.Default.Book,
        route = Routes.JournalScreen.route
    ),
    NavItem(
        label = "Medics",
        icon = Icons.Default.Medication,
        route = Routes.MedicsScreen.route
    ),
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Routes.HomeScreen.route
    ),
    NavItem(
        label = "Community",
        icon = Icons.Default.People,
        route = Routes.CommunityScreen.route
    ),
    NavItem(
        label = "Profile",
        icon = Icons.Default.Person,
        route = Routes.ProfileScreen.route
    )
)