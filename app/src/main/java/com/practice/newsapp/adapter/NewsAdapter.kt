package com.practice.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.newsapp.R
import com.practice.newsapp.activities.MainActivity
import com.practice.newsapp.adapter.NewsAdapter.ViewHolder
import com.practice.newsapp.databinding.ItemNewsArticleBinding
import com.practice.newsapp.models.NewsArticle

class NewsAdapter() :
    RecyclerView.Adapter<ViewHolder>() {
    private val newsItems = arrayListOf<NewsArticle>()
    private lateinit var binding: ItemNewsArticleBinding

    inner class ViewHolder(binding: ItemNewsArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsArticle: NewsArticle) {
            binding.newsAuthor.text = newsArticle.author
            binding.newsTitle.text = newsArticle.title
            binding.newsPublishedAt.text = newsArticle.publishedAt

            Glide
                .with(binding.root.context)
                .load(newsArticle.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    fun onAddNewsItem(article: NewsArticle) {
        newsItems.add(0, article)
        notifyItemInserted(0)
    }
}
