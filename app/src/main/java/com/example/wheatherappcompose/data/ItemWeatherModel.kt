package com.example.wheatherappcompose.data

data class ItemWeatherModel(
    val name: String,
    val time: String,
    val currentTemp: String,
    val condition: String,
    val icon: String,
    val maxTemp: String,
    val minTemp: String,
    val hours: String,
)
