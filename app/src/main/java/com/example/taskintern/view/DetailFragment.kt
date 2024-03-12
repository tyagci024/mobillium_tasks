package com.example.taskintern.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import com.example.taskintern.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<FragmentDetailArgs>()
    val currentWeather = args.currentWeather
    private var randomWeather: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(inflater, container, false)

        //scope function olarak let değil de with
        binding.apply {
            textViewCityName.text = currentWeather.cityName
            textViewWeatherCondition.text = currentWeather.weatherCondition
            textViewWeather.text = currentWeather.weather

            imgRefresh.setOnClickListener {
                randomWeather = (currentWeather.minWeather..currentWeather.maxWeather).random()
                binding.textViewWeather.text = String.format("%d°C", randomWeather)
            }
            buttonSave.setOnClickListener {
                val updatedWeather = args.currentWeather.copy(weather = String.format("%d°C", randomWeather))
                setFragmentResult(REQUEST_KEY, Bundle().apply {
                    putParcelable(UPDATED_WEATHER, updatedWeather)
                    putInt(CITY_ID, args.currentWeather.id)
                }) // FragmentResult bundle taşıyor
            }
        }
        return binding.root
    }

    companion object {
        const val REQUEST_KEY = "requestKey"
        const val UPDATED_WEATHER = "updatedWeather"
        const val CITY_ID = "cityId"
    }
}
