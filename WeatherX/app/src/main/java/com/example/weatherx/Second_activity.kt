package com.example.weatherx

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.weatherx.view.WeatherData

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val textViewWeatherData = findViewById<TextView>(R.id.secondscreen)

        val receivedIntent = intent
        val receivedData = receivedIntent.getStringExtra("key sender")
        textViewWeatherData.text = receivedData
    }
}
