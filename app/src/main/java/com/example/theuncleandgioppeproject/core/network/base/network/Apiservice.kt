package com.example.theuncleandgioppeproject.core.network.base.network

import com.example.theuncleandgioppeproject.core.network.base.network.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/public/series")
    suspend fun getResponse(@Query("ts") ts: String,@Query("apikey") key:String,@Query("hash") hash:String): Response<MarvelCharacterResponse>


}