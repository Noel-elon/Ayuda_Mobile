package com.example.ayudamobile.network

import com.example.ayudamobile.models.AuthResponse
import com.example.ayudamobile.models.UserModel
import com.example.ayudamobile.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/user/register")
    fun registerUser(@Body userModel: UserModel): Call<AuthResponse>

    @POST("api/user/login")
    fun loginUser(email: String, password: String): Call<AuthResponse>

    @GET("api/user/me")
    fun getCurrentUser(@Header("Authorization") token: String): Call<UserResponse>


}