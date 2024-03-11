package com.example.taskintern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.taskintern.databinding.ActivityDetailActivitysBinding
import com.example.taskintern.model.Weather
import com.example.taskintern.extension.parcelable

class DetailActivitys : AppCompatActivity() {

    private lateinit var binding: ActivityDetailActivitysBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherData = intent.parcelable<Weather>(ARG_WEATHER_DATA)

        weatherData?.let { data ->
            binding.apply {
                textViewCityName.text = data.cityName
                textViewWeatherCondition.text = data.weatherCondition
                textViewWeather.text = data.weather
            }
        } ?:run{
            Toast.makeText(this, "Hata!!", Toast.LENGTH_SHORT).show()
        }

    }
    companion object {
        const val ARG_WEATHER_DATA = "weatherData"
    }
}

