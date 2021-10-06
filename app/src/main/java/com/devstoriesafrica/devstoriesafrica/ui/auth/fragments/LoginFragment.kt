package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.content.Context
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentLoginBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentLoginBinding::inflate

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        initMaterialTransitions()
        initSpannable()
        initListeners()
    }
    private fun initMaterialTransitions() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }

    private fun initListeners() {
        binding.txtNewUser.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            )
        }
    }

    private fun initSpannable() {
        val spanString = SpannableString("Don’t have an account? SignUp")
        val foregroundSpan = ForegroundColorSpan(
            ContextCompat.getColor(requireContext(), R.color.yellow))
        spanString.setSpan(foregroundSpan,
            23,
            29,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.txtNewUser.text = spanString
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}