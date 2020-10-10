package com.example.ayudamobile

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.inspector.ParameterType
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.ayudamobile.models.AuthResponse
import com.example.ayudamobile.network.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val sessionManager = SessionManager(context = context)

    override fun doWork(): Result {
        refreshToken()
        return Result.success()
    }

    private fun refreshToken() {
        val refToken = sessionManager.fetchRefreshToken()
        val response = RetrofitClient.createApiService().extendUserSession("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Il9pZCI6IjVmN2NjZDFjOWM5NjgyMTM1OGJiNmIwOCIsImZpcnN0TmFtZSI6InRlc3QiLCJsYXN0TmFtZSI6InRlc3QxIiwiZW1haWwiOiJ0ZXN0M0B0ZXN0Lm5ldCIsImNvdW50cnkiOiJqYW1haWNhIiwic2Nob29sIjoic2Nob29sIiwiZmllbGQiOiJ0ZWNobm9sb2d5IiwicGFzc3dvcmQiOm51bGwsImNyZWF0ZWRBdCI6IjIwMjAtMTAtMDZUMjA6MDE6MzIuMjY3WiIsIl9fdiI6MH0sImlhdCI6MTYwMjAzMDA1MywiZXhwIjoxNjAzMjM5NjUzfQ.cgbhKwi-NJOG8GbWxgxAU8DGUhbzw3kz4XOOIFCb2G8")
        response.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    sessionManager.saveAuthToken(response.body()?.accessToken!!)
                    sessionManager.saveRefreshToken(response.body()?.refreshToken!!)
                    Log.d("Refresh successful: ", "${response.code()} ${response.message()}")

                } else {
                    Log.d(
                        "Refresh Unsuccessful: ",
                        "${response.code()} ${response.errorBody()?.string()}"
                    )
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("Failure: ", t.message!!)
            }


        })


    }
}