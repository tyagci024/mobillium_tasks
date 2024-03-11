package com.example.taskintern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.taskintern.databinding.FragmentWONavCompSecBinding
import com.example.taskintern.model.Weather
import com.example.taskintern.extension.parcelable

class SecTransactionFragment : Fragment() {

    private lateinit var binding: FragmentWONavCompSecBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWONavCompSecBinding.inflate(inflater, container, false)
        val weather: Weather? = arguments?.parcelable(WEATHER_DATA)

        weather?.let { data ->
            binding.apply {
                textViewCityName.text = data.cityName
                textViewWeatherCondition.text = data.weatherCondition
                textViewWeather.text = data.weather
            }
        } ?: run {
            Toast.makeText(requireContext(), "Hata!!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {
        const val WEATHER_DATA = "weather"

        fun newInstance(weather: Weather): SecTransactionFragment {
            val fragment = SecTransactionFragment()
            val args = Bundle().apply {
                putParcelable(WEATHER_DATA, weather)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
