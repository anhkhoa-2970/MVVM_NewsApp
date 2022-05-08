package com.example.mvvm_newsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "acticles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var ID :Int? =  null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)