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
import com.example.taskintern.model.Data
import com.example.taskintern.model.Weather
import com.example.taskintern.view.DetailFragment.Companion.CITY_ID
import com.example.taskintern.view.DetailFragment.Companion.REQUEST_KEY
import com.example.taskintern.view.DetailFragment.Companion.UPDATED_WEATHER

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerViewItem.layoutManager = LinearLayoutManager(requireContext())
        val adapter = Adapter(Data.weatherList)
        adapter.onItemClickListener = { weather ->
            findNavController().navigate(FragmentListDirections.toDetail(weather))
        }
        binding.recyclerViewItem.adapter = adapter

        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val updatedWeather = bundle.getParcelable<Weather>(UPDATED_WEATHER)
            val cityId = bundle.getInt(CITY_ID)
            updatedWeather?.let {
                val index = Data.weatherList.indexOfFirst { weather -> weather.id == cityId }
                if (index != -1) {
                    Data.weatherList[index] = it
                    adapter.notifyItemChanged(index)
                }
            }
        }
        return binding.root
    }
}
