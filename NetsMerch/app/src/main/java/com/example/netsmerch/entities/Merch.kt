package com.example.netsmerch.entities

data class Merch(
    var name: String = "",
    var company: String = "",
    var size: String = "",
    var description: String = ""
) {
    override fun toString(): String {
        return "$name\n$company\n$size\n$description\n\n\n"
    }
}
