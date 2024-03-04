package com.example.taskintern.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskintern.adapter.Adapter
import com.example.taskintern.databinding.FragmentListBinding
import com.example.taskintern.model.Weather
import com.example.taskintern.view.FragmentDetail.Companion.CITY_ID
import com.example.taskintern.view.FragmentDetail.Companion.REQUEST_KEY
import com.example.taskintern.view.FragmentDetail.Companion.UPDATED_WATER


class FragmentList : Fragment() {
    lateinit var weatherList: MutableList<Weather>
    private lateinit var binding: FragmentListBinding
    private var updatedTemperature: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        weatherList = mutableListOf(
            Weather(0, "Ankara", "25°C", 10, 28, "Rüzgarlı"),
            Weather(1, "İzmir", "20°C", 12, 29, "Bulutlu"),
            Weather(2, "İstanbul", "19°C", 11, 23, "Güneşli")
        )


        binding.recyclerViewItem.layoutManager = LinearLayoutManager(requireContext())
        val adapter = Adapter(requireContext(), weatherList)

        adapter.onItemClickListener= {
            findNavController()
                .navigate(FragmentListDirections.actionFragmentListToFragmentDetail(it))
        }
        binding.recyclerViewItem.adapter = adapter

        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val updatedWeather = bundle.getParcelable<Weather>(UPDATED_WATER)
            val cityId = bundle.getInt(CITY_ID)
            updatedWeather?.let {
                val index = weatherList.indexOfFirst { weather -> weather.id == cityId }
                if (index != -1) {
                    weatherList[index] = it
                    adapter.notifyItemChanged(index)
                }
            }
        }
        return binding.root
    }
}

