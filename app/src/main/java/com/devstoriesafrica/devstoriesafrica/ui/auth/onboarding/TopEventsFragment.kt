package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
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
