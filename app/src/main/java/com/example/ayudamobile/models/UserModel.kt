package com.example.ayudamobile.models

data class UserModel(
    val firstName: String,
    val lastName: String,
    val email: String,
    val school: String,
    val field: String,
    val country: String,
    val password: String


)data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val user: UserResponse
)

data class UserResponse(
    val __v: Int,
    val _id: String,
    val answers: List<Any>,
    val country: String,
    val createdAt: String,
    val email: String,
    val field: String,
    val firstName: String,
    val lastName: String,
    val password: Any,
    val questions: List<Any>,
    val school: String
)