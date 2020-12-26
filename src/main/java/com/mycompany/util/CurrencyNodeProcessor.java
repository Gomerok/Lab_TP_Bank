package com.mycompany.util;

import com.mycompany.domain.impl.CurrencyNode;
import com.mycompany.domain.impl.ExchangeRates;
import com.mycompany.exception.InvalidStateException;
import com.mycompany.factory.impl.CurrencyNodeFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyNodeProcessor {
    private CurrencyNodeProcessor() {}

    public static List<CurrencyNode> getCurrencyNodes(List<List<String>> processedXml) {
        List<CurrencyNode> nodes = new ArrayList<>();
        for (int i = 0; i < processedXml.size(); i++) {
            CurrencyNode currencyNode = CurrencyNodeFactory.CURRENCY_NODE_FACTORY.create(Long.parseLong(processedXml.get(i).get(0)),
                    processedXml.get(i).get(1), processedXml.get(i).get(2), processedXml.get(i).get(3),
                    processedXml.get(i).get(4), processedXml.get(i).get(5), processedXml.get(i).get(6),
                    Long.parseLong(processedXml.get(i).get(7)), Long.parseLong(processedXml.get(i).get(8)));
            nodes.add(currencyNode);
        }

        return nodes;
    }

    public static List<CurrencyNode> getNodesByCityAndBank(List<CurrencyNode> nodes, Long cityId, Long bankId) throws InvalidStateException {
        List<CurrencyNode> filteredByCityAndBankNodes = nodes.stream()
                .filter(node -> node.getCityId().equals(cityId) && node.getBankId().equals(bankId))
                .collect(Collectors.toList());

        if (filteredByCityAndBankNodes.isEmpty()) {
            throw new InvalidStateException("Node not found");
        }

        return filteredByCityAndBankNodes;
    }

    public static void setRates(List<CurrencyNode> filteredByCityAndBankNodes) {
        Iterator<CurrencyNode> iterator = filteredByCityAndBankNodes.iterator();
        while (iterator.hasNext()) {
            CurrencyNode nextNode = iterator.next();
            if (nextNode.getCharCode().equals("EUR")) {
                ExchangeRates.getInstance().setEurBuy(Double.parseDouble(nextNode.getRateBuy()));
                ExchangeRates.getInstance().setEurSell(Double.parseDouble(nextNode.getRateSell()));
            }
            if (nextNode.getCharCode().equals("RUB")) {
                ExchangeRates.getInstance().setRubBuy(Double.parseDouble(nextNode.getRateBuy()));
                ExchangeRates.getInstance().setRubSell(Double.parseDouble(nextNode.getRateSell()));
            }
            if (nextNode.getCharCode().equals("USD")) {
                ExchangeRates.getInstance().setUsdBuy(Double.parseDouble(nextNode.getRateBuy()));
                ExchangeRates.getInstance().setUsdSell(Double.parseDouble(nextNode.getRateSell()));
            }
        }
    }
}
