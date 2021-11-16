package com.devstoriesafrica.devstoriesafrica.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.data.datastore.DataStoreManager
import com.devstoriesafrica.devstoriesafrica.databinding.ActivityMainBinding
import com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferences: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DevStoriesAfrica)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val onBoardingFinished = viewModel.onBoardingFinished

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navGraph = navHostFragment.navController.navInflater.inflate(R.navigation.nav_graph)

        // change the start destination dynamically
        if (onBoardingFinished) {
            navGraph.startDestination = R.id.loginFragment
        } else {
            navGraph.startDestination = R.id.viewPagerFragment
        }

        navHostFragment.navController.graph = navGraph
    }
}
