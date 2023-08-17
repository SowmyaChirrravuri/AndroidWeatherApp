package com.example.weatherx

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.weatherx.Model.repo
import com.example.weatherx.databinding.ActivityMainBinding
import com.example.weatherx.view.WeatherData

import com.example.weatherx.viewModel.weatherViewModel


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<weatherViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.uiState.observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })

        binding.buttonPerformRequest.setOnClickListener {
            val cityName = binding.editTextCity.text.toString()
            viewModel.getWeatherData(city = binding.editTextCity.text.toString())

        }

        }



    private fun render(uiState: Uistate) {
        when (uiState) {
            is Uistate.Loading -> {
                onLoad()
            }
            is Uistate.Success -> {
                onSuccess(uiState)
            }
            is Uistate.error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() {
        with(binding) {
            progressBar.visibility = View.VISIBLE
            buttonPerformRequest.isEnabled = false
        }
    }

    private fun onSuccess(uiState: Uistate.Success) {
        with(binding) {
            progressBar.visibility = View.INVISIBLE
            buttonPerformRequest.isEnabled = true
        }

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("key sender", uiState.data.toString())
        startActivity(intent)
    }

    private fun onError(uiState: Uistate.error) {
        with(binding) {
            progressBar.visibility = View.INVISIBLE
            buttonPerformRequest.isEnabled = true
        }
        Toast.makeText(this, uiState.message, Toast.LENGTH_SHORT).show()
    }
}




