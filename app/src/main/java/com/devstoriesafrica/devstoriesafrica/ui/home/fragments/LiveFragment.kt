
package com.devstoriesafrica.devstoriesafrica.ui.home.fragments

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentLiveBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveFragment : BaseFragment<FragmentLiveBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLiveBinding::inflate
}