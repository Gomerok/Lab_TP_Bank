package com.mycompany.domain.impl;

import com.mycompany.domain.Entity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cashier extends Entity {
    private SimpleLongProperty cashierId;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty mobilePhone;
    private SimpleStringProperty login;
    private SimpleStringProperty password;

    public Cashier() {
        long currentId = getId();
        setId(currentId++);
    }

    public Cashier(String name, String surname, String mobilePhone, String login, String password) {
        long currentId = getId();
        setId(currentId++);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    public Cashier(Long userId, String name, String surname, String mobilePhone, String login, String password) {
        long currentId = getId();
        setId(currentId++);
        this.cashierId = new  SimpleLongProperty(userId);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    public long getCashierId() {
        return cashierId.get();
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = new SimpleLongProperty(cashierId);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname = new SimpleStringProperty(surname);
    }

    public String getMobilePhone() {
        return mobilePhone.get();
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login = new SimpleStringProperty(login);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "cashierId=" + cashierId.get() +
                ", name=" + name.get() +
                ", surname=" + surname.get() +
                ", mobilePhone=" + mobilePhone.get() +
                ", login=" + login.get() +
                ", password=" + password.get() +
                '}';
    }
}
