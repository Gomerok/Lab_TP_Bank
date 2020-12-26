package com.mycompany.domain.impl;

import com.mycompany.domain.Entity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class MobileOperations extends Entity {
    private SimpleLongProperty mobileOperationId;
    private SimpleStringProperty mobilePhone;
    private SimpleStringProperty clientName;
    private SimpleStringProperty clientSurname;
    private SimpleStringProperty Sum;

    public MobileOperations() {
        long currentId = getId();
        setId(currentId++);
    }

    public MobileOperations(String mobile_phone, String clientName, String clientSurname, String Sum) {
        long currentId = getId();
        setId(currentId++);
        this.mobilePhone = new SimpleStringProperty(mobile_phone);
        this.clientName = new SimpleStringProperty(clientName);
        this.clientSurname = new SimpleStringProperty(clientSurname);
        this.Sum = new SimpleStringProperty(Sum);
    }

    public MobileOperations(Long mobile_operationId, String mobile_phone, String clientName, String clientSurname, String Sum) {
        long currentId = getId();
        setId(currentId++);
        this.mobileOperationId = new SimpleLongProperty(mobile_operationId);
        this.mobilePhone = new SimpleStringProperty(mobile_phone);
        this.clientName = new SimpleStringProperty(clientName);
        this.clientSurname = new SimpleStringProperty(clientSurname);
        this.Sum = new SimpleStringProperty(Sum);
    }

    public long getMobileOperationId() {
        return mobileOperationId.get();
    }

    public void setMobileOperationId(long mobile_operationId) {
        this.mobileOperationId = new SimpleLongProperty(mobile_operationId);
    }

    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String clientName) {
        this.clientName = new SimpleStringProperty(clientName);
    }

    public String getClientSurname() {
        return clientSurname.get();
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = new SimpleStringProperty(clientSurname);
    }

    public String getMobilePhone() {
        return mobilePhone.get();
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = new SimpleStringProperty(mobilePhone);
    }

    public void setSum(String Sum) {
        this.Sum = new SimpleStringProperty(Sum);
    }

    public String getSum() {
        return Sum.get();
    }
}
