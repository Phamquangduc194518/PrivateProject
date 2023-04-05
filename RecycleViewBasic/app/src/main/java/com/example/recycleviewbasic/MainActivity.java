package com.example.recycleviewbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private BookAdapter bookAdapter1;

    private RecyclerView rcvCate;
//    private CategoryAdapter categoryAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCate=findViewById(R.id.rcv_cate);


        rcv= findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcv.setLayoutManager(linearLayoutManager);
        bookAdapter1= new BookAdapter(this);
        bookAdapter1.setData(getList());
        rcv.setAdapter(bookAdapter1);

    }

    public List<Book> getList() {
        List<Book> list = new ArrayList<>();
        list.add(new Book(R.drawable.ns1,"User_name1"));
        list.add(new Book(R.drawable.ns2,"User_name2"));
        list.add(new Book(R.drawable.ns3,"User_name3"));
        list.add(new Book(R.drawable.ns4,"User_name4"));
        list.add(new Book(R.drawable.ns5,"User_name5"));
        list.add(new Book(R.drawable.ns1,"User_name6"));
        list.add(new Book(R.drawable.ns2,"User_name8"));
        list.add(new Book(R.drawable.ns3,"User_name7"));
        list.add(new Book(R.drawable.ns4,"User_name9"));
        list.add(new Book(R.drawable.ns5,"User_name10"));
        list.add(new Book(R.drawable.ns1,"User_name11"));
        list.add(new Book(R.drawable.ns5,"User_name12"));
        list.add(new Book(R.drawable.ns1,"User_name13"));
        list.add(new Book(R.drawable.ns2,"User_name14"));
        list.add(new Book(R.drawable.ns3,"User_name15"));
        list.add(new Book(R.drawable.ns4,"User_name16"));
        list.add(new Book(R.drawable.ns5,"User_name17"));
        list.add(new Book(R.drawable.ns1,"User_name18"));

        return list;
    }
}