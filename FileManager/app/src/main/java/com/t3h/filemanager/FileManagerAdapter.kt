package com.t3h.filemanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class FileManagerAdapter : Adapter<FileManagerAdapter.FileManagerViewHolder>{
    private val inter: IFileManagerAdapter
    constructor(inter: IFileManagerAdapter){
        this.inter = inter
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileManagerViewHolder {
       return FileManagerViewHolder(
           LayoutInflater.from(parent.context)
               .inflate(R.layout.item_file, parent, false)
       )
    }

    override fun onBindViewHolder(holder: FileManagerViewHolder, position: Int) {
        holder.tvName.setText(inter.getData(position).name)
        holder.tvPath.setText(inter.getData(position).path)
        Glide.with(holder.itemView.context)
            .load(inter.getData(position).imageId)
            .into(holder.img)
        holder.itemView.setOnClickListener {
            inter.onClickItem(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
       return inter.getSize()
    }

    interface IFileManagerAdapter {
        fun onClickItem(position: Int)
        fun getSize(): Int
        fun getData(position: Int): ItemFile
    }

    class FileManagerViewHolder : ViewHolder {
        val img: ImageView
        val tvName: TextView
        val tvPath: TextView

        constructor(itemView: View) : super(itemView) {
            img = itemView.findViewById(R.id.iv_img)
            tvName = itemView.findViewById(R.id.tv_name)
            tvPath = itemView.findViewById(R.id.tv_path)
        }
    }
}