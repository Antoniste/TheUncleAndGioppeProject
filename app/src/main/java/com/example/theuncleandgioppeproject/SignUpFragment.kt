package com.example.theuncleandgioppeproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.theuncleandgioppeproject.databinding.FragmentLoginBinding
import com.example.theuncleandgioppeproject.databinding.FragmentSignUpBinding
import com.example.theuncleandgioppeproject.db.UserPorn
import com.example.theuncleandgioppeproject.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SignUpFragment : Fragment() {
        // TODO: Rename and change types of parameters
        private lateinit var binding: FragmentSignUpBinding
         val loginViewModel: LoginViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding= FragmentSignUpBinding.inflate(layoutInflater)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
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
                val email = binding.editEmail.text.toString()
                val password = binding.editPassword.text.toString()
                val keyboard = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                keyboard.hideSoftInputFromWindow(binding.root.windowToken, 0)
                lifecycleScope.launch {
                    loginViewModel.insertUser(UserPorn(binding.editEmail.text.toString(), binding.editPassword.text.toString()))
                }
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }
