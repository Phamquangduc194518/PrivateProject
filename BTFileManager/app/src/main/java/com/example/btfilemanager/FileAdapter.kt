package com.example.btfilemanager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileAdapter {
    class FileViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val path: TextView
        val name: TextView
        val image: ImageView

        init {

        }

    }
}