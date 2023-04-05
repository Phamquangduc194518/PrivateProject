package com.example.recycleviewt3h;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chating> mlist;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Chating> list) {
        this.mlist = list;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Chating chat = mlist.get(position);
        holder.image.setImageResource(chat.getImg());
        holder.name.setText(chat.getName());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.name.setBackgroundColor(Color.parseColor("#FFDEB9"));
            }
        });

        holder.name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mlist.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mlist.size());
                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }
    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_img);
            name = itemView.findViewById(R.id.tv_name);
        }
    }
}
