package com.example.theuncleandgioppeproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.theuncleandgioppeproject.adapter.RecyclerViewAdapterHome
import com.example.theuncleandgioppeproject.databinding.FragmentHomeBinding
import com.example.theuncleandgioppeproject.viewModel.HardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterRe: RecyclerViewAdapterHome
    private val hardViewModel: HardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hardViewModel.getData()
        adapterRe = RecyclerViewAdapterHome()



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