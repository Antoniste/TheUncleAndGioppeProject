package com.example.theuncleandgioppeproject.core.network.base.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class UncleRetrofit {

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client: OkHttpClient =
        OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor)
            .addInterceptor(AuthInterceptor()).build()
    private lateinit var apiService: ApiService
    private val BASE_URL =
        "https://steppschuh-json-porn-v1.p.rapidapi.com/"
    fun getRetrofitInstance(): ApiService {
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory((GsonConverterFactory.create((GsonBuilder().create()))))
                .client(client).build()
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService
    }
}


class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(
        chain.request().newBuilder().addHeader("X-RapidAPI-Key", Constants.API_KEY)
            .addHeader("X-RapidAPI-Host","steppschuh-json-porn-v1.p.rapidapi.com").build()
    )

}