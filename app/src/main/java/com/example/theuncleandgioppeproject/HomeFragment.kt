package com.example.theuncleandgioppeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.theuncleandgioppeproject.adapter.RecyclerViewAdapterHome
import com.example.theuncleandgioppeproject.databinding.FragmentHomeBinding
import com.example.theuncleandgioppeproject.viewModel.HardViewModel
import com.example.theuncleandgioppeproject.viewModel.ViewModelCardHome

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var adapterRe: RecyclerViewAdapterHome
    private val hardViewModel: HardViewModel by activityViewModels()
    var places = ArrayList<ViewModelCardHome>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterRe= RecyclerViewAdapterHome()


        hardViewModel.getData()
           hardViewModel.events.observe(viewLifecycleOwner) {
            adapterRe.apply {
                submitList(it)
                notifyDataSetChanged()
            }

            binding.recy.apply {
                adapter = adapterRe
            }
        }

    }

}
