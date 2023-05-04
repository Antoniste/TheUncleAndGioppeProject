package com.example.theuncleandgioppeproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.theuncleandgioppeproject.adapter.RecyclerViewAdapterHome
import com.example.theuncleandgioppeproject.adapter.RecyclerViewAdapterImage
import com.example.theuncleandgioppeproject.databinding.FragmentHomeBinding
import com.example.theuncleandgioppeproject.model.ImageModel
import com.example.theuncleandgioppeproject.utils.DataBoundListAdapter
import com.example.theuncleandgioppeproject.viewModel.HardViewModel
import com.example.theuncleandgioppeproject.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterRe: RecyclerViewAdapterHome
    private lateinit var adapterImage: RecyclerViewAdapterImage
    private val loginViewModel: LoginViewModel by activityViewModels()
    private val hardViewModel: HardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hardViewModel.getUser()
        adapterRe = RecyclerViewAdapterHome()
        val imageList =ArrayList<ImageModel>()
        imageList.add(ImageModel(R.drawable.ironman_paper_face_masks_01,"iron man"))
        imageList.add(ImageModel(R.drawable.spider_man_face_mask_coloring_book_clip_art_spider_man_mask_cliparts,"hulk"))
        imageList.add(ImageModel(R.drawable._58_1584724_thanos_comic_marvel_freetoedit_thanos_comic_png_transparent,"thanos"))
       /* binding.editSearch.doOnTextChanged { text, _, _, _ ->
            hardViewModel.
        }*/
        adapterImage= RecyclerViewAdapterImage(object : DataBoundListAdapter.onItemClickListener {
            override fun onClick(name: String) {
                hardViewModel.getIronManData(name)
                hardViewModel.event.observe(viewLifecycleOwner) {
                    adapterRe.apply {
                        it?.let {
                            it.forEach {
                                submitList(it)
                            }
                        }
                        notifyDataSetChanged()
                    }
                    binding.recy.apply {
                        adapter = adapterRe
                    }
            }}
        })
        adapterImage.apply {
            submitList(imageList)
        }
        binding.carouselRecyclerview.adapter = adapterImage
        binding.carouselRecyclerview.apply {
            set3DItem(true)
            setAlpha(true)
            setInfinite(false)
        }

       /* binding.ironManMaterialButton.setOnClickListener{
            hardViewModel.getIronManData("iron man")
            hardViewModel.event.observe(viewLifecycleOwner) {
                adapterRe.apply {
                   it?.let {
                       it.forEach {
                           submitList(it)
                       }
                   }
                    notifyDataSetChanged()
                }
                binding.recy.apply {
                    adapter = adapterRe
                }
            }
        }*/
        hardViewModel.userName.observe(viewLifecycleOwner){
            binding.nameHome.text=it
        }
        binding.logout.setOnClickListener{
            loginViewModel.update()
            loginViewModel.logout()
            findNavController().navigate(R.id.nav_graph)
        }

    }

}