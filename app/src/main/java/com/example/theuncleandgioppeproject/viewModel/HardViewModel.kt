package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.repository.UncleRepository
import com.example.theuncleandgioppeproject.db.UserPorn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HardViewModel @Inject constructor(private var repository: UncleRepository) : ViewModel() {

    val events: LiveData<List<ViewModelCardHome>>
        get() {
            return repository.getPornVideo().asLiveData().map { response ->
                response.content.map {
                    ViewModelCardHome(it.sourceUrl, it.name, it.description)
                }
            }
        }

    fun getData() {
        viewModelScope.launch {
            repository.getPornVideo()
        }
    }
}