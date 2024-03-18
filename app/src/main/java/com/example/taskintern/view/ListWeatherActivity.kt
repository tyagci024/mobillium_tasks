package com.example.taskintern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskintern.adapter.Adapter
import com.example.taskintern.databinding.ActivityListWeatherBinding
import com.example.taskintern.model.Data
import com.example.taskintern.model.Weather
import com.example.taskintern.view.DetailActivitys.Companion.ARG_WEATHER_DATA

class ListWeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewItem.layoutManager = LinearLayoutManager(this)

        val adapter = Adapter(Data.weatherList)
        adapter.onItemClickListener = { weather ->
            val intent = Intent(this, DetailActivitys::class.java)
            intent.putExtra(ARG_WEATHER_DATA, weather)
            startActivity(intent)
        }
        binding.recyclerViewItem.adapter = adapter
    }
}
