package com.devstoriesafrica.devstoriesafrica.ui.auth.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentViewPagerBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerFragment : BaseFragment<FragmentViewPagerBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentViewPagerBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPagerOnboarding.adapter = ScreenSlidePagerAdapter(this.requireActivity())
    }

    inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = fragmentList.size

        override fun createFragment(position: Int): Fragment = fragmentList[position]
    }

    val fragmentList = listOf(
        TopEventsFragment(),
        PastEventsFragment(),
        NotificationsFragment()
    )
}
