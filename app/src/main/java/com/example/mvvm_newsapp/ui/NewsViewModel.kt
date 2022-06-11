package com.example.mvvm_newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_newsapp.models.NewsResponce
import com.example.mvvm_newsapp.repository.NewsRepository
import com.example.mvvm_newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository : NewsRepository
) : ViewModel() {
    val breakingNews : MutableLiveData<Resource<NewsResponce>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode : String)= viewModelScope.launch{
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(responce: Response<NewsResponce>) : Resource<NewsResponce>{
        if (responce.isSuccessful){
            responce.body()?.let{resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(responce.message())
    }

}