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
    private var merch = Merch()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding: FragmentAddNewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_new, container, false)

        // Setting up the 2-way data-binding
        binding.merch = merch

        // Setting up the save button click listener to facilitate the saving procedure.
        binding.saveBtn.setOnClickListener {
            if (validData()) {
                viewModel.addNewMerch(merch)
                findNavController().navigate(AddNewFragmentDirections.actionAddNewFragmentToListingsFragment())
            } else {
                Toast.makeText(activity, "Please complete the merch data", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        // Setting up the cancel button click listener to navigate up to the navigation hierarchy.
        binding.cancelBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        // Returns the layout view
        return binding.root
    }

    /**
     * Validate that all the merch input data aren't blank.
     *
     * @return Return true if all merch data is not blank, false otherwise.
     */

    private fun validData(): Boolean {
        return merch.name.isNotBlank() &&
                merch.company.isNotBlank() &&
                merch.size.isNotBlank() &&
                merch.description.isNotBlank()
    }

}