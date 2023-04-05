package com.example.recycleviewlinearlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_data;
    private UserAdapter user_adapter;
    private List<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_data=findViewById(R.id.rcv_data);
        user_adapter= new UserAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_data.setLayoutManager(linearLayoutManager);
        user_adapter.setData(getlist());
        rcv_data.setAdapter(user_adapter);
    }

    public List<User> getlist(){

        list.add(new User(R.drawable.ns1,"Nguyễn Ngọc Như","18"));
        list.add(new User(R.drawable.ns2,"Nguyễn Khả Ái","21"));
        list.add(new User(R.drawable.ns3,"Trần Hà Thu","23"));
        list.add(new User(R.drawable.ns4,"Đinh Thu Hà","19"));
        list.add(new User(R.drawable.ns5,"Nguyễn Hải Anh","10"));
        list.add(new User(R.drawable.ns1,"Phạm Hà Thu","18"));
        list.add(new User(R.drawable.ns2,"Nguyễn Ngọc Như","18"));
        list.add(new User(R.drawable.ns3,"Nguyễn Ngọc Như","21"));
        list.add(new User(R.drawable.ns4,"Nguyễn Ngọc Như","23"));
        list.add(new User(R.drawable.ns5,"Nguyễn Ngọc Như","19"));
        list.add(new User(R.drawable.ns1,"Nguyễn Ngọc Như","10"));
        list.add(new User(R.drawable.ns2,"Nguyễn Ngọc Như","18"));

        return list;
    }
}