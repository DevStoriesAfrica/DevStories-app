package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentHomeBinding
import com.devstoriesafrica.devstoriesafrica.models.Event
import com.devstoriesafrica.devstoriesafrica.ui.home.adapter.EventsAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
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

        val upcomingRecycler = binding.upcomingEventsRecycler
        upcomingRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        upcomingRecycler.adapter = EventsAdapter(EventsList())

        val pastRecycler = binding.pastEventsRecycler
        pastRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        pastRecycler.adapter = EventsAdapter(EventsList())

        val date = LocalDate.now()
        val todaysDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

        binding.dateTextView.text = todaysDate.toString()
    }

    private fun EventsList(): List<Event>{
        return listOf(
            Event(R.drawable.gatare),
            Event(R.drawable.hannah),
            Event(R.drawable.tabitha),
            Event(R.drawable.wayne)
        )
    }
}