package com.example.binance.vi.future.vithe.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binance.R;
import com.example.binance.vi.future.vithe.ApiService;
import com.example.binance.vi.future.vithe.Currency;
import com.example.binance.vi.future.vithe.ViTheBlankFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViTheAdapter extends RecyclerView.Adapter<ViTheAdapter.ViTheViewHolder> {

    private Currency currencyValue;
    String costInToString;
    String PNLLongToString;
    String PNLShortToString;
    float Klg;
    String KlgToString;
    float costInToFloat;
    float costInToFloat2;
    float costInToFloat3;
    float costInToFloat4;
    float costOutToFloat;
    float costOutToFloat2;
    float costOutToFloat3;
    float costOutToFloat4;
    float PNLLong;
    float PNLLong2;
    float PNLLong3;
    float PNLLong4;
    float PNLShort;
    float PNLShort2;
    float PNLShort3;
    float PNLShort4;

    float walletValue;
    float walletValueSum;
    float marginCost;
    float marginCost2;
    float marginCost3;
    float marginCost4;

    float roeLong;
    float roeLong2;
    float roeLong3;
    float roeLong4;

    float roeShort;
    float roeShort2;
    float roeShort3;
    float roeShort4;
    private List<Currency> mlist;
    private List<Currency> mlist2 = new ArrayList<>();
    private List<Currency> mlist3 = new ArrayList<>();
    private List<Currency> mlist4 = new ArrayList<>();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Handler mHandler2 = new Handler(Looper.getMainLooper());
    private Handler mHandler3 = new Handler(Looper.getMainLooper());
    private Handler mHandler4 = new Handler(Looper.getMainLooper());
    private Currency currencyValue2;
    private Currency currencyValue3;
    private Currency currencyValue4;
    private Runnable runnableCode;
    private Runnable runnableCode2;
    private Runnable runnableCode3;
    private Runnable runnableCode4;
    private float soduvi;
    private float riskToFloat;
    private String riskToString;
    float thanhLytoFloat;
    String thanhLyToString;


    @SuppressLint("NotifDataSetChanged")
    public void setData(List<Currency> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViTheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvithe, parent, false);
        return new ViTheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViTheViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Currency currency = mlist.get(position);
        costInToFloat = currency.getCostIn();
        walletValue = currency.getWallet();
        ViTheBlankFragment vithe = new ViTheBlankFragment();
        mlist2 = vithe.getlist2();
        mlist3 = vithe.getlist3();
        mlist4 = vithe.getlist4();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi1(currency.getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue = response.body();
                        costInToString = String.valueOf(costInToFloat);
                        holder.costIn.setText(costInToString);
                        holder.styleIsolatedX.setText(String.valueOf(currency.getLever()));
                        holder.styleIsolated.setText(currency.getTypeIsolate());
                        Klg = currency.getQuantity();
                        KlgToString = String.format("%.4f", Klg).replace(",", ".");
                        holder.length.setText(KlgToString);
                        marginCost = ((Klg / 0.9953f) / (currency.getLever()));
                        holder.margin.setText(String.format("%.2f", marginCost).replace(",", "."));
                        if (currencyValue != null) {
                            holder.costOut.setText(currencyValue.getCost());
                            costOutToFloat = Float.parseFloat(currencyValue.getCost());
                            riskToFloat = ((currency.getSumQuantity()) / (soduvi * (currency.getSumLever()))) * 110;
                            riskToString = String.format("%.2f", riskToFloat).replace(",", ".");
                            holder.risk.setText(riskToString);
                            thanhLytoFloat = (costInToFloat * Math.abs(100f - ((soduvi * 100f) / (currency.getQuantity())))) / 100f;
                            thanhLyToString = String.format("%.4f", thanhLytoFloat).replace(",", ".");
                            holder.liquidationPrice.setText(thanhLyToString);

                        }

                        switch (currency.getId()) {
                            case 1: {
                                roeLong = ((costOutToFloat - costInToFloat) / (costInToFloat)) * (currency.getLever()) * 100f;
                                PNLLong = ((roeLong) * marginCost) / 100f;
                                PNLLongToString = String.format("%.2f", PNLLong).replace(",", ".");
                                holder.profit.setText(PNLLongToString);
                                holder.roe.setText(String.format("%.2f", roeLong).replace(",", "."));
                                if (costInToFloat < costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.percent.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.risk.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.profit.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#2ebd85"));
                                    if (Math.abs(roeLong) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong) > 5) {
                                        holder.danger2.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong) > 10) {
                                        holder.danger3.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong) > 15) {
                                        holder.danger4.setTextColor(Color.parseColor("#2ebd85"));
                                    }

                                }
                                if (costInToFloat > costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#f6465d"));
                                    holder.percent.setTextColor(Color.parseColor("#f6465d"));
                                    holder.profit.setTextColor(Color.parseColor("#f6465d"));
                                    holder.risk.setTextColor(Color.parseColor("#f0b90b"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#f0b90b"));
                                    if (Math.abs(roeLong) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong) > 1) {
                                        holder.danger2.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong) > 3) {
                                        holder.danger3.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong) > 5) {
                                        holder.danger4.setTextColor(Color.parseColor("#f6465d"));
                                    }

                                }
                                if (costInToFloat == costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#848e9c"));
                                    holder.percent.setTextColor(Color.parseColor("#848e9c"));
                                    holder.danger.setTextColor(Color.parseColor("#848e9c"));
                                    holder.roe.setText("0.00");
                                }
                            }
                            break;
                            case 2: {
                                roeShort = (costInToFloat - costOutToFloat) / (costOutToFloat) * (currency.getLever()) * 100f;
                                PNLShort = ((roeShort) * marginCost) / 100f;
                                PNLShortToString = String.format("%.2f", PNLShort).replace(",", ".");
                                holder.profit.setText(PNLShortToString);
                                holder.roe.setText(String.format("%.2f", roeShort).replace(",", "."));
                                if (costInToFloat > costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.percent.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.risk.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.profit.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#2ebd85"));
                                    if (Math.abs(roeShort) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort) > 5) {
                                        holder.danger2.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort) > 10) {
                                        holder.danger3.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort) > 15) {
                                        holder.danger4.setTextColor(Color.parseColor("#2ebd85"));
                                    }

                                }
                                if (costInToFloat < costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#f6465d"));
                                    holder.percent.setTextColor(Color.parseColor("#f6465d"));
                                    holder.profit.setTextColor(Color.parseColor("#f6465d"));
                                    holder.risk.setTextColor(Color.parseColor("#f0b90b"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#f0b90b"));
                                    if (Math.abs(roeShort) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort) > 1) {
                                        holder.danger2.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort) > 3) {
                                        holder.danger3.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort) > 5) {
                                        holder.danger4.setTextColor(Color.parseColor("#f6465d"));
                                    }


                                }
                                if (costInToFloat == costOutToFloat) {
                                    holder.roe.setTextColor(Color.parseColor("#848e9c"));
                                    holder.percent.setTextColor(Color.parseColor("#848e9c"));
                                    holder.danger.setTextColor(Color.parseColor("#848e9c"));
                                    holder.roe.setText("0.00");
                                }
                            }
                            break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });


                costInToFloat2 = mlist2.get(0).getCostIn();
                ApiService.apiService.callApi2(mlist2.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue2 = response.body();
                        costOutToFloat2 = Float.parseFloat(currencyValue2.getCost());
                        roeLong2 = ((costOutToFloat2 - costInToFloat2) / (costInToFloat2)) * (mlist2.get(0).getLever()) * 100f;
                        roeShort2 = (costInToFloat2 - costOutToFloat2) / (costOutToFloat2) * (mlist2.get(0).getLever()) * 100f;
                        marginCost2 = ((mlist2.get(0).getQuantity() / 0.9953f) / (mlist2.get(0).getLever()));
                        switch (mlist2.get(0).getId()) {
                            case 1:
                                PNLLong2 = ((roeLong2) * marginCost2) / 100f;
                                break;
                            case 2:
                                PNLShort2 = ((roeShort2) * marginCost2) / 100f;
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });

                costInToFloat3 = mlist3.get(0).getCostIn();
                ApiService.apiService.callApi3(mlist3.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue3 = response.body();
                        costOutToFloat3 = Float.parseFloat(currencyValue3.getCost());
                        roeLong3 = ((costOutToFloat3 - costInToFloat3) / (costInToFloat3)) * (mlist3.get(0).getLever()) * 100f;
                        roeShort3 = (costInToFloat3 - costOutToFloat3) / (costOutToFloat3) * (mlist3.get(0).getLever()) * 100f;
                        marginCost3 = ((mlist3.get(0).getQuantity() / 0.9953f) / (mlist3.get(0).getLever()));
                        switch (mlist3.get(0).getId()) {
                            case 1:
                                PNLLong3 = ((roeLong3) * marginCost3) / 100f;
                                break;
                            case 2:
                                PNLShort3 = ((roeShort3) * marginCost3) / 100f;
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });

                costInToFloat4 = mlist4.get(0).getCostIn();
                ApiService.apiService.callApi4(mlist4.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue4 = response.body();
                        costOutToFloat4 = Float.parseFloat(currencyValue4.getCost());
                        roeLong4 = ((costOutToFloat4 - costInToFloat4) / (costInToFloat4)) * (mlist4.get(0).getLever()) * 100f;
                        roeShort4 = (costInToFloat4 - costOutToFloat4) / (costOutToFloat4) * (mlist4.get(0).getLever()) * 100f;
                        marginCost4 = ((mlist4.get(0).getQuantity() / 0.9953f) / (mlist4.get(0).getLever()));
                        switch (mlist4.get(0).getId()) {
                            case 1:
                                PNLLong4 = ((roeLong4) * marginCost4) / 100f;
                                break;
                            case 2:
                                PNLShort4 = ((roeShort4) * marginCost4) / 100f;
                                break;
                        }
                        walletValueSum = walletValue + PNLLong + PNLLong2 + PNLLong3 + PNLLong4 + PNLShort + PNLShort2 + PNLShort3 + PNLShort4;
                        soduvi = walletValueSum;

                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });


                mHandler.postDelayed(this, 1500);
            }
        };
        mHandler.post(runnableCode);
        holder.nameCoin.setText(currency.getNameCoin());
        if (currency.getId() == 1) {
            holder.buy.setVisibility(View.VISIBLE);
        } else {
            holder.sell.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        if (mlist != null) {
            return mlist.size();
        }
        return 0;
    }


    public class ViTheViewHolder extends RecyclerView.ViewHolder {

        private TextView nameCoin;
        private TextView profit;
        private TextView roe;
        private TextView costIn;
        private TextView costOut;
        private TextView length;
        private TextView percent;
        private TextView danger;
        private TextView danger2;
        private TextView danger3;
        private TextView danger4;
        private TextView risk;
        private TextView riskPercent;
        private TextView sell;
        private TextView buy;
        private TextView styleIsolated;
        private TextView liquidationPrice;
        private TextView styleIsolatedX;
        private TextView margin;


        public ViTheViewHolder(@NonNull View itemView) {
            super(itemView);
            profit = itemView.findViewById(R.id.tv_profit);
            nameCoin = itemView.findViewById(R.id.tv_name_coin);
            roe = itemView.findViewById(R.id.tv_roe);
            costIn = itemView.findViewById(R.id.tv_cost_in);
            costOut = itemView.findViewById(R.id.tv_cost_out);
            length = itemView.findViewById(R.id.tv_kt);
            percent = itemView.findViewById(R.id.tv_percent);
            danger = itemView.findViewById(R.id.tv_danger);
            danger2 = itemView.findViewById(R.id.tv_danger2);
            danger3 = itemView.findViewById(R.id.tv_danger3);
            danger4 = itemView.findViewById(R.id.tv_danger4);
            risk = itemView.findViewById(R.id.tv_risk);
            riskPercent = itemView.findViewById(R.id.tv_risk_percent);
            sell = itemView.findViewById(R.id.tv_type_sell);
            buy = itemView.findViewById(R.id.tv_type_buy);
            styleIsolated = itemView.findViewById(R.id.tv_style_Isolated);
            liquidationPrice = itemView.findViewById(R.id.tv_liquidation_price);
            styleIsolatedX = itemView.findViewById(R.id.tv_style_Isolated_x);
            margin = itemView.findViewById(R.id.tv_margin);

        }
    }

}
