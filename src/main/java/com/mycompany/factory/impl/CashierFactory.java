package com.mycompany.factory.impl;

import com.mycompany.domain.impl.Cashier;

public class CashierFactory {
    public static final CashierFactory CASHIER_FACTORY = new CashierFactory();

    private CashierFactory() {}

    public Cashier create(Long id, String name, String surname, String mobPhone, String login, String password) {
        Cashier cashier = new Cashier();

        cashier.setCashierId(id);
        cashier.setName(name);
        cashier.setSurname(surname);
        cashier.setMobilePhone(mobPhone);
        cashier.setLogin(login);
        cashier.setPassword(password);

        return cashier;
    }

    public Cashier create(String name, String surname, String mobPhone, String login, String password) {
        Cashier cashier = new Cashier();

        cashier.setName(name);
        cashier.setSurname(surname);
        cashier.setMobilePhone(mobPhone);
        cashier.setLogin(login);
        cashier.setPassword(password);

        return cashier;
    }
}
