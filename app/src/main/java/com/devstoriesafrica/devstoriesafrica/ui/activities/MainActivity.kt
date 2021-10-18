package com.devstoriesafrica.devstoriesafrica.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DevStoriesAfrica)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.liveFragment,
                R.id.aboutFragment
            )
        )

        //val navHost = supportFragmentManager
        val navController = findNavController(R.id.nav_host)

        binding.bottomNavigation.setupWithNavController(navController)

    }
}