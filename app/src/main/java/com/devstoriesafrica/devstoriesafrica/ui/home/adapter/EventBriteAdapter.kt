package com.devstoriesafrica.devstoriesafrica.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devstoriesafrica.devstoriesafrica.databinding.EventItemBinding
import com.devstoriesafrica.devstoriesafrica.models.EventX

class EventBriteAdapter : RecyclerView.Adapter<EventBriteAdapter.RemoteViewHolder>() {

    inner class RemoteViewHolder(val binding: EventItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<EventX>() {
        override fun areItemsTheSame(oldItem: EventX, newItem: EventX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EventX, newItem: EventX): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemoteViewHolder {
        val binding = EventItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RemoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RemoteViewHolder, position: Int): Unit = with(holder.binding) {
        val event = differ.currentList[position]
        val context = holder.itemView.context

            Glide.with(context).load(event.logo?.original?.url).into(eventPosterView)

    }

    override fun getItemCount(): Int = differ.currentList.size


}