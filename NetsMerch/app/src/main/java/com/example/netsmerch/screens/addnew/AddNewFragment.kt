package com.example.netsmerch.screens.addnew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentAddNewBinding

class AddNewFragment : Fragment() {

    companion object {
        fun newInstance() = AddNewFragment()
    }

    private lateinit var viewModel: AddNewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding: FragmentAddNewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_new, container, false)

        binding.saveBtn.setOnClickListener {
            findNavController().navigate(AddNewFragmentDirections.actionAddNewFragmentToListingsFragment())

            // TODO: Implement the save merch process
        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(AddNewFragmentDirections.actionAddNewFragmentToListingsFragment())

            // TODO: Make sure to destroy the add new fragment or keep it? we'll see the requirements.
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddNewViewModel::class.java]
        // TODO: Use the ViewModel
    }

}