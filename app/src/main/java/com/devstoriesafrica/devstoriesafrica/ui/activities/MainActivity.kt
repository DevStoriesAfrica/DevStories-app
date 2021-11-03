package com.devstoriesafrica.devstoriesafrica.ui.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.ActivityMainBinding
import com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()
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

        // val navHost = supportFragmentManager
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph

        // change the start destination dynamically
        if (onBoardingFinished()) {
            navGraph.startDestination = R.id.loginFragment
        } else {
            navGraph.startDestination = R.id.viewPagerFragment
        }

        binding.bottomNavigation.setupWithNavController(navController)

        // Certain fragments will have bottom nav
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.liveFragment -> showBottomNav()
                R.id.aboutFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }

    // TODO: switch to datastore and create a module
    private fun onBoardingFinished(): Boolean {
        val sharedPref = getSharedPreferences(
            "com.devstoriesafrica.devstoriesafrica",
            Context.MODE_PRIVATE
        )
        return sharedPref.getBoolean("Finished", false)
    }
}
