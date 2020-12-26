package com.mycompany.util;

/**
 * Storage for @link{com.mycompany.controller.cashier.ChooseCurrencyController} data
 * to be input
 */
public class InputDataStorage {
    public static final InputDataStorage INPUT_DATA_STORAGE = new InputDataStorage();

    private String currencyValueFrom;
    private String currencyValueTo;
    private String sum;
    private String buyOrSellOperation;

    public String getCurrencyValueFrom() {
        return currencyValueFrom;
    }

    public void setCurrencyValueFrom(String currencyValueFrom) {
        this.currencyValueFrom = currencyValueFrom;
    }

    public String getCurrencyValueTo() {
        return currencyValueTo;
    }

    public void setCurrencyValueTo(String currencyValueTo) {
        this.currencyValueTo = currencyValueTo;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getBuyOrSellOperation() {
        return buyOrSellOperation;
    }

    public void setBuyOrSellOperation(String buyOrSellOperation) {
        this.buyOrSellOperation = buyOrSellOperation;
    }
}
