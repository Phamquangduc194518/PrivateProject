package com.example.binance.vi.future.vithe;

import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("symbol")
    String symbol;
    @SerializedName("priceChange")
    String priceChange;
    @SerializedName("priceChangePercent")
    String priceChangePercent;
    @SerializedName("weightedAvgPrice")
    String weightedAvgPrice;
    @SerializedName("prevClosePrice")
    String prevClosePrice;
    @SerializedName("lastPrice")
    String cost;
    @SerializedName("lastQty")
    String lastQty;
    @SerializedName("bidPrice")
    String bidPrice;
    @SerializedName("bidQty")
    String bidQty;
    @SerializedName("askPrice")
    String askPrice;
    @SerializedName("askQty")
    String askQty;
    @SerializedName("openPrice")
    String openPrice;
    @SerializedName("highPrice")
    String highPrice;
    @SerializedName("lowPrice")
    String lowPrice;
    @SerializedName("volume")
    String volume;
    @SerializedName("quoteVolume")
    String quoteVolume;
    @SerializedName("openTime")
    String openTime;
    @SerializedName("closeTime")
    String closeTime;
    @SerializedName("firstId")
    String firstId;
    @SerializedName("lastId")
    String lastId;
    @SerializedName("count")
    String count;
    int id;
    String nameCoin;
    String typeIsolate;
    float costIn;
    float wallet;
    float quantity;
    int lever;
    float sumQuantity;
    float sumLever;

    public Currency(String symbol, String priceChange, String priceChangePercent, String weightedAvgPrice, String prevClosePrice, String cost, String lastQty, String bidPrice, String bidQty, String askPrice, String askQty, String openPrice, String highPrice, String lowPrice, String volume, String quoteVolume, String openTime, String closeTime, String firstId, String lastId, String count, int id, String nameCoin, String typeIsolate, float costIn, float wallet, float quantity, int lever, float sumQuantity, float sumLever) {
        this.symbol = symbol;
        this.priceChange = priceChange;
        this.priceChangePercent = priceChangePercent;
        this.weightedAvgPrice = weightedAvgPrice;
        this.prevClosePrice = prevClosePrice;
        this.cost = cost;
        this.lastQty = lastQty;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.volume = volume;
        this.quoteVolume = quoteVolume;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.firstId = firstId;
        this.lastId = lastId;
        this.count = count;
        this.id = id;
        this.nameCoin = nameCoin;
        this.typeIsolate = typeIsolate;
        this.costIn = costIn;
        this.wallet = wallet;
        this.quantity = quantity;
        this.lever = lever;
        this.sumQuantity = sumQuantity;
        this.sumLever = sumLever;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public String getWeightedAvgPrice() {
        return weightedAvgPrice;
    }

    public void setWeightedAvgPrice(String weightedAvgPrice) {
        this.weightedAvgPrice = weightedAvgPrice;
    }

    public String getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(String prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLastQty() {
        return lastQty;
    }

    public void setLastQty(String lastQty) {
        this.lastQty = lastQty;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidQty() {
        return bidQty;
    }

    public void setBidQty(String bidQty) {
        this.bidQty = bidQty;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    public String getAskQty() {
        return askQty;
    }

    public void setAskQty(String askQty) {
        this.askQty = askQty;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getFirstId() {
        return firstId;
    }

    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }

    public String getLastId() {
        return lastId;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public String getTypeIsolate() {
        return typeIsolate;
    }

    public void setTypeIsolate(String typeIsolate) {
        this.typeIsolate = typeIsolate;
    }

    public float getCostIn() {
        return costIn;
    }

    public void setCostIn(float costIn) {
        this.costIn = costIn;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public float getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(float sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public float getSumLever() {
        return sumLever;
    }

    public void setSumLever(float sumLever) {
        this.sumLever = sumLever;
    }
}