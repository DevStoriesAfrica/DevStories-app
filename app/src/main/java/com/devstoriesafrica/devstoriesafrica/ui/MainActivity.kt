package com.devstoriesafrica.devstoriesafrica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DevStoriesAfrica)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}