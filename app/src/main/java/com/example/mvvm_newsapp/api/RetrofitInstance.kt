package com.example.mvvm_newsapp.api

import com.example.mvvm_newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.internal.http2.Http2
import okhttp3.logging.HttpLoggingInterceptor
import okio.Okio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val api by lazy {
            retrofit.create(com.example.mvvm_newsapp.api.NewsAPI::class.java)
        }
    }
}