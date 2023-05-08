package com.example.theuncleandgioppeproject

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import com.example.theuncleandgioppeproject.databinding.FragmentLoginBinding
import com.example.theuncleandgioppeproject.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()


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
