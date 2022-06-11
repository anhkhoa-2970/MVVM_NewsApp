package com.example.mvvm_newsapp.repository

import com.example.mvvm_newsapp.api.RetrofitInstance
import com.example.mvvm_newsapp.db.ArticleDatabase

class NewsRepository(
    var db : ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode : String, pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}