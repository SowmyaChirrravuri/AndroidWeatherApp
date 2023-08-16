package com.example.weatherx.ui.theme

sealed class Screen(val route: String) {
    object HomeScreen : Screen("homeScreen")
    object SearchScreen : Screen("searchScreen")
}
