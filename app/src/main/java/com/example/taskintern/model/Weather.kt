package com.example.taskintern.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val id: Int,
    val cityName: String,
    var weather: String,
    val minWeather: Int,
    val maxWeather: Int,
    val weatherCondition: String
) : Parcelable
