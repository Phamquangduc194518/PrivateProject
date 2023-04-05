package com.example.demorecycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class ChattingAdapter : Adapter<ChattingAdapter.Companion.ChattingHolder> {
    private var inter: IChattingAdapter? = null
    private var onClickItemChatting: OnClickItemChatting? = null
    constructor() : super() {

    }

    fun setOnIChatting(inter: IChattingAdapter){
        this.inter = inter
    }
    fun setOnClickItemChatting(inter: OnClickItemChatting){
        this.onClickItemChatting = inter
    }

//    fun setOnClickItemChatting(inter: (Int) -> Boolean){
//        this.onClickItemChatting = inter
//    }

    //tao viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chatting, parent, false)
        return ChattingHolder(itemView)
    }

    //do du lieu len viewholder
    override fun onBindViewHolder(holder: ChattingHolder, position: Int) {
        holder.tvContent.setText(
            this.inter?.getChattingData(position)?.content
        )
        holder.tvUsername.setText(
            this.inter?.getChattingData(position)?.username
        )
        Glide.with(holder.itemView.context)
            .load(this.inter?.getChattingData(position)?.imageLink)
            .placeholder(R.drawable.aodai)
            .error(R.drawable.image_load_failed)
            .into(holder.ivImg)

        holder.itemView.setOnClickListener {
            this.inter?.getChattingData(position)?.isClick = if (this.inter?.getChattingData(position)!!.isClick) false else true
            this.onClickItemChatting?.onClickItemChatting(
                holder.adapterPosition
            )
            notifyItemChanged(position)
        }

        holder.itemView.setOnLongClickListener {
            this.inter?.removeChatting(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }

        if (this.inter?.getChattingData(position)!!.isClick){
            holder.itemView.setBackgroundColor(Color.BLUE)
        }else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

    }

    override fun getItemCount(): Int {
        if (this.inter == null){
            return 0
        }
        return this.inter!!.getSizeChatting()
    }

    interface IChattingAdapter{
        fun getSizeChatting(): Int
        fun getChattingData(position:Int): Chatting
        fun removeChatting(position:Int)
    }

    interface OnClickItemChatting{
        fun onClickItemChatting(position: Int)
    }

    companion object {
        class ChattingHolder : ViewHolder {
            val ivImg: ImageView
            val tvUsername: TextView
            val tvContent: TextView

            constructor(itemView: View) : super(itemView) {
                ivImg = itemView.findViewById(R.id.iv_img)
                tvUsername = itemView.findViewById(R.id.tv_username)
                tvContent = itemView.findViewById(R.id.tv_content)

            }

        }
    }

}