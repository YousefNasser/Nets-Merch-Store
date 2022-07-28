package com.example.netsmerch.screens.listings

import android.content.res.Resources
import android.graphics.Paint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.print.PrintAttributes
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
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
    ): View {
        val binding: FragmentListingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_listings, container, false)

        viewModel = ViewModelProvider(this)[ListingsViewModel::class.java]

        binding.listingsViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.merchList.observe(viewLifecycleOwner, Observer {
            val linearLayout = binding.linearLayout
            for (merch in it) {
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