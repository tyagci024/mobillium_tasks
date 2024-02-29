package com.example.taskintern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.taskintern.R
import com.example.taskintern.databinding.ActivityDetailActivitysBinding
import com.example.taskintern.model.Weather

class DetailActivitys : AppCompatActivity() {
    private lateinit var binding: ActivityDetailActivitysBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailActivitysBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val weatherData = intent.getParcelableExtra<Weather>("weatherData")!!

        binding.cityName.text = weatherData.cityName
        binding.weatherCondition.text = weatherData.weatherCondition
        binding.textViewWeather.text = weatherData.weather


    }



}