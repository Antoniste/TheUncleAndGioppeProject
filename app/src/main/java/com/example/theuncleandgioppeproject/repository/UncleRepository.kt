package com.example.theuncleandgioppeproject.repository


import com.example.theuncleandgioppeproject.core.network.base.network.ApiService
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.API_KEY
import com.example.theuncleandgioppeproject.core.network.base.network.MarvelCharacterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UncleRepository @Inject constructor(private val apiService: ApiService){

    fun getMarvelMovies(): Flow<MarvelCharacterResponse> = flow {
        val siteResponse = apiService.getResponse()
        siteResponse.body()?.let { emit(it) }
    }

}


