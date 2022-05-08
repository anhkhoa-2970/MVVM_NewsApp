package com.example.mvvm_newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_newsapp.models.Article

interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long
    @Query("SELECT * from acticles")
    fun getArticles():LiveData<List<Article>>
    @Delete
    suspend fun deleteArticle(article: Article)
}