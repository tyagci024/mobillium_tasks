package com.example.taskintern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskintern.databinding.ActivitySelectTaskBinding

class SelectTask : AppCompatActivity() {
    private lateinit var binding: ActivitySelectTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.task1.setOnClickListener {
            val intent = Intent(this, ListWeatherActivity::class.java)
            startActivity(intent)
        }
        binding.task2.setOnClickListener {
            val intent = Intent(this, WONavCompActivity::class.java)
            startActivity(intent)
        }
        binding.task3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.task4.setOnClickListener {
            val intent = Intent(this, HomeUI::class.java)
            startActivity(intent)

        }

    }
}