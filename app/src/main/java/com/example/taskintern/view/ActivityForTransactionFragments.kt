package com.example.taskintern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskintern.R
import com.example.taskintern.databinding.ActivityWonavCompBinding

class ActivityForTransactionFragments : AppCompatActivity() {
    private lateinit var  binding:ActivityWonavCompBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWonavCompBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FragmentFirstTransaction()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, firstFragment)
            .commit()
    }
}