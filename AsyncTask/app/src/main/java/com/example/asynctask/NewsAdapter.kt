package com.example.asynctask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private var mlist: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val subTitle: TextView
        val image: ImageView

        init {
            title = itemView.findViewById(R.id.tv_title)
            subTitle = itemView.findViewById(R.id.tv_subtitle)
            image = itemView.findViewById(R.id.tv_img)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun UpdateData(list: ArrayList<News>) {
        this.mlist = list;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item24h, parent, false);
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mlist != null) {
            return mlist.size
        }
        return 0
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = mlist[position]
        holder.title.text = news.title;
        holder.subTitle.text = news.subTitle
        Glide.with(holder.itemView.context)
            .load(news.imageInternet)
            .into(holder.image)
    }

}