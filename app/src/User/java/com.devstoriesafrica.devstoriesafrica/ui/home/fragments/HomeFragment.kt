package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentHomeBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.devstoriesafrica.devstoriesafrica.ui.home.adapter.EventBriteAdapter
import com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel.HomeViewModel
import com.devstoriesafrica.devstoriesafrica.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by activityViewModels()
    private val remoteEventsAdapter = EventBriteAdapter()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var upcomingRecycler: RecyclerView
    private lateinit var pastRecycler: RecyclerView
    private lateinit var progressBar: ProgressBar
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentHomeBinding::inflate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEvents()
        observeViewModel()

        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews() {

        remoteEventsAdapter.setOnItemClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEventDetailsFragment())
        }

        binding.profileImageLayout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_eventDetailsFragment)
        }
        progressBar = binding.homeProgressBar

        upcomingRecycler = binding.upcomingEventsRecycler
        upcomingRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        pastRecycler = binding.pastEventsRecycler
        pastRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        progressBar.visibility = View.VISIBLE

        val todaysDate = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        binding.dateTextView.text = todaysDate.toString()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.liveFragment,
                R.id.aboutFragment
            )
        )
    }

    private fun observeViewModel() {
        viewModel.getEventsStatus.observe(viewLifecycleOwner, { result ->
            result?.let {
                when (result.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        // Toast.makeText(context,"${result.data}",Toast.LENGTH_LONG).show()
                        result.data?.let {
                            remoteEventsAdapter.differ.submitList(it.events)
                            upcomingRecycler.adapter = remoteEventsAdapter
                            pastRecycler.adapter = remoteEventsAdapter
                        }
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                    }
                }
            }
        })
    }
}
