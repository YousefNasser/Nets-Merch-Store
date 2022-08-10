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
import com.example.netsmerch.MerchViewModel
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentListingsBinding
import com.example.netsmerch.entities.Merch

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
                requireView().findNavController()
                    .navigate(ListingsFragmentDirections.actionListingsFragmentToLoginFragment())
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Observing the live data merchList to keep the listings up to date
        viewModel.merchList.observe(viewLifecycleOwner) { list ->
            val linearLayout = binding.linearLayout
            for (merch in list) {
                val textView = generateTextView(merch)
                linearLayout.addView(textView)
            }
        }

        // Listening to the floatingActionBtn addNew to navigate to AddNew fragment whenever pressed
        binding.floatingActionBtn.setOnClickListener {
            findNavController().navigate(ListingsFragmentDirections.actionListingsFragmentToAddNewFragment())
        }
    }

    /**
     * Generates the textView by adding all the merch data as text and
     * styles the textView.
     *
     * @param merch the Merch to be represented in the TextView
     * @return Return the TextView representing the Merch data
     */
    private fun generateTextView(merch: Merch): TextView {
        val textView = TextView(context)
        textView.text = merch.toString()
        textView.setTextAppearance(R.style.MerchText)
        textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        return textView
    }

}