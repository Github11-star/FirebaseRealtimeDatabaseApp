package com.firozpocyt.firebaserealtimedatabaseapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firozpocyt.firebaserealtimedatabaseapp.R
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}