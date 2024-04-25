package com.example.betau.router

sealed class Routes (val route: String) {
    data object SplashScreen : Routes("splash")
    data object HomeScreen : Routes("home")
    data object ProfileScreen : Routes("profile")
    data object JournalScreen : Routes("journal")
    data object CommunityScreen : Routes("community")
    data object MedicsScreen : Routes("medics")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}