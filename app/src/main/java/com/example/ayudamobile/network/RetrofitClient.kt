package com.example.ayudamobile.network

import com.example.ayudamobile.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


    fun createApiService(): ApiService {

        val myInterceptor = HttpLoggingInterceptor()
        myInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(myInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}