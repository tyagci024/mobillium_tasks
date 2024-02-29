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
    private var randomWeather:Int=0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        binding.cityName.setText(args.currentWeather.cityName)
        binding.textViewWeather.setText(args.currentWeather.weather)
        binding.weatherCondition.setText(args.currentWeather.weatherCondition)

        binding.imgRefresh.setOnClickListener {
            randomWeather = (args.currentWeather.minWeather..args.currentWeather.maxWeather).random()
            binding.textViewWeather.text = "$randomWeather°C"
        }

        binding.buttonSave.setOnClickListener {
            val updatedWeather = args.currentWeather.copy(weather = "$randomWeather°C")
            setFragmentResult("requestKey", Bundle().apply {
                putParcelable("updatedWeather", updatedWeather)
                putInt("cityId", args.currentWeather.id)
            })//FragmentResult bundle taşıyor



        }


        return binding.root
    }

}