package com.example.mvvm_newsapp.ui

import androidx.lifecycle.ViewModel
import com.example.mvvm_newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRespository : NewsRepository
) : ViewModel() {
}