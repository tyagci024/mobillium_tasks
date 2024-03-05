package com.example.taskintern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.taskintern.R
import com.example.taskintern.databinding.ActivityDetailActivitysBinding
import com.example.taskintern.model.Weather


class DetailActivitys : AppCompatActivity() {
    private lateinit var binding: ActivityDetailActivitysBinding

    companion object {
        const val ARG_WEATHER_DATA = "weatherData"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherData = intent.getParcelableExtra<Weather>(ARG_WEATHER_DATA)

        if (weatherData != null) {
            binding.cityName.text = weatherData.cityName
            binding.weatherCondition.text = weatherData.weatherCondition
            binding.textViewWeather.text = weatherData.weather
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}