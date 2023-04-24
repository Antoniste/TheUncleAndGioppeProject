package com.example.theuncleandgioppeproject.core.network.base


class UncleRepository {
}

import com.example.theuncleandgioppeproject.core.network.base.network.PornVideo
import com.example.theuncleandgioppeproject.core.network.base.network.UncleRetrofit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UncleRepository {
    private val retrofitInstance = UncleRetrofit().getRetrofitInstance()

    fun getPornVideo(): Flow<PornVideo> = flow {
        val siteResponse = retrofitInstance.getResponse()
        siteResponse.body()?.let { emit(it) }
    }
}


