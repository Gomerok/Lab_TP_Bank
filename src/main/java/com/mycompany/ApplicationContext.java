package com.mycompany;

import com.mycompany.domain.impl.Cashier;

public class ApplicationContext {
    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContext();
    private Cashier currentCashier;

    private ApplicationContext() {}

    public Cashier getCurrentCashier() {
        return currentCashier;
    }

    public void setCurrentCashier(Cashier currentCashier) {
        this.currentCashier = currentCashier;
    }
}
