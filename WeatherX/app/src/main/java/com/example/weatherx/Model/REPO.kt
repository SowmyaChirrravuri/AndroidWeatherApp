package com.example.weatherx.Model


import com.example.weatherx.MyApp
import com.example.weatherx.SharedPreferencesManager.getSharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.openweathermap.org/data/"

class repo {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val apiInterface = retrofit.create(ApiInterface::class.java)

    val sharedpref = getSharedPreferences()


    fun saveData(key: String, value: String) {
        sharedpref?.edit()?.putString(key, value)?.commit()
    }

    fun getData(key: String): String? {

        return sharedpref?.getString(key, "")
    }


}
