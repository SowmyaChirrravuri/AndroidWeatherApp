package com.example.weatherx

import android.app.Application
import android.content.SharedPreferences


class MyApp : Application() {
    // Getter method to access SharedPreferences from other components


    override fun onCreate() {
        super.onCreate()

        SharedPreferencesManager.initialize(this)
        // Initialize SharedPreferences
       // sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
    }


}