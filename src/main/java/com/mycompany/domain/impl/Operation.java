package com.mycompany.domain.impl;

import com.mycompany.domain.Entity;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Operation extends Entity {
    private SimpleLongProperty operationId;
    private SimpleStringProperty cashierName;
    private SimpleStringProperty clientName;
    private SimpleStringProperty buyOrSell;
    private SimpleStringProperty fromWhichCurrency;
    private SimpleStringProperty toWhichCurrency;
    private SimpleDoubleProperty sum;
    private SimpleStringProperty date;

    public Operation() {
        long currentId = getId();
        setId(currentId++);
    }

    public Operation(String cashierName, String clientName, String buyOrSell, String fromWhichCurrency, String toWhichCurrency, Double sum, String date) {
        long currentId = getId();
        setId(currentId++);
        this.cashierName = new SimpleStringProperty(cashierName);
        this.clientName = new SimpleStringProperty(clientName);
        this.buyOrSell = new SimpleStringProperty(buyOrSell);
        this.fromWhichCurrency = new SimpleStringProperty(fromWhichCurrency);
        this.toWhichCurrency = new SimpleStringProperty(toWhichCurrency);
        this.sum = new SimpleDoubleProperty(sum);
        this.date = new SimpleStringProperty(date);
    }

    public Operation(Long operationId, String cashierName, String clientName, String buyOrSell, String fromWhichCurrency, String toWhichCurrency, Double sum, String date) {
        long currentId = getId();
        setId(currentId++);
        this.operationId = new SimpleLongProperty(operationId);
        this.cashierName = new SimpleStringProperty(cashierName);
        this.clientName = new SimpleStringProperty(clientName);
        this.buyOrSell = new SimpleStringProperty(buyOrSell);
        this.fromWhichCurrency = new SimpleStringProperty(fromWhichCurrency);
        this.toWhichCurrency = new SimpleStringProperty(toWhichCurrency);
        this.sum = new SimpleDoubleProperty(sum);
        this.date = new SimpleStringProperty(date);
    }

    public long getOperationId() {
        return operationId.get();
    }

    public void setOperationId(long operationId) {
        this.operationId = new SimpleLongProperty(operationId);
    }

    public String getCashierName() {
        return cashierName.get();
    }

    public void setCashierName(String cashierName) {
        this.cashierName = new SimpleStringProperty(cashierName);
    }

    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String clientName) {
        this.clientName = new SimpleStringProperty(clientName);
    }

    public String getBuyOrSell() {
        return buyOrSell.get();
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = new SimpleStringProperty(buyOrSell);
    }

    public String getFromWhichCurrency() {
        return fromWhichCurrency.get();
    }

    public void setFromWhichCurrency(String fromWhichCurrency) {
        this.fromWhichCurrency = new SimpleStringProperty(fromWhichCurrency);
    }

    public String getToWhichCurrency() {
        return toWhichCurrency.get();
    }

    public void setToWhichCurrency(String toWhichCurrency) {
        this.toWhichCurrency = new SimpleStringProperty(toWhichCurrency);
    }

    public Double getSum() {
        return sum.get();
    }

    public void setSum(Double sum) {
        this.sum = new SimpleDoubleProperty(sum);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }
}
