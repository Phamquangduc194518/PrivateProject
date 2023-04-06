package com.example.binance.vi.future.vithe;

public class ViThe {
    String nameCoin ;
    String kt;

    public ViThe(String nameCoin, String kt) {
        this.nameCoin = nameCoin;
        this.kt = kt;
    }

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }
}
