package com.example.taskintern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.taskintern.R
import com.example.taskintern.databinding.FragmentWONavCompSecBinding
import com.example.taskintern.model.Weather


class WONavCompSecFragment : Fragment() {
    private lateinit var binding: FragmentWONavCompSecBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWONavCompSecBinding.inflate(inflater, container, false)

        val weather: Weather? = arguments?.getParcelable(WEATHER_DATA)

        if (weather != null) {
            binding.cityName.text = weather.cityName
            binding.textViewWeather.text = weather.weather
            binding.weatherCondition.text = weather.weatherCondition
        } else {
            Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {
        const val WEATHER_DATA = "weather"

        fun newInstance(weather: Weather): WONavCompSecFragment {
            val fragment = WONavCompSecFragment()
            val args = Bundle().apply {
                putParcelable(WEATHER_DATA, weather)
            }
            fragment.arguments = args
            return fragment
        }
    }
}