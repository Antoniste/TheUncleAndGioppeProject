package com.example.theuncleandgioppeproject
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.theuncleandgioppeproject.databinding.FragmentLoginBinding
import com.example.theuncleandgioppeproject.viewModel.LoginViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executor

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var executor: Executor
    lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(layoutInflater)
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
                    findNavController().navigate(R.id.nav_graph_second_part)
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetBehaviorLogin= BottomSheetBehavior.from(binding.constraintBottomSheet)
        bottomSheetBehaviorLogin.apply {
            peekHeight=100
            this.state=BottomSheetBehavior.STATE_COLLAPSED
        }
        binding.butBiometric.setOnClickListener{
            binding.constraintBottomSheet.visibility=View.VISIBLE
            bottomSheetBehaviorLogin.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehaviorLogin.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState==BottomSheetBehavior.STATE_COLLAPSED) {
                       binding.constraintBottomSheet.visibility=View.INVISIBLE
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
            })


        }
        if(loginViewModel.preferencesManager.credentialUser){
            loginViewModel.preferencesManager.userEmail.let {
                binding.editEmail.setText(it)
            }
            loginViewModel.preferencesManager.userPassword.let {
                binding.editPassword.setText(it)
            }
            binding.checkboxRicorda.isChecked=loginViewModel.preferencesManager.credentialUser
        }


        binding.butSig.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        binding.editEmail.doOnTextChanged { text, _, _, _ ->
            binding.butLogin.isEnabled =
                text.toString().isNotEmpty() && binding.editPassword.text.toString()
                    .isNotEmpty()
        }
        binding.editPassword.doOnTextChanged { text, _, _, _ ->
            binding.butLogin.isEnabled =
                text.toString().isNotEmpty() && binding.editEmail.text.toString()
                    .isNotEmpty()
        }
        if (binding.butLogin.text.isNotEmpty() && binding.editPassword.text.isNotEmpty()){
            binding.butLogin.isEnabled=true
        }
        binding.butLogin.setOnClickListener {
            val email = binding.editEmail.text
            val password = binding.editPassword.text
            val keyboard = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(binding.root.windowToken, 0)
            loginViewModel.select("$email", "$password")
            loginViewModel.userLive.observe(viewLifecycleOwner) {
                if (it != null) {
                    loginViewModel.changeCredential(binding.checkboxRicorda.isChecked)
                    loginViewModel.update()
                    findNavController().navigate(R.id.nav_graph_second_part)
                }
            }
         }
       }
    }
