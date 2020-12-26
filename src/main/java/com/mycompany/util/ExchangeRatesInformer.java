package com.mycompany.util;

import com.mycompany.domain.impl.CurrencyNode;
import com.mycompany.exception.InvalidStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExchangeRatesInformer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeRatesInformer.class);

    public static final ExchangeRatesInformer EXCHANGE_RATES_INFORMER = new ExchangeRatesInformer();

    private ExchangeRatesInformer() {
        super("ExchangeRatesInformer");
    }

    private static final Long CITY_ID = 288831L;
    private static final Long BANK_ID = 13999L;
    private static final String URL = "https://belapb.by/CashExRatesDaily.php?ondate=11/21/2020";

    @Override
    public void run() {
        while (!isInterrupted()) {
            String xmlString = BankDataRequest.getXmlString(URL);

            List<List<String>> processedXml = null;
            try {
                processedXml = BankDataProcessor.processData(xmlString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<CurrencyNode> nodes = CurrencyNodeProcessor.getCurrencyNodes(processedXml);
//        nodes.forEach(System.out::println);
//        System.out.println("********************************\n\n");

            try {
                List<CurrencyNode> filteredNodes = CurrencyNodeProcessor.getNodesByCityAndBank(nodes, CITY_ID, BANK_ID);
//            filteredNodes.forEach(System.out::println);

                CurrencyNodeProcessor.setRates(filteredNodes);
//            System.out.println(exchangeRates);
            } catch (InvalidStateException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ExchangeRatesInformer().start();
    }
}

