package com.example.ayudamobile.models

class TopicResponse : ArrayList<TopicResponseItem>()

data class TopicResponseItem(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val questions: List<Question>,
    val subject: Subject,
    val title: String
)

data class Question(
    val __v: Int,
    val _id: String,
    val answers: List<Any>,
    val createdAt: String,
    val subject: String,
    val tags: List<String>,
    val text: String,
    val title: String,
    val topic: String,
    val user: String
)

data class Subject(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val questions: List<String>,
    val title: String,
    val topics: List<String>
)

class SubjectResponse : ArrayList<Subject>()

