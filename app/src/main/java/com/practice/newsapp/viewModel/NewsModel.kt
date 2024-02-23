package com.practice.newsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.practice.newsapp.repository.NewsRepository

class NewsModel : ViewModel() {
    val countries = NewsRepository().getNewsArticle().asLiveData()
}