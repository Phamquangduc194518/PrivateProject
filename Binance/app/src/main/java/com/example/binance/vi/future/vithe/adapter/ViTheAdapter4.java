package com.example.binance.vi.future.vithe.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViTheAdapter4 extends RecyclerView.Adapter<ViTheAdapter4.ViTheViewHolder4> {



    String costInToString4;



    String PNLLongToString4;
    String PNLShortToString4;
    float quantityFuture4;
    float Klg4;
    String KlgToString4;

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
    private Currency currencyValue;
    private Currency currencyValue2;
    private Currency currencyValue3;
    private Currency currencyValue4;
    private Runnable runnableCode;
    private Runnable runnableCode2;
    private Runnable runnableCode3;
    private Runnable runnableCode4;
    private float soduvi;
    private float riskToFloat4;
    private String riskToString4;
    float thanhLytoFloat4;
    String thanhLyToString4;

    @SuppressLint("NotifyDataSetChanged")
    public void setData4(List<Currency> list) {
        this.mlist4 = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViTheViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvithe, parent, false);
        return new ViTheAdapter4.ViTheViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViTheViewHolder4 holder, int position) {
        Currency currency = mlist4.get(position);
        ViTheBlankFragment vithe = new ViTheBlankFragment();
        mlist=vithe.getlist();
        mlist2=vithe.getlist2();
        mlist3=vithe.getlist3();
        costInToFloat4 = currency.getCostIn();
        runnableCode4 = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi4(currency.getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue4 = response.body();
                        costInToString4 = String.valueOf(costInToFloat4);
                        holder.costIn.setText(costInToString4);
                        holder.styleIsolatedX.setText(String.valueOf(currency.getLever()));
                        holder.styleIsolated.setText(currency.getTypeIsolate());
                        Klg4= currency.getQuantity();
                        KlgToString4 = String.format("%.4f",Klg4).replace(",",".");
                        holder.length.setText(KlgToString4);
                        marginCost4=((Klg4/0.9953f)/(currency.getLever()));
                        holder.margin.setText(String.format("%.2f",marginCost4).replace(",","."));
                        if (currencyValue4 != null) {
                            holder.costOut.setText(currencyValue4.getCost());
                            costOutToFloat4 = Float.parseFloat(currencyValue4.getCost());
                            riskToFloat4=((currency.getSumQuantity())/(soduvi*(currency.getSumLever())))*110;
                            riskToString4=String.format("%.2f",riskToFloat4).replace(",",".");
                            holder.risk.setText(riskToString4);
                            thanhLytoFloat4=(costInToFloat4*Math.abs(100f-((soduvi*100f)/(currency.getQuantity()))))/100f;
                            thanhLyToString4=String.format("%.4f",thanhLytoFloat4).replace(",", ".");
                            holder.liquidationPrice.setText(thanhLyToString4);

                        }

                        switch (currency.getId()) {
                            case 1: {
                                roeLong4 = ((costOutToFloat4-costInToFloat4)/(costInToFloat4))*(currency.getLever())*100f;
                                PNLLong4 = ((roeLong4)*marginCost4)/100f;
                                PNLLongToString4 = String.format("%.2f",PNLLong4 ).replace(",", ".");
                                holder.profit.setText(PNLLongToString4);
                                holder.roe.setText(String.format("%.2f",roeLong4).replace(",","."));
                                if (costInToFloat4 < costOutToFloat4) {
                                    holder.roe.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.percent.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.risk.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.profit.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#2ebd85"));
                                    if (Math.abs(roeLong4) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong4) > 5) {
                                        holder.danger2.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong4) > 10) {
                                        holder.danger3.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeLong4) > 15) {
                                        holder.danger4.setTextColor(Color.parseColor("#2ebd85"));
                                    }

                                }
                                if (costInToFloat4 > costOutToFloat4) {
                                    holder.roe.setTextColor(Color.parseColor("#f6465d"));
                                    holder.percent.setTextColor(Color.parseColor("#f6465d"));
                                    holder.profit.setTextColor(Color.parseColor("#f6465d"));
                                    holder.risk.setTextColor(Color.parseColor("#f0b90b"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#f0b90b"));
                                    if (Math.abs(roeLong4) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong4) > 1) {
                                        holder.danger2.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong4) > 3) {
                                        holder.danger3.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeLong4) > 5) {
                                        holder.danger4.setTextColor(Color.parseColor("#f6465d"));
                                    }

                                }
                                if (costInToFloat4 == costOutToFloat4) {
                                    holder.roe.setTextColor(Color.parseColor("#848e9c"));
                                    holder.percent.setTextColor(Color.parseColor("#848e9c"));
                                    holder.danger.setTextColor(Color.parseColor("#848e9c"));
                                    holder.roe.setText("0.00");
                                }
                            }
                            break;
                            case 2: {
                                roeShort4=(costInToFloat4-costOutToFloat4)/(costOutToFloat4)*(currency.getLever())*100f;
                                PNLShort4 = ((roeShort4) * marginCost4)/100f;
                                PNLShortToString4 = String.format("%.2f",PNLShort4 ).replace(",", ".");
                                holder.profit.setText(PNLShortToString4);
                                holder.roe.setText(String.format("%.2f",roeShort4).replace(",","."));
                                if (costInToFloat4 > costOutToFloat4) {
                                    holder.roe.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.percent.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.risk.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.profit.setTextColor(Color.parseColor("#0ecb81"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#2ebd85"));
                                    if (Math.abs(roeShort4) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort4) > 5) {
                                        holder.danger2.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort4) > 10) {
                                        holder.danger3.setTextColor(Color.parseColor("#2ebd85"));
                                    }
                                    if (Math.abs(roeShort4) > 15) {
                                        holder.danger4.setTextColor(Color.parseColor("#2ebd85"));
                                    }

                                }
                                if (costInToFloat4 < costOutToFloat4) {
                                    holder.roe.setTextColor(Color.parseColor("#f6465d"));
                                    holder.percent.setTextColor(Color.parseColor("#f6465d"));
                                    holder.profit.setTextColor(Color.parseColor("#f6465d"));
                                    holder.risk.setTextColor(Color.parseColor("#f0b90b"));
                                    holder.riskPercent.setTextColor(Color.parseColor("#f0b90b"));
                                    if (Math.abs(roeShort4) > 0) {
                                        holder.danger.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort4) > 1) {
                                        holder.danger2.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort4) > 3) {
                                        holder.danger3.setTextColor(Color.parseColor("#f6465d"));
                                    }
                                    if (Math.abs(roeShort4) > 5) {
                                        holder.danger4.setTextColor(Color.parseColor("#f6465d"));
                                    }


                                }
                                if (costInToFloat4 == costOutToFloat4) {
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

                walletValue = mlist.get(0).getWallet();
                costInToFloat = mlist.get(0).getCostIn();
                ApiService.apiService.callApi1(mlist.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValue = response.body();
                        costOutToFloat = Float.parseFloat(currencyValue.getCost());
                        roeLong = ((costOutToFloat-costInToFloat)/(costInToFloat))*(mlist.get(0).getLever())*100f;
                        roeShort=(costInToFloat-costOutToFloat)/(costOutToFloat)*(mlist.get(0).getLever())*100f;
                        marginCost=((mlist.get(0).getQuantity()/0.9953f)/(mlist.get(0).getLever()));
                        switch (mlist.get(0).getId()) {
                            case 1:
                                PNLLong = ((roeLong)*marginCost)/100f;
                                break;
                            case 2:
                                PNLShort = ((roeShort) * marginCost)/100f;
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
                        walletValueSum=walletValue+PNLLong+PNLLong2+PNLLong3+PNLLong4+PNLShort+PNLShort2+PNLShort3+PNLShort4;
                        soduvi=walletValueSum;
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });

                mHandler4.postDelayed(this, 1500);
            }
        };
        mHandler4.post(runnableCode4);
        holder.nameCoin.setText(currency.getNameCoin());
        if (currency.getId() == 1) {
            holder.buy.setVisibility(View.VISIBLE);
        } else {
            holder.sell.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        if (mlist4 != null) {
            return mlist4.size();
        }
        return 0;
    }


    public class ViTheViewHolder4 extends RecyclerView.ViewHolder {

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

        public ViTheViewHolder4(@NonNull View itemView) {
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
            liquidationPrice=itemView.findViewById(R.id.tv_liquidation_price);
            styleIsolatedX=itemView.findViewById(R.id.tv_style_Isolated_x);
            margin = itemView.findViewById(R.id.tv_margin);
        }
    }
}
