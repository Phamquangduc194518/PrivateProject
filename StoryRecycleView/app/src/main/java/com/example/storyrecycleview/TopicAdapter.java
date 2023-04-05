package com.example.storyrecycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private Context mcontext;
    private List<Topic> mlist;

    public TopicAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void setdata(List<Topic> list){
        this.mlist=list;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic,parent,false);
        return new TopicViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        Topic toPic = mlist.get(position);
        holder.topic.setText(toPic.getTopic());
        holder.topic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(holder.topic.getContext(),StoresTopicActivity.class);
        intent.putExtra("KEY",position);
        intent.putExtra("KEY2",holder.topic.toString());
        holder.topic.getContext().startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        if(mlist!= null){
            return mlist.size();
        }return 0;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        private TextView topic;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.tv_topic);
        }
    }
}
