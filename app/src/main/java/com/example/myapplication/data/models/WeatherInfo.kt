package com.example.myapplication.data.models

import java.io.Serializable

class WeatherInfo: Serializable {

    var coord: Coord? = null
    var sys: Sys? = null
    var weather = ArrayList<Weather>()
    var main: Main? = null
    var wind: Wind? = null
    var rain: Rain? = null
    var clouds: Clouds? = null
    var dt: Float = 0.toFloat()
    var id: Int = 0
    var name: String? = null
    var cod: Float = 0.toFloat()
}

class Weather {
    var id: Int = 0
    var main: String? = null
    var description: String? = null
    var icon: String? = null
}

class Clouds {
    var all: Float = 0.toFloat()
}

class Rain {
    var h3: Float = 0.toFloat()
}

class Wind {
    var speed: Float = 0.toFloat()
    var deg: Float = 0.toFloat()
}

class Main {
    var temp: Float = 0.toFloat()
    var humidity: Float = 0.toFloat()
    var pressure: Float = 0.toFloat()
    var temp_min: Float = 0.toFloat()
    var temp_max: Float = 0.toFloat()
}

class Sys {
    var country: String? = null
    var sunrise: Long = 0
    var sunset: Long = 0
}

class Coord {
    var lon: Float = 0.toFloat()
    var lat: Float = 0.toFloat()
}
