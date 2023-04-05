package com.example.asynctask

import XmlDownloader
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcv_data: RecyclerView;
    private lateinit var newsAdapter: NewsAdapter;
    private val list = ArrayList<News>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcv_data = findViewById(R.id.rcv_data)
        newsAdapter = NewsAdapter(list)
        rcv_data.adapter = newsAdapter
        rcv_data.layoutManager = LinearLayoutManager(this)
        val url = "https://cdn.24h.com.vn/upload/rss/tintuctrongngay.rss"
        XmlDownloader(newsAdapter).execute(url)
    }
}