package com.example.theuncleandgioppeproject.core.network.base.viewModel

import com.example.theuncleandgioppeproject.core.network.base.network.PornVideo
import com.example.theuncleandgioppeproject.core.network.base.network.UncleRetrofit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VideoRepository {
    private val retrofitInstance = UncleRetrofit().getRetrofitInstance()
    fun getPornVideo(): Flow<PornVideo> = flow {
        val siteResponse = retrofitInstance.getResponse()
        siteResponse.body()?.let { emit(it) }
    }
}

