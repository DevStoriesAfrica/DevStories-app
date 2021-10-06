package com.devstoriesafrica.devstoriesafrica.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<out T: ViewBinding> : Fragment() {
    private var _binding: ViewBinding? = null
    protected val binding: T
        get() = _binding as T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater)
        return binding.root
    }
    protected abstract val bindingInflater: (LayoutInflater) -> ViewBinding
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}