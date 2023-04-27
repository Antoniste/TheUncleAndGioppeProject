package com.example.theuncleandgioppeproject.di.module

import androidx.compose.runtime.internal.composableLambda
import com.example.theuncleandgioppeproject.BuildConfig
import com.example.theuncleandgioppeproject.core.network.base.network.ApiService
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.API_KEY
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.BASE_URL
import com.example.theuncleandgioppeproject.core.network.base.network.Constants.NETWORK_TIMEOUT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule{

    @Provides
    @Singleton
    fun ProvidesBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun ConnectionTimeOut() = NETWORK_TIMEOUT

    @Provides
    @Singleton
    fun ProvieGson():Gson =GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun ProvideOkHttpClient()= if(BuildConfig.DEBUG){
        val loggingInterceptor =HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val requestInterceptor = Interceptor{ chain ->
            val url =chain.request()
                .url
                .newBuilder()
                .addQueryParameter("API Key", API_KEY)
                .build()

            val request =chain.request()
                .newBuilder()
                .url(url)
                .addHeader("Host","uncleandgioppe.marvel.com")
                .build()
            return@Interceptor chain.proceed(request)
        }
        OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient.Builder().build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl:String,gson:Gson,client:OkHttpClient) :ApiService=Retrofit.Builder().baseUrl(baseUrl)
        .client(client).addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(ApiService::class.java)
}
