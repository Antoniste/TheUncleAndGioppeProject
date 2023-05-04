package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.repository.UncleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HardViewModel @Inject constructor(private var repository: UncleRepository) : ViewModel() {

    private val _event = MutableLiveData<List<List<ViewModelCardHome>>>()
    var event : LiveData<List<List<ViewModelCardHome>>> = _event


    /*    fun getSearch( s: String){
        viewModelScope.launch {
            val r=repository.getMarvelMovies().asLiveData().map {  response->
                response.data.results.map {
                    ViewModelCardHome(it.title)
                }
            }
            events= r as MutableLiveData<List<ViewModelCardHome>>
       }
    } */
    /*fun getData() {
        viewModelScope.launch {
            val r=repository.getMarvelMovies().asLiveData().map {  response->
                response.data.results.map {
                    ViewModelCardHome(it.title)
                }
            }

        }
    }*/
    fun getIronManData(c: String) {
        viewModelScope.launch {
            event = repository.getMarvelCharacters(c).asLiveData().map { response ->
                response.data.results.map { result ->
                    result.series.items.map { item ->
                        ViewModelCardHome(item.name)
                    }
                }
            }
        }
    }
}