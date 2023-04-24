package com.example.theuncleandgioppeproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.theuncleandgioppeproject.databinding.VideosFragmentBinding
import com.example.theuncleandgioppeproject.viewModel.VideoViewModel

class VideoListFragment: Fragment() {
    lateinit var binding: VideosFragmentBinding
    lateinit var viewModel: VideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = VideosFragmentBinding.inflate(layoutInflater)
        viewModel = VideoViewModel()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        viewModel.getVideoListFlow.observe(viewLifecycleOwner){
            if (it.isNotEmpty()){
                val adapter = RecyclerViewAdapter(this)
                adapter.submitList(it)
                binding.myRecyclerView.adapter = adapter
            }
        }
    }
}