package com.example.c3lesson5hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.c3lesson5hw5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(com.google.android.material.R.id.container, StartFragment())
            .addToBackStack(null).commit()

    }
}