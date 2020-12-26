package com.mycompany.domain.impl;

import com.mycompany.domain.Entity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Admin extends Entity {
    private SimpleLongProperty adminId;
    private SimpleStringProperty name;
    private SimpleStringProperty surname;
    private SimpleStringProperty mobilePhone;
    private SimpleStringProperty login;
    private SimpleStringProperty password;

    public Admin() {
        long currentId = getId();
        setId(currentId++);
    }

    public Admin(String name, String surname, String mobilePhone, String login, String password) {
        long currentId = getId();
        setId(currentId++);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    public Admin(long adminId, String name, String surname, String mobilePhone, String login, String password) {
        long currentId = getId();
        setId(currentId++);
        this.adminId = new  SimpleLongProperty(adminId);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    public long getAdminId() {
        return adminId.get();
    }

    public void setAdminId(long adminId) {
        this.adminId = new SimpleLongProperty(adminId);
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
        return "Admin{" +
                "adminId=" + adminId.get() +
                ", name=" + name.get() +
                ", surname=" + surname.get() +
                ", mobilePhone=" + mobilePhone.get() +
                ", login=" + login.get() +
                ", password=" + password.get() +
                '}';
    }
}
