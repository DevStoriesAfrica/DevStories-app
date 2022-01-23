package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentTopEventsBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopEventsFragment : BaseFragment<FragmentTopEventsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentTopEventsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager_onboarding)

        binding.topEventsButton.setOnClickListener {
            viewPager?.currentItem = 1
        }
        binding.topEventsSkip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingFinished()
        }
    }

    private fun onBoardingFinished() {
        // TODO: switch to datastore and create a module
        val sharedPref = requireActivity().getSharedPreferences(
            "com.devstoriesafrica.devstoriesafrica",
            Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}
