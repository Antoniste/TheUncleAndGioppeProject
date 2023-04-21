package com.example.theuncleandgioppeproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.theuncleandgioppeproject.databinding.ItemVideoBinding
import com.example.theuncleandgioppeproject.viewModel.ItemViewModel

class RecyclerViewAdapter(
    private val lifecycleOwner: LifecycleOwner,
) : ListAdapter<ItemViewModel, RecyclerViewAdapter.Holder>(
    DiffCallback
) {
    lateinit var binding: ItemVideoBinding

    class Holder(binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        binding.lifecycleOwner = lifecycleOwner
        return Holder(binding)
    }
    // come sempre qui andremo a bindare l'item che andremo a ripetere nel Recycler
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = getItem(position)
        binding.itemVM = item
    }

    object DiffCallback : DiffUtil.ItemCallback<ItemViewModel>() {
        override fun areItemsTheSame(old: ItemViewModel, aNew: ItemViewModel): Boolean {
            return old == aNew
        }

        override fun areContentsTheSame(old: ItemViewModel, aNew: ItemViewModel): Boolean {
            return old.sourceUrl == aNew.sourceUrl
        }
    }
}