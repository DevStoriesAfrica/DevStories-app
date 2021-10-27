package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentOtpBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment

class OtpFragment : BaseFragment<FragmentOtpBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentOtpBinding::inflate
}