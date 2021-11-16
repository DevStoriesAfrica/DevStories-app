package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentPastEventsBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PastEventsFragment : BaseFragment<FragmentPastEventsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentPastEventsBinding::inflate

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
