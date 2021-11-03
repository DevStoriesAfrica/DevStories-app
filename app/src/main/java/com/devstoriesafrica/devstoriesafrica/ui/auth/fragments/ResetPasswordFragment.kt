
package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentResetPasswordBinding
import com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel.AuthViewModel
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.devstoriesafrica.devstoriesafrica.utils.Status
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>() {

    private val authViewModel : AuthViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        initMaterialTrans()
        setUpListeners()
        observeLiveData()
    }

    private fun observeLiveData() {

        authViewModel.resetPasswordStatus.observe(viewLifecycleOwner , { response ->

            response?.let {
                when(response.status){
                    Status.SUCCESS -> {
                        //email is sent , trigger navigation back to login fragment or to email app
                    }

                    Status.LOADING -> {
                        //hide send reset email button show progress bar
                    }

                    Status.ERROR -> {
                        //show error message(toast ,SnackBar or TextField etc)
                    }
                }
            }

        })

    }

    private fun setUpListeners() {
        binding.apply {
            backButton.setOnClickListener {
                findNavController().navigate(
                    ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                )
            }

            btnSendPassReset.setOnClickListener {
                //handle password reset email sending here
                val email = binding.resetEmailEt.text.toString()
                if(email.isEmpty()){
                    binding.resetEmailLayout.error = getString(R.string.email_field_error_message)
                }else{
                    authViewModel.resetPassword(email)

                    //this is just temporary. When the apis are setup , navigation from this fragment
                    //to confirmation fragment will be happen when the email has been sent successfully
                    findNavController().navigate(
                        ResetPasswordFragmentDirections.actionResetPasswordFragmentToEmailConfirmationFragment()
                    )

                }
            }
        }
    }

    private fun initMaterialTrans() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentResetPasswordBinding::inflate

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

}

