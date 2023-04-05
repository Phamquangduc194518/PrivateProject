package com.example.binance.vi.future.vithe;

import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("price")
    private String cost;

    public Currency(String cost) {
        this.cost = cost;
    }
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
