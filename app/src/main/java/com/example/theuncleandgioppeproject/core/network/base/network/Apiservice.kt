package com.example.theuncleandgioppeproject.core.network.base.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/public/characters")
    suspend fun getResponse(
    ): Response<MarvelCharacterResponse>
}