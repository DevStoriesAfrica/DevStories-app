package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentPastEventsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastEventsFragment : Fragment() {
    private lateinit var binding: FragmentPastEventsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPastEventsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager_onboarding)
        binding.pastEventsButton.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.pastEventsSkip.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
