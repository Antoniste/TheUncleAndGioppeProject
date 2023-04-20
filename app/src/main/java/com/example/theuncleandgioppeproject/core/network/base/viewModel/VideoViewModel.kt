package com.example.theuncleandgioppeproject.core.network.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map

class VideoViewModel: ViewModel() {
    private val repository = VideoRepository()
    val getVideoListFlow: LiveData<List<ItemViewModel>>
    get(){
        return repository.getPornVideo().asLiveData().map {
           pornVideo -> pornVideo.content.map {
               ItemViewModel(it.name,it.description,it.sourceUrl)
        }
        }
            }
        }