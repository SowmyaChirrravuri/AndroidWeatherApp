package com.example.weatherx


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherx.ui.theme.Screen
import com.example.weatherx.viewModel.weatherViewModel


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<weatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.HomeScreen.route // Use the route value
            ) {
                composable(Screen.HomeScreen.route) { // Use the route value
                    StateCityCountryForm(navController = navController, viewModel = viewModel)
                }
                composable(Screen.SearchScreen.route) { // Use the route value
                    BasicTextFieldExample(viewModel)

                }
            }
        }
    }
}

