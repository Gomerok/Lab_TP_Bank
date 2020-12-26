package com.mycompany.domain.impl;

import com.mycompany.domain.Entity;

public class CurrencyNode extends Entity {
    private Long currencyId;
    private String numCode;
    private String charCode;
    private String scale;
    private String name;
    private String rateBuy;
    private String rateSell;
    private Long cityId;
    private Long bankId;

    public CurrencyNode() {}

    public CurrencyNode(Long currencyId, String numCode, String charCode, String scale, String name, String rateBuy, String rateSell, Long cityId, Long bankId) {
        this.currencyId = currencyId;
        this.numCode = numCode;
        this.charCode = charCode;
        this.scale = scale;
        this.name = name;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.cityId = cityId;
        this.bankId = bankId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(String rateBuy) {
        this.rateBuy = rateBuy;
    }

    public String getRateSell() {
        return rateSell;
    }

    public void setRateSell(String rateSell) {
        this.rateSell = rateSell;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "CurrencyNode{" +
                "currencyId=" + currencyId +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", scale='" + scale + '\'' +
                ", name='" + name + '\'' +
                ", rateBuy='" + rateBuy + '\'' +
                ", rateSell='" + rateSell + '\'' +
                ", cityId=" + cityId +
                ", bankId=" + bankId +
                '}';
    }
}
