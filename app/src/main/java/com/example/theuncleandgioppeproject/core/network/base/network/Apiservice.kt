package com.example.theuncleandgioppeproject.core.network.base.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/public/series?ts=1682584667000&apikey=781fb826b12d89b527431ec48e0fce42&hash=0cbafdcbe4eb6e309f365f74f7c34bdc")
    suspend fun getResponse(
    ): Response<MarvelCharacterResponse>
}