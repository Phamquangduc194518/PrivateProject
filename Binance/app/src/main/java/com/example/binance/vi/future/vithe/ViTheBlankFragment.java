package com.example.binance.vi.future.vithe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.binance.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViTheBlankFragment extends Fragment {

    private RecyclerView rcvData;
    private ViTheAdapter viTheAdapter;
    private List<ViThe> list;

    private TextView cost;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vi_the_blank, container, false);
        Context context = container.getContext();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        cost=rootView.findViewById(R.id.tv_number);
        rcvData = rootView.findViewById(R.id.rcv_data);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rcvData.setLayoutManager(mLayoutManager);
        viTheAdapter = new ViTheAdapter();
        viTheAdapter.setData(getlist());
        rcvData.setAdapter(viTheAdapter);
        rcvData.addItemDecoration(itemDecoration);

        return rootView;
    }


    public List<ViThe> getlist() {
        list = new ArrayList<>();
        list.add(new ViThe("20"));
        list.add(new ViThe("20"));
        list.add(new ViThe("20"));
        list.add(new ViThe("20"));
        return list;
    }
}