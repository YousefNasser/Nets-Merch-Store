package com.example.netsmerch.screens.listings

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.netsmerch.MerchViewModel
import com.example.netsmerch.R
import com.example.netsmerch.databinding.FragmentListingsBinding

class ListingsFragment : Fragment() {

    private val viewModel: MerchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentListingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listings, container, false)

        viewModel.merchList.observe(viewLifecycleOwner, Observer { list ->
            val linearLayout = binding.linearLayout
            for (merch in list) {
                val textView = TextView(context)
                textView.text = "${merch.name}\n${merch.company}\n" +
                        "${merch.size}\n" +
                        "${merch.description}\n\n\n "

                textView.setTextAppearance(R.style.MerchText)
                textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                linearLayout.addView(textView)
            }
        })

        binding.floatingActionBtn.setOnClickListener {
            findNavController().navigate(ListingsFragmentDirections.actionListingsFragmentToAddNewFragment())
        }

        return binding.root
    }


}