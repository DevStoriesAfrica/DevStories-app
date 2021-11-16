package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentAboutBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BaseFragment<FragmentAboutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAboutBinding::inflate
}
