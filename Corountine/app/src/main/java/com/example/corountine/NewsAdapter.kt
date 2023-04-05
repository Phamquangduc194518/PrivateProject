package com.example.corountine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private var mlist: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tittle : TextView
        val subTitle: TextView
        val image: ImageView

        init {
            tittle=itemView.findViewById(R.id.tv_title)
            subTitle=itemView.findViewById(R.id.tv_subtitle)
            image=itemView.findViewById(R.id.tv_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item24h,parent,false);
        return NewsViewHolder(view);
    }

    override fun getItemCount(): Int {
        if(mlist!= null){
            return  mlist.size;
        }
        return 0;
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=mlist.get(position)
        holder.tittle.text= news.title
        holder.subTitle.text= news.subTitle
        Glide.with(holder.image.context)
            .load(news.imageInternet)
            .into(holder.image)
    }
}