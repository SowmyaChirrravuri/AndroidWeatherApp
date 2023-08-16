package com.example.weatherx.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherx.Model.repo

import com.example.weatherx.view.WeatherData
import kotlinx.coroutines.launch

class weatherViewModel : ViewModel() {
    val weatherItems = mutableStateOf<WeatherData?>(null)

    // Use a suspending function to perform the API call
  fun getWeatherData(city: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = repo().apiInterface.getWeatherData(city)
                weatherItems.value=weatherResponse
                println("Weather data for $city: $weatherResponse")
            } catch (e: Exception) {
                println("Error fetching weather data: ${e.message}")
            }
        }
    }
}
