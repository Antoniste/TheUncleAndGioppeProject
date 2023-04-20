package com.example.theuncleandgioppeproject.core.network.base.viewModel

import androidx.lifecycle.ViewModel

class ItemViewModel (
    val name: String?,
    val description: String?,
    val sourceUrl: String?): ViewModel() {
        fun Any.convert():String{
            return this.toString()
        }
}