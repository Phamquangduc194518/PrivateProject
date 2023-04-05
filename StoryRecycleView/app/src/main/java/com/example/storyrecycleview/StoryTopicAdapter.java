package com.example.storyrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryTopicAdapter extends RecyclerView.Adapter<StoryTopicAdapter.StoryTopicViewHolder> {

    private Context mcontext;
    private List<StoresTopic> mlist;
    public StoryTopicAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setdata(List<StoresTopic> list) {
        this.mlist = list;
    }

    @NonNull
    @Override
    public StoryTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new StoryTopicViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull StoryTopicViewHolder holder, int position) {
        StoresTopic storesTopic = mlist.get(position);
        holder.title.setText(storesTopic.getTitle());
        holder.content.setText(storesTopic.getContent());
    }
    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }
    public class StoryTopicViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;
        public StoryTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }
    }
}
