package com.practice.newsapp.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.practice.newsapp.adapter.NewsAdapter
import com.practice.newsapp.databinding.ActivityMainBinding
import com.practice.newsapp.models.NewsArticle
import com.practice.newsapp.viewModel.NewsModel

class MainActivity : AppCompatActivity() {
    private var newsListAdapter = NewsAdapter()
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewsModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NewsModel::class.java]
        binding.newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter

        }
        bindObserver()
    }

    private fun bindObserver() {
        viewModel.countries.observe(this, Observer { article ->
            binding.listError.visibility = View.GONE
            binding.loadingView.visibility = View.GONE
            binding.newsList.visibility = View.VISIBLE
            newsListAdapter.onAddNewsItem(article)
            binding.newsList.smoothScrollToPosition(0)
        })
    }
}