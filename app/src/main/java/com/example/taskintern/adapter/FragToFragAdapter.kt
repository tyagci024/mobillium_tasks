package com.example.taskintern.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskintern.databinding.ItemLayoutBinding
import com.example.taskintern.model.Weather

class FragToFragAdapter(private val weatherList: List<Weather>, private val onItemClick: (Weather) -> Unit) : RecyclerView.Adapter<FragToFragAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.apply {
                cityName.text = weather.cityName
                weatherC.text = weather.weather
                weatherCondition.text = weather.weatherCondition
                root.setOnClickListener { onItemClick(weather) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }

    override fun getItemCount(): Int = weatherList.size
}
