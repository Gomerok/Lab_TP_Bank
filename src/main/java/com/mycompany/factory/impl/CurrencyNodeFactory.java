package com.mycompany.factory.impl;

import com.mycompany.domain.impl.CurrencyNode;

public class CurrencyNodeFactory {
    public static final CurrencyNodeFactory CURRENCY_NODE_FACTORY = new CurrencyNodeFactory();

    private CurrencyNodeFactory() {}

    public CurrencyNode create(Long currencyId, String numCode, String charCode, String scale, String name, String rateBuy, String rateSell, Long cityId, Long bankId) {
        CurrencyNode currencyNode = new CurrencyNode();

        currencyNode.setCurrencyId(currencyId);
        currencyNode.setNumCode(numCode);
        currencyNode.setCharCode(charCode);
        currencyNode.setScale(scale);
        currencyNode.setName(name);
        currencyNode.setRateBuy(rateBuy);
        currencyNode.setRateSell(rateSell);
        currencyNode.setCityId(cityId);
        currencyNode.setBankId(bankId);

        return currencyNode;
    }
}
