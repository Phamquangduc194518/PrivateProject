package com.example.binance.vi.future.vithe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binance.R;
import com.example.binance.vi.FundingFragment;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViTheAdapter extends RecyclerView.Adapter<ViTheAdapter.ViTheViewHolder> {
    private List<ViThe> mlist;
    private Handler mHandler;
    private Timer mTimer;


    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<ViThe> list){
        this.mlist=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViTheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvithe, parent,false);
        return new ViTheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViTheViewHolder holder, int position) {
        ViThe vithe = mlist.get(position);
        ApiService.apiService.callCostCoin("BNBUSDT").enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Currency currency = response.body();
                if(currency != null){
                    holder.costOut.setText(currency.getCost());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                return;
            }
        });
        holder.nameCoin.setText(vithe.getNameCoin());
        holder.length.setText(vithe.getKt());

    }

    @Override
    public int getItemCount() {
        if(mlist!= null){
            return mlist.size();
        }
        return 0;
    }


    public class ViTheViewHolder extends RecyclerView.ViewHolder{

        private TextView nameCoin;
        private TextView profit;
        private TextView roe;
        private TextView costIn;
        private TextView costOut;
        private TextView length;
        public ViTheViewHolder(@NonNull View itemView) {
            super(itemView);
        profit= itemView.findViewById(R.id.tv_profit);
        nameCoin=itemView.findViewById(R.id.tv_name_coin);
        roe = itemView.findViewById(R.id.tv_roe);
        costIn=itemView.findViewById(R.id.tv_cost_in);
        costOut=itemView.findViewById(R.id.tv_cost_out);
        length=itemView.findViewById(R.id.tv_kt);
        }
    }

    public ViTheAdapter() {
        mHandler = new Handler();
        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                    }
                });
            }
        }, 0, 1000); // set the refresh interval to 1000ms (1 second)
    }
}
