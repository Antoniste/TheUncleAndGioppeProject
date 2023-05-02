package com.example.theuncleandgioppeproject.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.theuncleandgioppeproject.R
import com.example.theuncleandgioppeproject.databinding.ItemVideoBinding
import com.example.theuncleandgioppeproject.utils.DataBoundListAdapter
import com.example.theuncleandgioppeproject.viewModel.ViewModelCardHome

class RecyclerViewAdapterHome : DataBoundListAdapter<ViewModelCardHome>(
    diffCallback = object : DiffUtil.ItemCallback<ViewModelCardHome>() {

        override fun areItemsTheSame(old: ViewModelCardHome, aNew: ViewModelCardHome): Boolean {
            return old == aNew
        }

        override fun areContentsTheSame(old: ViewModelCardHome, aNew: ViewModelCardHome): Boolean {
            return old.description == aNew.description
        }
    }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_video,
            parent,
            false
        )
    }

    override fun bind(binding: ViewDataBinding, item: ViewModelCardHome) {
        when (binding) {
            is  ItemVideoBinding-> {
                binding.nameItem = item

            }
        }
    }
}