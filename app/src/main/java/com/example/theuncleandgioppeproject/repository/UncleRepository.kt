package com.example.theuncleandgioppeproject.repository


import com.example.theuncleandgioppeproject.core.network.base.network.ApiService
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.API_KEY
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.HASH
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.TS
import com.example.theuncleandgioppeproject.core.network.base.network.MarvelCharacterResponse
import com.example.theuncleandgioppeproject.core.network.base.network.MarvelSeriesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UncleRepository @Inject constructor(private val apiService: ApiService){


    fun getMarvelMovies(): Flow<MarvelSeriesResponse> = flow {
        val siteResponse = apiService.getSeriesResponse(TS, API_KEY, HASH)
        siteResponse.body()?.let { emit(it) }
    }
        fun getMarvelCharacters(name: String): Flow<MarvelCharacterResponse> = flow {
            val siteResponse = apiService.getCharactersResponse(name,TS, API_KEY, HASH)
            siteResponse.body()?.let { emit(it) }


    }



}


