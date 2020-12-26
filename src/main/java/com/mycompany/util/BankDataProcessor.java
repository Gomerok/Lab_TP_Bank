package com.mycompany.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BankDataProcessor {
    private BankDataProcessor() {}

    public static List<List<String>> processData(String xmlString) throws Exception {
        Document document = getDocument(xmlString);

        Node root = document.getDocumentElement();
        NodeList listOfCurrencies = root.getChildNodes();

        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < listOfCurrencies.getLength(); i++) {
            Node currency = listOfCurrencies.item(i);

            List<String> tempList = new ArrayList<>();

            if (currency.getNodeType() != Node.TEXT_NODE) {
                tempList.add(currency.getAttributes().item(0).getTextContent());
                NodeList currencyInfo = currency.getChildNodes();

                for (int j = 0; j < currencyInfo.getLength(); j++) {
                    Node info = currencyInfo.item(j);

                    if (info.getNodeType() != Node.TEXT_NODE) {
                        tempList.add(info.getChildNodes().item(0).getTextContent());
                    }

                }
                list.add(tempList);
            }
        }

        return list;
    }

    private static Document getDocument(String xmlString) throws Exception {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlString));

            return documentBuilder.parse(is);
        } catch (Exception exception) {
            String message = "XML parsing error!";
            throw new Exception(message);
        }
    }
}
