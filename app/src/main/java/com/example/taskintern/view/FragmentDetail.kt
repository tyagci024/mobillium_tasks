package com.example.taskintern.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.taskintern.R
import com.example.taskintern.databinding.FragmentDetailBinding

class FragmentDetail : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<FragmentDetailArgs>()

    companion object {
        const val REQUEST_KEY = "requestKey"
        const val UPDATED_WEATHER = "updatedWeather"
        const val CITY_ID = "cityId"
    }

    private var randomWeather: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.cityName.text = args.currentWeather.cityName
        binding.textViewWeather.text = args.currentWeather.weather
        binding.weatherCondition.text = args.currentWeather.weatherCondition

        binding.imgRefresh.setOnClickListener {
            randomWeather = (args.currentWeather.minWeather..args.currentWeather.maxWeather).random()
            binding.textViewWeather.text = "$randomWeather°C"
        }

        binding.buttonSave.setOnClickListener {
            val updatedWeather = args.currentWeather.copy(weather = "$randomWeather°C")
            setFragmentResult(REQUEST_KEY, Bundle().apply {
                putParcelable(UPDATED_WEATHER, updatedWeather)
                putInt(CITY_ID, args.currentWeather.id)
            }) // FragmentResult bundle taşıyor
        }

        return binding.root
    }

}