package com.example.netsmerch.screens.listings

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.netsmerch.MerchViewModel
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentListingsBinding
import com.example.netsmerch.databinding.NewMerchBinding
import com.example.netsmerch.entities.Merch
import com.example.netsmerch.screens.instructions.InstructionsFragmentDirections

class ListingsFragment : Fragment() {

    private val viewModel: MerchViewModel by activityViewModels()
    private lateinit var binding: FragmentListingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Adding the logout menu to the fragment via MenuHost and MenuProvider
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.title) {
                    "Logout" -> {
                        requireView().findNavController()
                            .navigate(ListingsFragmentDirections.actionListingsFragmentToLoginFragment())
                        true
                    }
                    "Instructions" -> {
                        requireView().findNavController()
                            .navigate(ListingsFragmentDirections.actionListingsFragmentToInstructionsFragment())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Observing the live data merchList to keep the listings up to date
        viewModel.merchList.observe(viewLifecycleOwner) { list ->
            val linearLayout = binding.linearLayout
            for (merch in list) {
                val merchBinding : NewMerchBinding = DataBindingUtil.inflate(layoutInflater, R.layout.new_merch, null, false)

                merchBinding.nameTextView.text = merch.name
                merchBinding.companyTextView.text = merch.company
                merchBinding.sizeTextView.text =  merch.size
                merchBinding.descriptionTextView.text = merch.description

                linearLayout.addView(merchBinding.root)
            }
        }

        // Listening to the floatingActionBtn addNew to navigate to AddNew fragment whenever pressed
        binding.floatingActionBtn.setOnClickListener {
            findNavController().navigate(ListingsFragmentDirections.actionListingsFragmentToAddNewFragment())
        }
    }

}