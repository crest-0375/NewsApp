package com.practice.newsapp.api

import com.practice.newsapp.models.NewsArticle
import retrofit2.Response
import retrofit2.http.GET

interface NewsInterface {

    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}