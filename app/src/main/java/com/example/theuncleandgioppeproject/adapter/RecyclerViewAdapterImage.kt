package com.example.theuncleandgioppeproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.theuncleandgioppeproject.R
import com.example.theuncleandgioppeproject.databinding.CarouselItemBinding
import com.example.theuncleandgioppeproject.model.ImageModel
import com.example.theuncleandgioppeproject.utils.DataBoundListAdapter

class RecyclerViewAdapterImage : DataBoundListAdapter<ImageModel>(
        diffCallback = object : DiffUtil.ItemCallback<ImageModel>() {

            override fun areItemsTheSame(old: ImageModel, aNew: ImageModel): Boolean {
                return old == aNew
            }

            override fun areContentsTheSame(old: ImageModel, aNew: ImageModel): Boolean {
                return old.Image == aNew.Image
            }
        }

    ) {
        override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
            return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.carousel_item,
                parent,
                false
            )
        }

        override fun bind(binding: ViewDataBinding, item: ImageModel) {
            when (binding) {
                is CarouselItemBinding -> {
                Glide.with(binding.imageRecyItem).load(item.Image).into(binding.imageRecyItem)
                }
            }
        }
    }