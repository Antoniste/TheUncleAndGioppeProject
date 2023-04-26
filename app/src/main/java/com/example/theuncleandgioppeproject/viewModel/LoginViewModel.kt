package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.db.UserPorn
import com.example.theuncleandgioppeproject.repository.PornRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor( var repository: PornRepository) : ViewModel() {

    var userLive = MutableLiveData<UserPorn>()
    suspend fun select(email: String, password: String) {
        userLive.value = repository.select(email, password)
    }
    fun insertUser(user: UserPorn)=
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }
}



  /*  fun login(username: String, password: String) {
        viewModelScope.launch {

        }
    }
*/
   /* fun logout() {
        viewModelScope.launch {
            launchCall(loginRepository.logout()) {}
        }
    }*/


