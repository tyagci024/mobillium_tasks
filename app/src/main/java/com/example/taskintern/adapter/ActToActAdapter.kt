package com.example.taskintern.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskintern.databinding.ItemLayoutBinding
import com.example.taskintern.model.Weather
import com.example.taskintern.view.DetailActivitys

class ActToActAdapter(val context: Context, val weatherList: List<Weather>) : RecyclerView.Adapter<ActToActAdapter.WeatherListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivitys::class.java)
            intent.putExtra("weatherData", weather)
            context.startActivity(intent)

        }
    }

    override fun getItemCount() = weatherList.size

    class WeatherListViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {
            binding.cityName.text = weather.cityName
            binding.weatherC.text = weather.weather
            binding.weatherCondition.text = weather.weatherCondition
        }
    }
}


