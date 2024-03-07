package com.example.taskintern.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskintern.databinding.ActivitySelectTaskBinding

class SelectTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        binding.task1.setOnClickListener {
            startNewActivity(ListWeatherActivity::class.java)
        }
        binding.task2.setOnClickListener {
            startNewActivity(ActivityForTransactionFragments::class.java)
        }
        binding.task3.setOnClickListener {
            startNewActivity(MainActivity::class.java)
        }
        binding.task4.setOnClickListener {
            startNewActivity(HomeUI::class.java)
        }
    }

    private fun startNewActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

}