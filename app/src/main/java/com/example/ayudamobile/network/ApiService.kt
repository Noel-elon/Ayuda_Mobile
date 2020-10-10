package com.example.ayudamobile.network

import com.example.ayudamobile.models.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/user/register")
    fun registerUser(@Body userModel: UserModel): Call<AuthResponse>

    @POST("api/user/login")
    fun loginUser(email: String, password: String): Call<AuthResponse>

    @GET("api/user/me")
    fun getCurrentUser(@Header("Authorization") token: String): Call<UserResponse>

    @Headers("Content-Type: application/json")
    @POST("api/user/extend-session")
    @FormUrlEncoded
    fun extendUserSession(@Field("refreshToken") refreshToken: String): Call<AuthResponse>

    @POST("api/topics")
    @FormUrlEncoded
    fun createTopic(
        @Header("Authorization") token: String,
        @Field("title") title: String,
        @Field("subject") subject: String
    ): Call<TopicResponse>

    @GET("api/topics")
    fun getAllTopics(@Header("Authorization") token: String): Call<TopicResponse>

    @POST("api/subjects")
    @FormUrlEncoded
    fun createSubject(
        @Header("Authorization") token: String,
        @Field("title") title: String
    ): Call<Subject>

    @GET("api/subjects")
    fun getAllSubjects(@Header("Authorization") token: String): Call<SubjectResponse>

    @POST("api/questions")
    @FormUrlEncoded
    fun createQuestion(
        @Header("Authorization") token: String,
        @Field("title") title: String,
        @Field("text") text: String,
        @Field("topic") topic: String,
        @Field("subject") subject: String
    ): Call<Question>

    @GET("api/questions")
    fun getQuestions(@Header("Authorization") token: String): Call<Question>

    @POST("api/answers")
    @FormUrlEncoded
    fun answerQuestion(
        @Header("Authorization") token: String,
        @Field("text") text: String,
        @Field("question") question: String,
        @Field("answerBeingRepliedTo") answerBeingRepliedTo: String
    ): Call<Void>

    @GET("api/user")
    fun getAllUsers(@Header("Authorization") token: String): Call<AllUsersResponse>

    @GET("api/answers/{id}")
    fun getAnswersByID(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<Void>


}