package com.mycompany.util;

/**
 * Storage for @link{com.mycompany.controller.cashier.ChooseCurrencyController} data
 * to be input
 */
public class InputDataStorage {
    public static final InputDataStorage INPUT_DATA_STORAGE = new InputDataStorage();

    private String currencyValueFrom;
    private String currencyValueTo;
//    private String sum;
    private String buyOrSellOperation;

    private String name;
    private String surname;
    private double exSum;
    private double finalSum;

    private InputDataStorage() {

    }

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

//    public String getSum() {
//        return sum;
//    }
//
//    public void setSum(String sum) {
//        this.sum = sum;
//    }

    public String getBuyOrSellOperation() {
        return buyOrSellOperation;
    }

    public void setBuyOrSellOperation(String buyOrSellOperation) {
        this.buyOrSellOperation = buyOrSellOperation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getExSum() {
        return exSum;
    }

    public void setExSum(double exSum) {
        this.exSum = exSum;
    }

    public double getFinalSum() {
        return finalSum;
    }

    public void setFinalSum(double finalSum) {
        this.finalSum = finalSum;
    }
}
