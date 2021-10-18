package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentHomeBinding
import com.devstoriesafrica.devstoriesafrica.models.EventX
import com.devstoriesafrica.devstoriesafrica.ui.home.adapter.EventBriteAdapter
import com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel.HomeViewModel
import com.devstoriesafrica.devstoriesafrica.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private val remoteEventsAdapter = EventBriteAdapter()
    private lateinit var upcomingRecycler: RecyclerView
    private lateinit var pastRecycler: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getEvents()
        observeViewModel()

        progressBar = binding.homeProgressBar

        upcomingRecycler = binding.upcomingEventsRecycler
        upcomingRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        pastRecycler = binding.pastEventsRecycler
        pastRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)


        progressBar.visibility = View.VISIBLE

        val todaysDate= LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        binding.dateTextView.text = todaysDate.toString()
    }

    private fun observeViewModel(){
        viewModel.getEventsStatus.observe(viewLifecycleOwner,{ result ->
            result?.let {
                when(result.status){
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        result.data?.let {
                            //if (it.events.forEach())
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