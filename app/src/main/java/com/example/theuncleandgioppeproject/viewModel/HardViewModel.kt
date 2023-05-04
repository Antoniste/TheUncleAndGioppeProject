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
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HardViewModel @Inject constructor(private var repository: UncleRepository) : ViewModel() {

    private val _event = MutableLiveData<List<List<ViewModelCardHome>>>()
    var event : LiveData<List<List<ViewModelCardHome>>> = _event
    val preferencesManager: PreferencesManager
        get() = MyApp.INSTANCE.preferencesManager
    var userName=MutableLiveData<String>()
    fun getUser(){
        userName.value=preferencesManager.userName
    }

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