package com.example.taskintern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskintern.R
import com.example.taskintern.adapter.FragToFragAdapter
import com.example.taskintern.databinding.FragmentListBinding
import com.example.taskintern.databinding.FragmentWONavCompFirsBinding
import com.example.taskintern.model.Weather


class WONavCompFirsFragment : Fragment() {
    private lateinit var binding: FragmentWONavCompFirsBinding
    private lateinit var weatherList:List<Weather>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentWONavCompFirsBinding.inflate(inflater,container,false)

        weatherList = listOf(
            Weather(0,"Ankara", "25°C", 10,28,"Rüzgarlı"),
            Weather(1,"İzmir", "20°C",12 ,29,"Bulutlu"),
            Weather(2,"İstanbul", "19°C", 11,23,"Güneşli")
        )

        binding.recyclerViewItem.layoutManager= LinearLayoutManager(requireContext())

        val adapter = FragToFragAdapter(weatherList) { weather ->
            // Handle item click here, navigate to WONavCompSecFragment
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,
                WONavCompSecFragment.newInstance(weather))//secfragmenta verileri iletiyoz
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.recyclerViewItem.adapter = adapter

        return binding.root
    }



}