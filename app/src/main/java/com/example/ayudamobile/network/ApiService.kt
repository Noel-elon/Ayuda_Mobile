package com.example.ayudamobile.network

import com.example.ayudamobile.models.UserModel
import retrofit2.Call
import retrofit2.http.POST

interface ApiService {
    @POST("api/user/register")
    fun registerUser(userModel: UserModel): Call<Void>

    @POST("api/user/login")
    fun loginUser(email: String, password: String): Call<Void>


}