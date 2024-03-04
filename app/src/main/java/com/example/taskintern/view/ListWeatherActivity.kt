package com.example.taskintern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskintern.adapter.Adapter
import com.example.taskintern.databinding.ActivityListWeatherBinding
import com.example.taskintern.model.Weather

class ListWeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListWeatherBinding
    private lateinit var weatherList:MutableList<Weather>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
         weatherList = mutableListOf(
            Weather(0,"Ankara", "25°C", 10,28,"Rüzgarlı"),
            Weather(1,"İzmir", "20°C",12 ,29,"Bulutlu"),
            Weather(2,"İstanbul", "19°C", 11,23,"Güneşli")
        )

        binding.recyclerViewItem.layoutManager= LinearLayoutManager(this)

        val adapter = Adapter(this,weatherList)
        adapter.onItemClickListener = { weather ->
            val intent = Intent(this, DetailActivitys::class.java)
            intent.putExtra("weatherData", weather)
            startActivity(intent)
        }
        binding.recyclerViewItem.adapter = adapter

    }




}