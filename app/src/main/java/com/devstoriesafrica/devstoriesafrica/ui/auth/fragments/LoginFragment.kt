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
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentLoginBinding
import com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel.AuthViewModel
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.devstoriesafrica.devstoriesafrica.utils.Status
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    private val viewModel: AuthViewModel by activityViewModels()
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
        initResetPassSpannable()
        initListeners()
        observeViewModel()
        initSocialMediaViews()
    }

    private fun initSocialMediaViews(){
        binding.includeSocial.fbRegister.visibility = View.GONE
        binding.includeSocial.fbLogin.visibility = View.VISIBLE
        binding.includeSocial.googleRegister.visibility = View.GONE
        binding.includeSocial.googleLogin.visibility = View.VISIBLE
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


        binding.forgotPasswordTxt.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment()
            )
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            when {
                email.isEmpty() -> {
                    binding.etEmail.error = "Enter Email"
                }
                password.isEmpty() -> {
                    binding.etPassword.error = "Enter Password"
                }
                else -> {
                    viewModel.login(email = email, password = password)
                }
            }

            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            )
        }
    }

    private fun initSpannable() {
        val spanString = SpannableString("Don’t have an account? SignUp")
        val foregroundSpan = ForegroundColorSpan(
            ContextCompat.getColor(requireContext(), R.color.yellow)
        )
        spanString.setSpan(
            foregroundSpan,
            23,
            29,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.txtNewUser.text = spanString
    }

    private fun initResetPassSpannable() {
        val spannableString = SpannableString("Forgot Password? Reset")
        val foregroundColorSpan = ForegroundColorSpan(
            ContextCompat.getColor(requireContext() , R.color.yellow)
        )
        spannableString.setSpan(
            foregroundColorSpan,
            17,
            22,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.forgotPasswordTxt.text = spannableString
    }

    //observe the data in the viewmodel
    private fun observeViewModel() {
        viewModel.loginStatus.observe(viewLifecycleOwner, { response ->
            response?.let {
                when (response.status) {
                    Status.SUCCESS -> {
                        findNavController().navigate(
                            LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                        )
                    }
                    Status.LOADING -> {

                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "${response.message}", Toast.LENGTH_LONG).show()
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