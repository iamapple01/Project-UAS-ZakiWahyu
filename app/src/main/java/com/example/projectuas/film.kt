package com.example.projectuas

data class Film(
    val id: Int,
    val title: String,
    val description: String,
    val year: Int,
    val genre: List<String>
)

