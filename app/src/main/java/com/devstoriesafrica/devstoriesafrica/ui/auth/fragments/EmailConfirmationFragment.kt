package com.devstoriesafrica.devstoriesafrica.ui.auth.fragments


import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devstoriesafrica.devstoriesafrica.R
import com.devstoriesafrica.devstoriesafrica.databinding.FragmentCheckEmailBinding
import com.devstoriesafrica.devstoriesafrica.ui.base.BaseFragment
import com.google.android.material.transition.MaterialFadeThrough
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailConfirmationFragment : BaseFragment<FragmentCheckEmailBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentCheckEmailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        intializeTransitions()
        setUpListeners()
        initialiseSpannedText()

    }

    private fun initialiseSpannedText() {
        val spannableString = SpannableString("Did not receive email? " +
                "Check your spam filter, Or try another email address")

        val foregroundSpan = ForegroundColorSpan(
            ContextCompat.getColor(requireContext(), R.color.yellow)
        )
        spannableString.setSpan(
            foregroundSpan,
            50,
            75,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.bottomMessageTxt.text = spannableString
    }

    private fun setUpListeners() {

        binding.apply {

            btnOpenEmail.setOnClickListener {
                //implicit intent to open email app
            }
            btnSkipEmailCheck.setOnClickListener {
                //navigate back to login screen
                findNavController().navigate(
                    EmailConfirmationFragmentDirections.actionEmailConfirmationFragmentToLoginFragment()
                )
            }
            bottomMessageTxt.setOnClickListener {
            //navigate back to reset password fragment
                findNavController().navigate(
                    EmailConfirmationFragmentDirections.actionEmailConfirmationFragmentToResetPasswordFragment2())
            }

        }

    }

    private fun intializeTransitions() {
        enterTransition = MaterialFadeThrough()
        exitTransition = MaterialFadeThrough()
        reenterTransition = MaterialFadeThrough()
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}