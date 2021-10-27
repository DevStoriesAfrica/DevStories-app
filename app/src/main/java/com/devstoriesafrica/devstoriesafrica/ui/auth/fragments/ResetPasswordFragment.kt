package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentResetPasswordBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>(){

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentResetPasswordBinding::inflate


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
        initializeListeners()
    }

    private fun initializeListeners() {
        binding.apply {
            btnSendPassReset.setOnClickListener {
                //handle send password reset email event here
            }

            backButton.setOnClickListener {
                //navigate back to previous fragment
                findNavController().navigate(
                    ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                )
            }

        }
    }

    private fun initMaterialTransitions() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }


    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }



}