package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentTopEventsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopEventsFragment : Fragment() {
    private lateinit var binding: FragmentTopEventsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopEventsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topEventsButton.setOnClickListener {
            findNavController().navigate(R.id.action_topEventsFragment_to_pastEventsFragment)
        }
    }
}
