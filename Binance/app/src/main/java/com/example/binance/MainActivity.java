package com.example.binance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.example.binance.vi.future.vithe.ApiService;
import com.example.binance.vi.future.vithe.Currency;
import com.example.binance.vi.future.vithe.ViTheBlankFragment;
import com.example.binance.vi.future.vithe.adapter.ViTheAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private TrangchuFragment trangChuFragment;
    private ThitruongFragment thiTruongFragment;
    private GiaodichFragment giaoDichFragment;
    private FuturesFragment futuresFragment;
    private ViFragment viFragment;
    private String a;



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
    private Currency currencyValueMain1;
    private Currency currencyValueMain2;
    private Currency currencyValueMain3;
    private Currency currencyValueMain4;
    private Runnable runnableCode;
    private Runnable runnableCode2;
    private Runnable runnableCode3;
    private Runnable runnableCode4;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Handler mHandler2 = new Handler(Looper.getMainLooper());
    private Handler mHandler3 = new Handler(Looper.getMainLooper());
    private Handler mHandler4 = new Handler(Looper.getMainLooper());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setItemIconSize(55);
        trangChuFragment = new TrangchuFragment();
        thiTruongFragment = new ThitruongFragment();
        giaoDichFragment = new GiaodichFragment();
        futuresFragment = new FuturesFragment();
        viFragment = new ViFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new TrangchuFragment());
        fragmentTransaction.commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trangchu:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new TrangchuFragment());
                        fragmentTransaction.commit();
                        break;

                    case R.id.thitruong:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new ThitruongFragment());
                        fragmentTransaction.commit();
                        break;

                    case R.id.giaodich:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new GiaodichFragment());
                        fragmentTransaction.commit();
                        break;

                    case R.id.futures:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new FuturesFragment());
                        fragmentTransaction.commit();
                        break;

                    case R.id.vi:
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new ViFragment());
                        fragmentTransaction.commit();
                        break;

                }
                return true;
            }
        });

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
                        currencyValueMain1 = response.body();
                        costOutToFloat = Float.parseFloat(currencyValueMain1.getCost());
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
                        currencyValueMain2 = response.body();
                        costOutToFloat2 = Float.parseFloat(currencyValueMain2.getCost());
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
                        currencyValueMain3 = response.body();
                        costOutToFloat3 = Float.parseFloat(currencyValueMain3.getCost());
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
                        currencyValueMain4 = response.body();
                        costOutToFloat4 = Float.parseFloat(currencyValueMain4.getCost());
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
                        walletValueSum=walletValue+PNLLong+PNLLong2+PNLLong3+PNLLong4+PNLShort+PNLShort2+PNLShort3+PNLShort4;

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

    }

}