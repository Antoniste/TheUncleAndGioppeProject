package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.repository.UncleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HardViewModel @Inject constructor(private var repository: UncleRepository) : ViewModel() {

    val events: LiveData<List<ViewModelCardHome>>
        get() {
            return repository.getMarvelMovies().asLiveData().map { response ->
                response.data.results.map {
                    ViewModelCardHome(it.name,it.description,it.urls)
                }
            }
        }

    fun getData() {
        viewModelScope.launch {
            repository.getMarvelMovies()
        }
    }
}