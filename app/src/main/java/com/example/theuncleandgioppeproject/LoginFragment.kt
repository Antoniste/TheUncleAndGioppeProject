package com.example.theuncleandgioppeproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.theuncleandgioppeproject.databinding.FragmentLoginBinding
import com.example.theuncleandgioppeproject.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentLoginBinding
     private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.butLogin.setOnClickListener {
            val email = binding.editEmail.text
            val password = binding.editPassword.text
            val keyboard =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(binding.root.windowToken, 0)
            lifecycleScope.launch {
                loginViewModel.select("$email", "$password")
            }
          }
       }
    }

