package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentOtpBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.google.android.material.transition.MaterialFadeThrough

class OtpFragment : BaseFragment<FragmentOtpBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentOtpBinding::inflate

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    private fun setUI() {
        initMaterialTransitions()
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnVerifyEmail.setOnClickListener {
                val otp = otpView.otp
                if (otp.length >= 4) {
                    Toast.makeText(context, "The OTP is $otp", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Less that expected password", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun initMaterialTransitions() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }
}