package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentEventDetailsBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailsFragment : BaseFragment<FragmentEventDetailsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentEventDetailsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
