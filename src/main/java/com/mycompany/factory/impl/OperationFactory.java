package com.mycompany.factory.impl;

import com.mycompany.ApplicationContext;
import com.mycompany.domain.impl.Operation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationFactory {
    public static final OperationFactory OPERATION_FACTORY = new OperationFactory();
    private final String PATTERN = "yyyy-MM-dd HH:mm";

    private OperationFactory() {}

    public Operation create(String clientName, String buyOrSell, String fromWhichCurrency,
                                   String toWhichCurrency, Double sum, LocalDateTime date) {
        Operation operation = new Operation();

        operation.setCashierName(ApplicationContext.APPLICATION_CONTEXT.getCurrentCashier().getName());
        operation.setClientName(clientName);
        operation.setBuyOrSell(buyOrSell);
        operation.setFromWhichCurrency(fromWhichCurrency);
        operation.setToWhichCurrency(toWhichCurrency);
        operation.setSum(sum);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

        operation.setDate(date.format(formatter));

        return operation;
    }
}
