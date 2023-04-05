package com.example.storyrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_topic;
    private TopicAdapter topicAdapter;
    private List<Topic> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_topic= findViewById(R.id.rcv_topic);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        topicAdapter = new TopicAdapter(this);
        rcv_topic.setLayoutManager(linearLayoutManager);
        topicAdapter.setdata(getTopList());
        rcv_topic.setAdapter(topicAdapter);


    }

    private List<Topic> getTopList() {
        list = new ArrayList<>();
        list.add(new Topic("Truyện cười"));
        list.add(new Topic("Truyện ngắn"));
        list.add(new Topic("Truyện kinh dị"));
        list.add(new Topic("Truyện tình cảm"));
        list.add(new Topic("Truyện viễn tưởng"));
        list.add(new Topic("Truyện lịch sử"));
        list.add(new Topic("Truyện phưu lưu"));
        list.add(new Topic("Truyện hài"));
        list.add(new Topic("Truyện tranh"));
        list.add(new Topic("Truyện tâm lý "));
        list.add(new Topic("Truyện cổ tích"));
        list.add(new Topic("Truyện hồi ký"));
        list.add(new Topic("Truyện hư cấu"));
        list.add(new Topic("Truyện tình huống"));
        list.add(new Topic("Truyện trinh thám"));

        return list;
    }
}