package com.example.taskintern.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskintern.R
import com.example.taskintern.adapter.Adapter
import com.example.taskintern.databinding.FragmentWONavCompFirsBinding
import com.example.taskintern.model.Weather


class WONavCompFirsFragment : Fragment() {
    private lateinit var binding: FragmentWONavCompFirsBinding
    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWONavCompFirsBinding.inflate(inflater, container, false)

        val weatherList = listOf(
            Weather(0, "Ankara", "25°C", 10, 28, "Rüzgarlı"),
            Weather(1, "İzmir", "20°C", 12, 29, "Bulutlu"),
            Weather(2, "İstanbul", "19°C", 11, 23, "Güneşli")
        )

        adapter = Adapter(requireContext(), weatherList)
        adapter.onItemClickListener = { weather ->
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.fragment_container,
                WONavCompSecFragment.newInstance(weather)
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        binding.recyclerViewItem.adapter = adapter
        binding.recyclerViewItem.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }
}