package com.mycompany.domain.impl;


public class MobilePhoneData {
    private String MobilePhoneField;
    private String NameField;
    private String SurnameField;
    private String SumField;

    private MobilePhoneData() {}

    private static MobilePhoneData payForMobPhone = new MobilePhoneData();

    public static MobilePhoneData getInstance() {
        if (payForMobPhone == null) {
            payForMobPhone = new MobilePhoneData();
        }
        return payForMobPhone;
    }

    public String getNameField() {
        return NameField;
    }
    public void setNameField(String Name) {
        this.NameField = Name;
    }

    public String getSurnameField() {
        return SurnameField;
    }
    public void setSurnameField(String Surname) {
        this.SurnameField = Surname;
    }

    public String getMobilePhoneField() {
        return MobilePhoneField;
    }
    public void setMobilePhoneField(String MobilePhone) {
        this.MobilePhoneField = MobilePhone;
    }

    public String getSumField() {
        return SumField;
    }
    public void setSumField(String Sum) {
        this.SumField = Sum;
    }
}

