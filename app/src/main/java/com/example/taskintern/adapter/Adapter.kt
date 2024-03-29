package com.example.taskintern.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskintern.databinding.ItemLayoutBinding
import com.example.taskintern.model.Weather

class Adapter(private val weatherList: List<Weather>) :
    RecyclerView.Adapter<Adapter.WeatherListViewHolder>() {

    var onItemClickListener: ((Weather) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherListViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherListViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(weather)
        }
    }

    override fun getItemCount() = weatherList.size

    class WeatherListViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) {
            binding.apply {
                textViewCity.text = weather.cityName
                textViewWeatherCantigrate.text = weather.weather
                textViewWeatherCondition.text = weather.weatherCondition
            }
        }
    }
}


