package com.example.theuncleandgioppeproject.core.network.base.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/public/series")
    suspend fun getSeriesResponse(
        @Query("ts") ts: String,
        @Query("apikey") key: String,
        @Query("hash") hash: String,
    ): Response<MarvelSeriesResponse>

    @GET("v1/public/characters")
    suspend fun getCharactersResponse(
        @Query("name") name: String,
        @Query("ts") ts: String,
        @Query("apikey") key: String,
        @Query("hash") hash: String,
    ): Response<MarvelCharacterResponse>

}