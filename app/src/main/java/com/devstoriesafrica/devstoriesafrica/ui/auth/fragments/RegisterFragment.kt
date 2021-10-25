package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentRegisterBinding
import com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel.AuthViewModel
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.devstoriesafrica.devstoriesafrica.utils.Status
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    private val viewModel: AuthViewModel by activityViewModels()
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentRegisterBinding::inflate

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {
        initMaterialTransitions()
        initSpannable()
        initListeners()
        observeViewModel()
    }

    private fun initMaterialTransitions() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }

    private fun initListeners() {
        binding.txtExistingUser.setOnClickListener {
            findNavController().navigate(
                RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            )
        }

        binding.btnSignup.setOnClickListener {
            val userName = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etCPassword.text.toString()

            when {
                userName.isEmpty() -> {
                    binding.etUsername.error = "Enter Username"
                }
                email.isEmpty() -> {
                    binding.etUsername.error = "Enter Email"
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Enter Password"
                }
                confirmPassword.isEmpty() -> {
                    binding.etCPassword.error = "Confirm Password"
                }
                password != confirmPassword -> {
                    binding.etCPassword.error = "Passwords should match"
                }
                else -> {
                    viewModel.signUp(
                        userName = userName,
                        email = email,
                        password = password
                    )
                }
            }


        }

    }

    private fun initSpannable() {
        val spanString = SpannableString(getString(R.string.existing_user))
        val foregroundSpan = ForegroundColorSpan(
            ContextCompat.getColor(requireContext(), R.color.yellow)
        )
        spanString.setSpan(
            foregroundSpan,
            25,
            30,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.txtExistingUser.text = spanString
    }

    private fun observeViewModel() {
        viewModel.signUpStatus.observe(viewLifecycleOwner, { result ->
            result?.let {
                when (result.status) {
                    Status.SUCCESS -> {
                        //TODO: add navigation
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "Error while creating account", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        })
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}