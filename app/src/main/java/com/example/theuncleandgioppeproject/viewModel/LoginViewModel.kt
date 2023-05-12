package com.example.theuncleandgioppeproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theuncleandgioppeproject.MyApp
import com.example.theuncleandgioppeproject.db.UserPorn
import com.example.theuncleandgioppeproject.repository.PornRepository
import com.example.theuncleandgioppeproject.utils.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor( var repository: PornRepository) : ViewModel() {

    val preferencesManager: PreferencesManager
        get() = MyApp.INSTANCE.preferencesManager
    var logShare=MutableLiveData<Boolean>()
    var nameShare=MutableLiveData<String>()

    var userLive = MutableLiveData<UserPorn?>()
     fun select(email: String, password: String) {
         viewModelScope.launch {
        userLive.value = repository.select(email, password)
        }
     }
    fun changeCredential(boolean: Boolean){
            preferencesManager.credentialUser=boolean
    }
        fun update(){
            preferencesManager.userPassword=userLive.value?.password
            preferencesManager.userEmail= userLive.value?.email
            preferencesManager.userName= userLive.value?.name
            preferencesManager.isUserLogged=true
            nameShare.value=preferencesManager.userName
            logShare.value=preferencesManager.isUserLogged
        }
    fun biometric(){
        viewModelScope.launch {
            userLive.value = repository.selectFirst()
            preferencesManager.isUserLogged = false
            preferencesManager.userPassword = userLive.value?.password
            preferencesManager.userEmail = userLive.value?.email
            preferencesManager.userName = userLive.value?.name
            nameShare.value = preferencesManager.userName
            logShare.value = preferencesManager.isUserLogged
        }
    }
    fun logout(){

        userLive.value=null
        preferencesManager.isUserLogged=false
        logShare.value=preferencesManager.isUserLogged
        preferencesManager.userName=""
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


