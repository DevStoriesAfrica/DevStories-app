package com.devstoriesafrica.devstoriesafrica.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.ui.activities.MainActivity

abstract class BaseFragment<out T: ViewBinding> : Fragment() {
    private var _binding: ViewBinding? = null
    protected val binding: T
        get() = _binding as T

    //Fragment will override this and set their own value
    protected open var bottomNavigationVisibility = View.VISIBLE

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(bottomNavigationVisibility)
        }
    }
}