package com.practice.newsapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private const val BASE_URL = "https://raw.githubusercontent.com/DevTides/NewsApi/master/"
    const val DELAY = 2000L

    val retrofitBuilder: NewsInterface = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(NewsInterface::class.java)

}