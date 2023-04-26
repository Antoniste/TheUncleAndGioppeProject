package com.example.theuncleandgioppeproject.repository


import com.example.theuncleandgioppeproject.core.network.base.network.ApiService
import com.example.theuncleandgioppeproject.core.network.base.network.PornVideo
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UncleRepository @Inject constructor(private val apiService: ApiService){

    fun getPornVideo(): Flow<PornVideo> = flow {
        val siteResponse = apiService.getResponse()
        siteResponse.body()?.let { emit(it) }
    }

}


