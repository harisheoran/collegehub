package com.example.collegehub.ui.loginui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import com.example.collegehub.R
import com.example.collegehub.databinding.FragmentGoogleAuthBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth


class GoogleAuth : Fragment() {
    private var _binding: FragmentGoogleAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentGoogleAuthBinding.inflate(inflater, container, false)
        binding.btnSignInWithGoogle.setOnClickListener {
            createSignInIntent()
        }
        return binding.root
    }

    // start auth UI, callback for the FirebaseUI Activity result contract
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract(),
    ) { res ->
        this.onSignInResult(res)
    }

    // To kick off the FirebaseUI sign in flow, create a sign in intent with your preferred sign-in methods
    // Choose authentication providers
    val providers = arrayListOf(
        AuthUI.IdpConfig.GoogleBuilder().build(),
    )

    private fun createSignInIntent() {
        // Create and launch sign-in intent
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    // When the sign-in flow is complete, you will receive the result in onSignInResult
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            showToast("Sign-in Success.")
            findNavController().navigate(R.id.action_googleAuth_to_userLoginScreen)

        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            val errorCode = response?.error
            when (errorCode) {
                // Handle specific error codes and display appropriate error messages
                /* FirebaseUiException.ERROR_USER_DISABLED -> {
                     showToast("Account is disabled")
                 }
                 FirebaseUiException.ERROR_EMAIL_ALREADY_IN_USE -> {
                     showToast("Email is already in use")
                 }*/
                // Add more error codes and corresponding error messages as needed
                else -> {
                    showToast("Sign-in failed. Error code: $errorCode")
                }
            }
        }
    }

    // sign out
    private fun signOut() {
        AuthUI.getInstance()
            .signOut(requireContext())
            .addOnCompleteListener {
            }
    }

    private fun themeAndLogo() {
        val providers = emptyList<AuthUI.IdpConfig>()

        // [START auth_fui_theme_logo]
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.physics2) // Set logo drawable
            .setTheme(R.style.AppTheme) // Set theme
            .build()
        signInLauncher.launch(signInIntent)
        // [END auth_fui_theme_logo]
    }

    private fun privacyAndTerms() {
        val providers = emptyList<AuthUI.IdpConfig>()
        // [START auth_fui_pp_tos]
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTosAndPrivacyPolicyUrls(
                "https://example.com/terms.html",
                "https://example.com/privacy.html",
            )
            .build()
        signInLauncher.launch(signInIntent)
        // [END auth_fui_pp_tos]
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}