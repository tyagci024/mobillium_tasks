package com.example.taskintern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskintern.R
import com.example.taskintern.databinding.FragmentWONavCompSecBinding
import com.example.taskintern.model.Weather


class WONavCompSecFragment : Fragment() {
    private lateinit var binding:FragmentWONavCompSecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentWONavCompSecBinding.inflate(inflater, container,false)

        val weather: Weather = arguments?.getParcelable("weather") !!

        binding.cityName.text = weather.cityName
        binding.textViewWeather.text = weather.weather
        binding.weatherCondition.text = weather.weatherCondition
        return binding.root
    }

    companion object {
        fun newInstance(weather: Weather): WONavCompSecFragment {
            val fragment = WONavCompSecFragment()
            val args = Bundle()
            args.putParcelable("weather", weather)
            fragment.arguments = args
            return fragment
        }
    }

}