package com.devstoriesafrica.devstoriesafrica.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devstoriesafrica.devstoriesafrica.databinding.EventItemBinding
import com.devstoriesafrica.devstoriesafrica.models.Event

class EventsAdapter(private val events: List<Event>): RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {

    class EventsViewHolder(val binding: EventItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val binding = EventItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return EventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int): Unit = with(holder.binding){
        val event = events[position]
        val context = holder.itemView.context

        Glide.with(context).load(event.poster).into(eventPosterView)
    }

    override fun getItemCount(): Int = events.size
}