package com.example.theuncleandgioppeproject.core.network.base.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/porn/")
    suspend fun getResponse(
    ): Response<PornVideo>
}