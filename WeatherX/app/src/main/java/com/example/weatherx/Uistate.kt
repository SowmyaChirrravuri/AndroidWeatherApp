package com.example.weatherx

import com.example.weatherx.view.WeatherData

     sealed class Uistate {
     object Loading:Uistate()
     data class Success(val data: WeatherData):Uistate()
      data class error(val message:String):Uistate()
}
