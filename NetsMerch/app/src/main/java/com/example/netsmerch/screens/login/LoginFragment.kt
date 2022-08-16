package com.example.netsmerch.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.databinding.DataBindingUtil
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*
         * NOTE: this page isn't functional, it's just required as the initial page.
         */

        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        // Setting up the login button click listener to navigate to the welcome page.
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // Setting up the register button click listener to navigate to the welcome page.
        binding.registerBtn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        // Returns the layout view
        return binding.root
    }

}