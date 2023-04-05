package com.example.binance.vi.future.vithe;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binance.R;

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
                    holder.number.setText(currency.getCost());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                return;
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mlist!= null){
            return mlist.size();
        }
        return 0;
    }

    public class ViTheViewHolder extends RecyclerView.ViewHolder{

        private TextView number;
        public ViTheViewHolder(@NonNull View itemView) {
            super(itemView);
        number= itemView.findViewById(R.id.tv_number);
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
