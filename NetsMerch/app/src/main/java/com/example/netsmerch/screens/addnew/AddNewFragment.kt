package com.example.netsmerch.screens.addnew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.netsmerch.MerchViewModel
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentAddNewBinding
import com.example.netsmerch.entities.Merch

class AddNewFragment : Fragment() {

    private val viewModel: MerchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding: FragmentAddNewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_new, container, false)

        binding.saveBtn.setOnClickListener {
            // TODO: Implement the save merch process

            if (validData(
                    binding.editTextName.text.toString(),
                    binding.editTextCompany.text.toString(),
                    binding.editTextSize.text.toString(),
                    binding.editTextDescription.text.toString()
                )
            ) {

                val merch = Merch(
                    binding.editTextName.text.toString(),
                    binding.editTextCompany.text.toString(),
                    binding.editTextSize.text.toString(),
                    binding.editTextDescription.text.toString()
                )

                viewModel.addNewMerch(merch)
                findNavController().navigate(AddNewFragmentDirections.actionAddNewFragmentToListingsFragment())
            } else {
                Toast.makeText(activity, "Please complete the merch data", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.cancelBtn.setOnClickListener {
            findNavController().navigate(AddNewFragmentDirections.actionAddNewFragmentToListingsFragment())

            // TODO: Make sure to destroy the add new fragment or keep it? we'll see the requirements.
        }

        return binding.root
    }

    private fun validData(
        name: String,
        company: String,
        size: String,
        description: String
    ): Boolean {
        return name.isNotBlank() &&
                company.isNotBlank() &&
                size.isNotBlank() &&
                description.isNotBlank()
    }

}