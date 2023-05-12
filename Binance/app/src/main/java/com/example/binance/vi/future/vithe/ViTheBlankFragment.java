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

import com.example.binance.vi.future.vithe.adapter.ViTheAdapter;
import com.example.binance.vi.future.vithe.adapter.ViTheAdapter2;
import com.example.binance.vi.future.vithe.adapter.ViTheAdapter3;
import com.example.binance.vi.future.vithe.adapter.ViTheAdapter4;
//import com.example.binance.vi.future.vithe.adapter.ViTheAdapter2;
//import com.example.binance.vi.future.vithe.adapter.ViTheAdapter3;
//import com.example.binance.vi.future.vithe.adapter.ViTheAdapter4;
//import com.example.binance.vi.future.vithe.adapter.ViTheAdapter5;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class ViTheBlankFragment extends Fragment {

    private final String I = "Isolated";
    private final String C = "Cross";
    private final float w=200.1231235f;
    private int donbay1=125;
    private int donbay2=120;
    private int donbay3=100;
    private int donbay4=50;
    private float quantity1=300f;
    private float quantity2=210f;
    private float quantity3=280f;
    private float quantity4=400.12f;

    private RecyclerView rcvData;
    private RecyclerView rcvData2;
    private RecyclerView rcvData3;
    private RecyclerView rcvData4;
    private RecyclerView rcvData5;
    private ViTheAdapter viTheAdapter;
    private ViTheAdapter2 viTheAdapter2;
    private ViTheAdapter3 viTheAdapter3;
    private ViTheAdapter4 viTheAdapter4;


    private List<Currency> mlist= new ArrayList<>();
    private List<Currency> mlist2= new ArrayList<>();
    private List<Currency> mlist3= new ArrayList<>();
    private List<Currency> mlist4= new ArrayList<>();
    private int sumDonbay=donbay1+donbay2+donbay3+donbay4;
    private float sumQuantity= quantity1+quantity2+quantity3+quantity4;


    private TextView cost;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private int i=0;

    @SuppressLint({"MissingInflatedId", "CheckResult"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vi_the_blank, container, false);
        Context context = container.getContext();
        cost = rootView.findViewById(R.id.tv_profit);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration2 = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration3 = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration4 = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        rcvData = rootView.findViewById(R.id.rcv_data);
        rcvData2 = rootView.findViewById(R.id.rcv_data2);
        rcvData3 = rootView.findViewById(R.id.rcv_data3);
        rcvData4 = rootView.findViewById(R.id.rcv_data4);
        rcvData5 = rootView.findViewById(R.id.rcv_data5);


        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getActivity());
        LinearLayoutManager mLayoutManager3 = new LinearLayoutManager(getActivity());
        LinearLayoutManager mLayoutManager4 = new LinearLayoutManager(getActivity());
//        LinearLayoutManager mLayoutManager5= new LinearLayoutManager(getActivity());


        rcvData.setLayoutManager(mLayoutManager);
        rcvData2.setLayoutManager(mLayoutManager2);
        rcvData3.setLayoutManager(mLayoutManager3);
        rcvData4.setLayoutManager(mLayoutManager4);
//        rcvData5.setLayoutManager(mLayoutManager5);



        viTheAdapter = new ViTheAdapter();
        viTheAdapter2 = new ViTheAdapter2();
        viTheAdapter3= new ViTheAdapter3();
        viTheAdapter4 = new ViTheAdapter4();
//        viTheAdapter5 = new ViTheAdapter5();


        viTheAdapter.setData(getlist());
        viTheAdapter2.setData2(getlist2());
        viTheAdapter3.setData3(getlist3());
        viTheAdapter4.setData4(getlist4());
//        viTheAdapter5.setData5(getlist5());


        rcvData.setAdapter(viTheAdapter);
        rcvData2.setAdapter(viTheAdapter2);
        rcvData3.setAdapter(viTheAdapter3);
        rcvData4.setAdapter(viTheAdapter4);
//        rcvData5.setAdapter(viTheAdapter5);


        rcvData.addItemDecoration(new TopDividerItemDecoration(getActivity()));
        rcvData2.addItemDecoration(new MarginDividerItemDecoration(getActivity()));
        rcvData3.addItemDecoration(new MarginDividerItemDecoration(getActivity()));
        rcvData4.addItemDecoration(new MarginDividerItemDecoration(getActivity()));
        rcvData4.addItemDecoration(new MarginDividerItemDecorationBottom(getActivity()));

        rcvData.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rcvData2.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rcvData3.setOverScrollMode(View.OVER_SCROLL_NEVER);
        rcvData4.setOverScrollMode(View.OVER_SCROLL_NEVER);

        return rootView;

    }

// 1 là long, 2 là short
// I là Isolated, C là Cross
//costIn là giá vào lệnh
    public List<Currency> getlist() {
        mlist.add(new Currency("","","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","",1,"ARB"+"USDT",C,1.13f,w,quantity1,donbay1,sumQuantity,sumDonbay));
        return mlist;
    }
    public List<Currency> getlist2() {
        mlist2.add(new Currency("","","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","",1,"ID"+"USDT",C,0.472f,w,quantity2,donbay2,sumQuantity,sumDonbay));
        return mlist2;
    }
    public List<Currency> getlist3() {
        mlist3.add(new Currency("","","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","",1,"NEAR"+"USDT",C,1.577f,w,quantity3,donbay3,sumQuantity,sumDonbay));
        return mlist3;
    }
    public List<Currency> getlist4() {
        mlist4.add(new Currency("","","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","",1,"BTC"+"USDT",C,27159f,w,quantity4,donbay4,sumQuantity,sumDonbay));
        return mlist4;
    }



}