package com.practice.newsapp.repository

import com.practice.newsapp.api.NewsService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class NewsRepository {

    fun getNewsArticle() = flow {
        val newsSource = NewsService.retrofitBuilder.getNews()
        delay(NewsService.DELAY)
        newsSource.forEach {
            emit(it)
        }
    }
}