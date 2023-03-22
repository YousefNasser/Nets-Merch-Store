package com.example.netsmerch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netsmerch.entities.Merch

class MerchViewModel : ViewModel() {

    // Encapsulating the _merchList LiveData
    private val _merchList = MutableLiveData<MutableList<Merch>>()
    val merchList: LiveData<MutableList<Merch>>
        get() = _merchList


    /**
     * Initialize the merch list data.
     */
    private fun initMerchList() {
        _merchList.value = mutableListOf(
            Merch("Kidd #5 Jersey", "Adidas", "XL", "Nets Classic Jersey"),
            Merch("Claxton #33 Jersey", "Nike", "L", "Nets White Basquiat Jersey"),
            Merch("Erving #32 Jersey", "Nike", "L", "Nets 72' Classic Jersey"),
            Merch("Harris #12 Jersey", "Nike", "S", "Nets City Edition Jersey"),
            Merch("Simmons #10 Jersey", "Nike", "L", "Nets Association White Jersey"),
            Merch("Mills #8 Jersey", "Nike", "M", "Nets Association Black Jersey"),
            Merch("Thomas #24 Shorts", "Nike", "M", "Nets Association Black Shorts"),
        )
    }


    // Init block – runs after the primary constructor
    init {
        initMerchList()
    }

    /**
     * Adds a new merch to the merchList.
     *
     * @param merch the new Merch to be added to the list.
     */

    fun addNewMerch(merch: Merch) {
        _merchList.value?.add(merch)
    }

}