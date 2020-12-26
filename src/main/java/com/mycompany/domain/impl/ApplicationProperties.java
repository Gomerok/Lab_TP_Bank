package com.mycompany.domain.impl;

public enum  ApplicationProperties {
    APPLICATION_PROPERTIES;

    private String adminMenu;
    private String changeExchangeRates;
    private String createCashier;
    private String crudCashier;
    private String deleteCashier;
    private String limitExchangeVolume;
    private String readCashiers;
    private String updateCashier;
    private String viewOperationHistory;

    private String bill;
    private String cashierMenu;
    private String chooseCurrency;
    private String inputClientData;
    private String nextStepToPayMobPhone;
    private String payForMobPhone;

    private String auth;

    public String getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(String adminMenu) {
        this.adminMenu = adminMenu;
    }

    public String getChangeExchangeRates() {
        return changeExchangeRates;
    }

    public void setChangeExchangeRates(String changeExchangeRates) {
        this.changeExchangeRates = changeExchangeRates;
    }

    public String getCreateCashier() {
        return createCashier;
    }

    public void setCreateCashier(String createCashier) {
        this.createCashier = createCashier;
    }

    public String getCrudCashier() {
        return crudCashier;
    }

    public void setCrudCashier(String crudCashier) {
        this.crudCashier = crudCashier;
    }

    public String getDeleteCashier() {
        return deleteCashier;
    }

    public void setDeleteCashier(String deleteCashier) {
        this.deleteCashier = deleteCashier;
    }

    public String getLimitExchangeVolume() {
        return limitExchangeVolume;
    }

    public void setLimitExchangeVolume(String limitExchangeVolume) {
        this.limitExchangeVolume = limitExchangeVolume;
    }

    public String getReadCashiers() {
        return readCashiers;
    }

    public void setReadCashiers(String readCashiers) {
        this.readCashiers = readCashiers;
    }

    public String getUpdateCashier() {
        return updateCashier;
    }

    public void setUpdateCashier(String updateCashier) {
        this.updateCashier = updateCashier;
    }

    public String getViewOperationHistory() {
        return viewOperationHistory;
    }

    public void setViewOperationHistory(String viewOperationHistory) {
        this.viewOperationHistory = viewOperationHistory;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getCashierMenu() {
        return cashierMenu;
    }

    public void setCashierMenu(String cashierMenu) {
        this.cashierMenu = cashierMenu;
    }

    public String getChooseCurrency() {
        return chooseCurrency;
    }

    public void setChooseCurrency(String chooseCurrency) {
        this.chooseCurrency = chooseCurrency;
    }

    public String getInputClientData() {
        return inputClientData;
    }

    public void setInputClientData(String inputClientData) {
        this.inputClientData = inputClientData;
    }

    public String getNextStepToPayMobPhone() {
        return nextStepToPayMobPhone;
    }

    public void setNextStepToPayMobPhone(String nextStepToPayMobPhone) {
        this.nextStepToPayMobPhone = nextStepToPayMobPhone;
    }

    public String getPayForMobPhone() {
        return payForMobPhone;
    }

    public void setPayForMobPhone(String payForMobPhone) {
        this.payForMobPhone = payForMobPhone;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
