package com.example.weatherx

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences.Editor
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

const val CITY_NAME_KEY = "CITY"
const val SHARE_PREF = "sharedPreferences"

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<weatherViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var cityName: String
    private lateinit var editor: Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedpref = getSharedPreferences(SHARE_PREF, Context.MODE_PRIVATE)
        editor = sharedpref.edit()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.uiState.observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })

        binding.buttonPerformRequest.setOnClickListener {
            cityName = binding.editTextCity.text.toString()
            viewModel.getWeatherData(cityName)

        }
        binding.buttonLoadData.setOnClickListener {
            val city = sharedpref.getString(CITY_NAME_KEY, "")
            binding.editTextCity.setText(city)
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
        storeCityInSharedPreferences()
        navigateToNewScreen(uiState)
    }

    private fun onError(uiState: Uistate.error) {
        with(binding) {
            progressBar.visibility = View.INVISIBLE
            buttonPerformRequest.isEnabled = true
        }
        Toast.makeText(this, uiState.message, Toast.LENGTH_SHORT).show()
    }

    private fun storeCityInSharedPreferences() {
        editor.putString(CITY_NAME_KEY, cityName).commit()
    }

    private fun navigateToNewScreen(uiState: Uistate.Success) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("key sender", uiState.data.toString())
        startActivity(intent)
    }
}




