package com.example.theuncleandgioppeproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.theuncleandgioppeproject.databinding.FragmentBiometricTestBinding
import java.util.concurrent.Executor

class TestBiometric : Fragment() {

    private lateinit var binding: FragmentBiometricTestBinding
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var executor: Executor
    lateinit var promptInfo: BiometricPrompt.PromptInfo


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBiometricTestBinding.inflate(layoutInflater)
        executor = ContextCompat.getMainExecutor(requireActivity())
        biometricPrompt = BiometricPrompt(
            requireActivity(),
            executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    binding.authStatusTV.text = "Authentication Failed!"
                    Toast.makeText(requireContext(), "Authentication Failed", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    binding.authStatusTV.text = "Authentication error $errString"
                    Toast.makeText(
                        requireContext(),
                        "Authentication Error:$errString",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    binding.authStatusTV.text = "Authentication Succeded!"
                    Toast.makeText(requireContext(), "Authentication Succeded", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric Authentication")
            .setSubtitle("Login using fingerprint authentication")
            .setNegativeButtonText("use app Password instead")
            .build()
        binding.authBtn.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }


        // Inflate the layout for this fragment


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
