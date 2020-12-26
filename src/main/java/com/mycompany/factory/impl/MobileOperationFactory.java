package com.mycompany.factory.impl;

import com.mycompany.domain.impl.MobileOperations;


public class MobileOperationFactory {
    public static final MobileOperationFactory MOBILE_OPERATION_FACTORY = new MobileOperationFactory();

    private MobileOperationFactory() {}

    public MobileOperations create(String mobile_phone, String clientName, String clientSurname, String Sum) {
        MobileOperations mobOperation = new MobileOperations();

        mobOperation.setMobilePhone(mobile_phone);
        mobOperation.setClientName(clientName);
        mobOperation.setClientSurname(clientSurname);
        mobOperation.setSum(Sum);

        return mobOperation;
    }

    public MobileOperations create(long id, String mobile_phone, String ClientName, String ClientSurname, String Sum) {
        MobileOperations mobOperation = new MobileOperations();

        mobOperation.setMobileOperationId(id);
        mobOperation.setMobilePhone(mobile_phone);
        mobOperation.setClientName(ClientName);
        mobOperation.setClientSurname(ClientSurname);
        mobOperation.setSum(Sum);

        return mobOperation;
    }
}