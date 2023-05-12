package com.example.binance.vi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binance.R;
import com.example.binance.vi.future.FutureFragment;


public class FundingFragment extends Fragment {
    private View mView;
    private EditText nameCoin;
    private EditText quantityCoin;
    private Button call;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_funding, container, false);
        nameCoin = mView.findViewById(R.id.edt_name_coin);
        quantityCoin = mView.findViewById(R.id.edt_quantity_coin);
        call = mView.findViewById(R.id.btn_call);
//        call.setOnClickListener(v -> senDataToActivity());
        return mView;
    }

//    private void senDataToActivity() {
//        String nameCoinStr = nameCoin.getText().toString();
//        String quantityCoinStr = quantityCoin.getText().toString();
//        listener.onDataSend(nameCoinStr, quantityCoinStr);
//    }
}