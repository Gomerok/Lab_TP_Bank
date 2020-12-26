package com.mycompany.domain.impl;

public class ExchangeVolume {
    private Double usdBuyVolume;
    private Double eurBuyVolume;
    private Double rubBuyVolume;
    private Double bynBuyVolume;

    private Double usdSellVolume;
    private Double eurSellVolume;
    private Double rubSellVolume;
    private Double bynSellVolume;

    private ExchangeVolume() {}

    public static final ExchangeVolume EXCHANGE_VOLUME = new ExchangeVolume();

    public Double getUsdBuyVolume() {
        return usdBuyVolume;
    }

    public void setUsdBuyVolume(Double usdBuyVolume) {
        this.usdBuyVolume = usdBuyVolume;
    }

    public Double getEurBuyVolume() {
        return eurBuyVolume;
    }

    public void setEurBuyVolume(Double eurBuyVolume) {
        this.eurBuyVolume = eurBuyVolume;
    }

    public Double getRubBuyVolume() {
        return rubBuyVolume;
    }

    public void setRubBuyVolume(Double rubBuyVolume) {
        this.rubBuyVolume = rubBuyVolume;
    }

    public Double getUsdSellVolume() {
        return usdSellVolume;
    }

    public void setUsdSellVolume(Double usdSellVolume) {
        this.usdSellVolume = usdSellVolume;
    }

    public Double getEurSellVolume() {
        return eurSellVolume;
    }

    public void setEurSellVolume(Double eurSellVolume) {
        this.eurSellVolume = eurSellVolume;
    }

    public Double getRubSellVolume() {
        return rubSellVolume;
    }

    public void setRubSellVolume(Double rubSellVolume) {
        this.rubSellVolume = rubSellVolume;
    }

    public Double getBynBuyVolume() {
        return bynBuyVolume;
    }

    public void setBynBuyVolume(Double bynBuyVolume) {
        this.bynBuyVolume = bynBuyVolume;
    }

    public Double getBynSellVolume() {
        return bynSellVolume;
    }

    public void setBynSellVolume(Double bynSellVolume) {
        this.bynSellVolume = bynSellVolume;
    }
}
