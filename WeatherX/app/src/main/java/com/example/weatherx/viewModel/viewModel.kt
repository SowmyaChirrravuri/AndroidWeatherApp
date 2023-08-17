package com.example.weatherx.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherx.Model.repo
import com.example.weatherx.Uistate

import com.example.weatherx.view.WeatherData
import kotlinx.coroutines.launch


const val CITY_NAME_KEY = "CITY"
const val SHARE_PREF = "sharedPreferences"

class weatherViewModel : ViewModel() {
    private lateinit var cityName: String
    private lateinit var editor: SharedPreferences.Editor
    val uiState = MutableLiveData<Uistate>()
    val weatherItems = mutableStateOf<WeatherData?>(null)



    fun getWeatherData(city: String) {
        uiState.value = Uistate.Loading
        viewModelScope.launch {
            try {
                val weatherResponse = repo().apiInterface.getWeatherData(city)
                weatherItems.value = weatherResponse
                uiState.value = Uistate.Success(weatherResponse)
            } catch (e: Exception) {
                uiState.value = Uistate.error("N/W request failed")
            }
        }
    }


}
