package com.example.ayudamobile.network

import com.example.ayudamobile.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val okHttpClient = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .build()

    fun createApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}