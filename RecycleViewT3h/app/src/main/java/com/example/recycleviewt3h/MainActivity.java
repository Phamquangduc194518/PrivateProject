package com.example.recycleviewt3h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvChat;
    private List<Chating> list;
    private ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvChat = findViewById(R.id.rcv_data);
        chatAdapter= new ChatAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvChat.setLayoutManager(linearLayoutManager);
        chatAdapter.setData(getdata());
        rcvChat.setAdapter(chatAdapter);
    }

    private List<Chating> getdata(){
        list = new ArrayList<>();
        list.add(new Chating(R.drawable.ns1,"User_name1"));
        list.add(new Chating(R.drawable.ns2,"User_name2"));
        list.add(new Chating(R.drawable.ns3,"User_name3"));
        list.add(new Chating(R.drawable.ns4,"User_name4"));
        list.add(new Chating(R.drawable.ns5,"User_name5"));
        list.add(new Chating(R.drawable.ns1,"User_name6"));
        list.add(new Chating(R.drawable.ns2,"User_name8"));
        list.add(new Chating(R.drawable.ns3,"User_name7"));
        list.add(new Chating(R.drawable.ns4,"User_name9"));
        list.add(new Chating(R.drawable.ns5,"User_name10"));
        list.add(new Chating(R.drawable.ns1,"User_name11"));
        list.add(new Chating(R.drawable.ns5,"User_name12"));
        list.add(new Chating(R.drawable.ns1,"User_name13"));
        list.add(new Chating(R.drawable.ns2,"User_name14"));
        list.add(new Chating(R.drawable.ns3,"User_name15"));
        list.add(new Chating(R.drawable.ns4,"User_name16"));
        list.add(new Chating(R.drawable.ns5,"User_name17"));
        list.add(new Chating(R.drawable.ns1,"User_name18"));

        return list;
    }
}