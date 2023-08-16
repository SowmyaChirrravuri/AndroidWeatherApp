package com.example.weatherx.Model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


const val   BASE_URL="https://api.openweathermap.org/data/"
class repo {
    val loggingInterceptor=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }
    val httpClient=OkHttpClient.Builder().
                  addInterceptor(loggingInterceptor)
                .build()

    val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val apiInterface=retrofit.create(ApiInterface::class.java)
}
