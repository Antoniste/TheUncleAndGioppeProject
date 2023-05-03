package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.MyApp
import com.example.theuncleandgioppeproject.repository.UncleRepository
import com.example.theuncleandgioppeproject.utils.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HardViewModel @Inject constructor(private var repository: UncleRepository) : ViewModel() {
    val preferencesManager:PreferencesManager
        get() = MyApp.INSTANCE.preferencesManager
    var events=MutableLiveData<List<ViewModelCardHome>>()
    var userName=MutableLiveData<String>()
    fun getUser(){
        userName.value=preferencesManager.userName
    }
    fun getData() {
        viewModelScope.launch {
            val r=repository.getMarvelMovies().asLiveData().map {  response->
                response.data.results.map {
                    ViewModelCardHome(it.title)
                }
            }
            events= r as MutableLiveData<List<ViewModelCardHome>>
        }
    }
}