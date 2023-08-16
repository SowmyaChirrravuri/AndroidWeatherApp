package com.example.weatherx.Model

import com.example.weatherx.view.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "92226b8136486eb55500f91f5fe2a475"
interface ApiInterface {
    @GET("2.5/weather")
    suspend fun getWeatherData
                (@Query("q") cityName: String,
                 @Query("appid") apiKey: String = API_KEY):WeatherData
    }

