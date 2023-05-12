package com.example.binance.vi.future.vithe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.Cleaner;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();


    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api.binance.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("api/v3/ticker/24hr")
    Call<Currency> callApi1(@Query("symbol") String symbol);

    @GET("api/v3/ticker/24hr")
    Call<Currency> callApi2(@Query("symbol") String symbol);

    @GET("api/v3/ticker/24hr")
    Call<Currency> callApi3(@Query("symbol") String symbol);

    @GET("api/v3/ticker/24hr")
    Call<Currency> callApi4(@Query("symbol") String symbol);


}
