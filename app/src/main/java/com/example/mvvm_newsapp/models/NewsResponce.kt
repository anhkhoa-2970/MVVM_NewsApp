package com.example.mvvm_newsapp.models

import com.example.mvvm_newsapp.models.Article

data class NewsResponce(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)