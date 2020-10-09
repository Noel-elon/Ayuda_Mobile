package com.example.ayudamobile

import android.util.Log
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayudamobile.models.AuthResponse
import com.example.ayudamobile.models.UserModel
import com.example.ayudamobile.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel : ViewModel() {


    fun registerUser(userModel: UserModel) {
        viewModelScope.launch(Dispatchers.Default) {
            val response = RetrofitClient.createApiService().registerUser(userModel = userModel)
            response.enqueue(object : Callback<AuthResponse>{
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {

                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {

                }


            })
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.Default) {
            val response =
                RetrofitClient.createApiService().loginUser(email = email, password = password)
            response.enqueue(object : Callback<AuthResponse>{
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    if (response.isSuccessful){

                    }else{

                    }

                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {

                }


            })
        }
    }
}