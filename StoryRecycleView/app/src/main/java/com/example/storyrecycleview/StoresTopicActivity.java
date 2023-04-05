package com.example.storyrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StoresTopicActivity extends AppCompatActivity {

    private RecyclerView rcv_story_topic;
    private StoryTopicAdapter topicAdapter;
    private List<StoresTopic> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_topic);

        rcv_story_topic=findViewById(R.id.rcv_story_topic);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_story_topic.setLayoutManager(linearLayoutManager);
        topicAdapter = new StoryTopicAdapter(this);
        topicAdapter.setdata(getdata());
        rcv_story_topic.setAdapter(topicAdapter);
    }

    private List<StoresTopic> getdata() {
        list = new ArrayList<>();
        list.add(new StoresTopic("cbjshcbs","bckckdscdjs"));
        list.add(new StoresTopic("hjchjads","bckckdscdjs"));
        list.add(new StoresTopic("cb]kxjk sjshcbs","bckckdscdjs"));
        list.add(new StoresTopic("cbjshcbs","bckckdscdjs"));
        list.add(new StoresTopic("cbjshcbs","bckckdscdjs"));
        list.add(new StoresTopic("cbjshcbs","bckckdscdjs"));
        list.add(new StoresTopic("cbjshcbs","bckckdscdjs"));
        return list;
    }
}