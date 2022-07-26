package com.example.netsmerch.screens.listings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentListingsBinding

class ListingsFragment : Fragment() {

    companion object {
        fun newInstance() = ListingsFragment()
    }

    private lateinit var viewModel: ListingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listings, container, false)

        binding.floatingActionBtn.setOnClickListener {
            findNavController().navigate(ListingsFragmentDirections.actionListingsFragmentToAddNewFragment())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListingsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}