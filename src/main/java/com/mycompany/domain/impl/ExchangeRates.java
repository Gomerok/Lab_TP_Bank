package com.mycompany.domain.impl;

import javafx.beans.property.SimpleDoubleProperty;

public class ExchangeRates {
    private SimpleDoubleProperty usdSell;
    private SimpleDoubleProperty eurSell;
    private SimpleDoubleProperty rubSell;

    private SimpleDoubleProperty usdBuy;
    private SimpleDoubleProperty eurBuy;
    private SimpleDoubleProperty rubBuy;

    private ExchangeRates() {}

    private static ExchangeRates exchangeRates;

    public static ExchangeRates getInstance() {
        if (exchangeRates == null) {
            exchangeRates = new ExchangeRates();
        }
        return exchangeRates;
    }

    public Double getUsdSell() {
        return usdSell.get();
    }

    public void setUsdSell(Double usdSell) {
        this.usdSell = new SimpleDoubleProperty(usdSell);
    }

    public Double getEurSell() {
        return eurSell.get();
    }

    public void setEurSell(Double eurSell) {
        this.eurSell = new SimpleDoubleProperty(eurSell);
    }

    public Double getRubSell() {
        return rubSell.get();
    }

    public void setRubSell(Double rubSell) {
        this.rubSell = new SimpleDoubleProperty(rubSell);
    }

    public Double getUsdBuy() {
        return usdBuy.get();
    }

    public void setUsdBuy(Double usdBuy) {
        this.usdBuy = new SimpleDoubleProperty(usdBuy);
    }

    public Double getEurBuy() {
        return eurBuy.get();
    }

    public void setEurBuy(Double eurBuy) {
        this.eurBuy = new SimpleDoubleProperty(eurBuy);
    }

    public Double getRubBuy() {
        return rubBuy.get();
    }

    public void setRubBuy(Double rubBuy) {
        this.rubBuy = new SimpleDoubleProperty(rubBuy);
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "usdSell=" + usdSell.get() +
                ", eurSell=" + eurSell.get() +
                ", rubSell=" + rubSell.get() +
                ", usdBuy=" + usdBuy.get() +
                ", eurBuy=" + eurBuy.get() +
                ", rubBuy=" + rubBuy.get() +
                '}';
    }
}
