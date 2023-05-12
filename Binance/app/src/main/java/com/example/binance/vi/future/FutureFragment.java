package com.example.binance.vi.future;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.binance.R;
import com.example.binance.vi.future.vithe.ApiService;
import com.example.binance.vi.future.vithe.Currency;
import com.example.binance.vi.future.vithe.ViTheBlankFragment;
import com.example.binance.vi.future.vithe.adapter.ViTheAdapter;
import com.google.android.material.tabs.TabLayout;


import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FutureFragment extends Fragment {
    private TabLayout mTab;
    private ViewPager viewPager;
    private View mView;
    private TextView wallet;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Handler mHandler2 = new Handler(Looper.getMainLooper());
    private Handler mHandler3 = new Handler(Looper.getMainLooper());
    private Handler mHandler4 = new Handler(Looper.getMainLooper());
    private Currency currencyValuefuture1;
    private Currency currencyValuefuture2;
    private Currency currencyValuefuture3;
    private Currency currencyValuefuture4;
    private Runnable runnableCode;
    private Runnable runnableCode2;
    private Runnable runnableCode3;
    private Runnable runnableCode4;
    private TextView usdm;
    private TextView coinM;
    private FutureViewPagerAdapter viewPagerAdapter;
    private ScrollView scrollView;
    private TextView hide;
    private TextView hideUsd;
    private TextView mgUsd;
    private TextView mgHideUsd;
    private TextView walletUsd;
    private TextView walletHideUsd;
    private GifImageView gif;
    private int count = 0;
    private TextView pnl;
    private TextView hidePnl;
    private List<Currency> mlist = new ArrayList<>();
    private List<Currency> mlist2 = new ArrayList<>();
    private List<Currency> mlist3 = new ArrayList<>();
    private List<Currency> mlist4 = new ArrayList<>();

    float costInToFloat;
    float costInToFloat2;
    float costInToFloat3;
    float costInToFloat4;

    String walletToString;
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
    String walletToString2;

    float walletValueSum;
    String walletValueSumToString2;
    String walletValueSumToString;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_future, container, false);
        mTab = mView.findViewById(R.id.tl_future_vi);
        scrollView = mView.findViewById(R.id.layout);
        usdm = mView.findViewById(R.id.usdm);
        coinM = mView.findViewById(R.id.coin_m);
        hide = mView.findViewById(R.id.tv_hide);
        viewPager = mView.findViewById(R.id.view_Pager);
        wallet = mView.findViewById(R.id.tv_cost_wallet);
        hideUsd = mView.findViewById(R.id.tv_hide_usd);
        gif = mView.findViewById(R.id.g_gif);
        mgUsd = mView.findViewById(R.id.tv_mg_USD);
        mgHideUsd = mView.findViewById(R.id.tv_mg_hide_USD);
        walletUsd = mView.findViewById(R.id.tv_wallet_USD);
        walletHideUsd = mView.findViewById(R.id.tv_wallet_hide_USD);
        pnl = mView.findViewById(R.id.tv_PNL);
        hidePnl = mView.findViewById(R.id.tv_hide_PNL);
        ImageView imageView = mView.findViewById(R.id.g_gif);
        viewPagerAdapter = new FutureViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        mTab.setupWithViewPager(viewPager);
        scrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        DecimalFormat decimalFormat2 = new DecimalFormat("#,###,##0.00");
        DecimalFormat decimalFormat4 = new DecimalFormat("#,###,##0.0000");
        DecimalFormat decimalFormat6 = new DecimalFormat("#,###,##0.000000");

        ViTheBlankFragment vithe = new ViTheBlankFragment();
        mlist = vithe.getlist();
        walletValue = mlist.get(0).getWallet();
        costInToFloat = mlist.get(0).getCostIn();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi1(mlist.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValuefuture1 = response.body();
                        if(currencyValuefuture1.getCost()!=null) {
                            costOutToFloat = Float.parseFloat(currencyValuefuture1.getCost());
                        }
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

                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.post(runnableCode);


        mlist2 = vithe.getlist2();
        costInToFloat2 = mlist2.get(0).getCostIn();
        runnableCode2 = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi2(mlist2.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValuefuture2 = response.body();
                        costOutToFloat2 = Float.parseFloat(currencyValuefuture2.getCost());
                        roeLong2 = ((costOutToFloat2-costInToFloat2)/(costInToFloat2))*(mlist2.get(0).getLever())*100f;
                        roeShort2=(costInToFloat2-costOutToFloat2)/(costOutToFloat2)*(mlist2.get(0).getLever())*100f;
                        marginCost2=((mlist2.get(0).getQuantity()/0.9953f)/(mlist2.get(0).getLever()));
                        switch (mlist2.get(0).getId()) {
                            case 1:
                                PNLLong2 = ((roeLong2)*marginCost2)/100f;
                                break;
                            case 2:
                                PNLShort2 = ((roeShort2) * marginCost2)/100f;
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });
                mHandler2.postDelayed(this, 1000);
            }
        };
        mHandler2.post(runnableCode2);

        mlist3 = vithe.getlist3();
        costInToFloat3 = mlist3.get(0).getCostIn();
        runnableCode3 = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi3(mlist3.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValuefuture3 = response.body();
                        costOutToFloat3 = Float.parseFloat(currencyValuefuture3.getCost());
                        roeLong3 = ((costOutToFloat3-costInToFloat3)/(costInToFloat3))*(mlist3.get(0).getLever())*100f;
                        roeShort3=(costInToFloat3-costOutToFloat3)/(costOutToFloat3)*(mlist3.get(0).getLever())*100f;
                        marginCost3=((mlist3.get(0).getQuantity()/0.9953f)/(mlist3.get(0).getLever()));
                        switch (mlist3.get(0).getId()) {
                            case 1:
                                PNLLong3 = ((roeLong3)*marginCost3)/100f;
                                break;
                            case 2:
                                PNLShort3 = ((roeShort3) * marginCost3)/100f;
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });
                mHandler3.postDelayed(this, 1000);
            }
        };
        mHandler3.post(runnableCode3);


        mlist4= vithe.getlist4();
        costInToFloat4 = mlist4.get(0).getCostIn();
        runnableCode4 = new Runnable() {
            @Override
            public void run() {
                ApiService.apiService.callApi4(mlist4.get(0).getNameCoin()).enqueue(new Callback<Currency>() {
                    @Override
                    public void onResponse(Call<Currency> call, Response<Currency> response) {
                        currencyValuefuture4 = response.body();
                        costOutToFloat4 = Float.parseFloat(currencyValuefuture4.getCost());
                        roeLong4 = ((costOutToFloat4-costInToFloat4)/(costInToFloat4))*(mlist4.get(0).getLever())*100f;
                        roeShort4=(costInToFloat4-costOutToFloat4)/(costOutToFloat4)*(mlist4.get(0).getLever())*100f;
                        marginCost4=((mlist4.get(0).getQuantity()/0.9953f)/(mlist4.get(0).getLever()));
                        switch (mlist4.get(0).getId()) {
                            case 1:
                                PNLLong4= ((roeLong4)*marginCost4)/100f;
                                break;
                            case 2:
                                PNLShort4 = ((roeShort4) * marginCost4)/100f;
                                break;
                        }
                        walletValueSum=PNLLong+PNLLong2+PNLLong3+PNLLong4+PNLShort+PNLShort2+PNLShort3+PNLShort4;
                        walletValueSumToString=decimalFormat4.format(walletValueSum);
                        walletValueSumToString2=decimalFormat6.format(walletValueSum);
                        walletToString= decimalFormat4.format(walletValue+PNLLong+PNLLong2+PNLLong3+PNLLong4+PNLShort+PNLShort2+PNLShort3+PNLShort4);
                        walletToString2= decimalFormat2.format(walletValue+PNLLong+PNLLong2+PNLLong3+PNLLong4+PNLShort+PNLShort2+PNLShort3+PNLShort4);
                        wallet.setText(walletToString);
                        hideUsd.setText(walletToString2);
                        mgUsd.setText(walletToString);
                        mgHideUsd.setText(walletToString2);
                        walletHideUsd.setText(walletToString2);
                        walletUsd.setText(walletToString);
                        pnl.setText(walletValueSumToString);
                        hidePnl.setText(walletValueSumToString2);

                    }

                    @Override
                    public void onFailure(Call<Currency> call, Throwable t) {
                        return;
                    }
                });
                mHandler4.postDelayed(this, 1000);
            }
        };
        mHandler4.post(runnableCode4);



        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.uploading);
            imageView.setImageDrawable(gifDrawable);
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (scrollX == View.OVER_SCROLL_ALWAYS && scrollY == View.OVER_SCROLL_ALWAYS) {
                        imageView.setVisibility(View.VISIBLE);
                        gifDrawable.start();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                gifDrawable.stop();
                                imageView.setVisibility(View.GONE);
                            }
                        }, 3000);
                    }
                }
            });
        } catch (
                IOException e) {
            e.printStackTrace();
        }


        coinM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinM.setBackgroundResource(R.drawable.custom_view_usd1);
                coinM.setTextColor(Color.parseColor("#000000"));
                usdm.setTextColor(Color.parseColor("#9da3ad"));
                usdm.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        usdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usdm.setBackgroundResource(R.drawable.custom_view_usd1);
                usdm.setTextColor(Color.parseColor("#000000"));
                coinM.setTextColor(Color.parseColor("#9da3ad"));
                coinM.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });



        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 == 1) {
                    mHandler.removeCallbacks(runnableCode);
                    wallet.setText("*****");
                    hideUsd.setText("*****");
                    mgUsd.setText("*****");
                    mgHideUsd.setText("*****");
                    walletUsd.setText("*****");
                    walletHideUsd.setText("*****");
                    pnl.setText("*****");
                    hidePnl.setText("*****");
                }

                if (count % 2 == 0) {
                    mHandler.post(runnableCode);
                }
            }
        });
        return mView;
    }


}