package com.mycompany.controller.cashier;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.ExchangeRates;
import com.mycompany.domain.impl.ExchangeVolume;
import com.mycompany.util.AlertDialog;
import com.mycompany.util.CurrencyConverter;
import com.mycompany.util.InputDataStorage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.util.regex.Pattern;

import java.net.URL;
import java.util.ResourceBundle;


public class ChooseCurrencyController {
    private static final String BYN = "BYN";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String RUB = "RUB";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton usdRadioButton2;

    @FXML
    private ToggleGroup Currency;

    @FXML
    private RadioButton eurRadioButton2;

    @FXML
    private ToggleGroup currencyToExchange;

    @FXML
    private RadioButton bynRadioButton2;

    @FXML
    private RadioButton rubRadioButton2;

    @FXML
    private RadioButton usdRadioButton;

    @FXML
    private ToggleGroup currencyToBeExchanged;

    @FXML
    private RadioButton eurRadioButton;

    @FXML
    private ToggleGroup Currency1;

    @FXML
    private RadioButton rubRadioButton;

    @FXML
    private RadioButton bynRadioButton;

    @FXML
    private ToggleGroup Currency2;

    @FXML
    private RadioButton buyRadioButton1;

    @FXML
    private ToggleGroup operation;

    @FXML
    private RadioButton sellRadioButton1;


    @FXML
    private TextField inputField;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {

    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onSubmitButtonClick() {
        submitButton.setOnAction(actionEvent -> {
            if (inputField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Please enter new limit");
                return;
            }


            RadioButton selectedCurrencyFrom = (RadioButton) currencyToBeExchanged.getSelectedToggle();
            String currencyValueFrom = selectedCurrencyFrom.getText();

            RadioButton selectedCurrencyTo = (RadioButton) currencyToExchange.getSelectedToggle();
            String currencyValueTo = selectedCurrencyTo.getText();

            if (currencyValueFrom.equals(currencyValueTo)) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Currencies cannot be equal");
                return;
            }

            if (Pattern.matches(("\\D"),inputField.getText().trim())) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Please Check the entered data");
                return;
            }

            RadioButton selectedOperation = (RadioButton) operation.getSelectedToggle();
            String operationValue = selectedOperation.getText();

            if (currencyValueFrom.equals("BYN") && ExchangeVolume.EXCHANGE_VOLUME.getBynBuyVolume() < CurrencyConverter.BYN_SELL_VOLUME + Double.valueOf(inputField.getText().trim())) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Exceeding the limit 'BYN'");
                return;
            }

            if (currencyValueFrom.equals("USD") && ExchangeVolume.EXCHANGE_VOLUME.getBynBuyVolume() < CurrencyConverter.USD_SELL_VOLUME + Double.valueOf(inputField.getText().trim())) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Exceeding the limit 'USD'");
                return;
            }

            if (currencyValueFrom.equals("EUR") && ExchangeVolume.EXCHANGE_VOLUME.getBynBuyVolume() < CurrencyConverter.EUR_SELL_VOLUME + Double.valueOf(inputField.getText().trim())) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Exceeding the limit 'EUR'");
                return;
            }

            if (currencyValueFrom.equals("RUB") && ExchangeVolume.EXCHANGE_VOLUME.getBynBuyVolume() < CurrencyConverter.RUB_SEll_VOLUME + Double.valueOf(inputField.getText().trim())) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
                        "Form Error!", "Exceeding the limit 'RUB'");
                return;
            }



            InputDataStorage.INPUT_DATA_STORAGE.setCurrencyValueFrom(currencyValueFrom);
            InputDataStorage.INPUT_DATA_STORAGE.setCurrencyValueTo(currencyValueTo);
            InputDataStorage.INPUT_DATA_STORAGE.setSum(inputField.getText().trim());
            InputDataStorage.INPUT_DATA_STORAGE.setBuyOrSellOperation(operationValue);

            makeExchange(currencyValueFrom, currencyValueTo, inputField.getText().trim());

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getInputClientData());
            App.changeScene(actionEvent, loader);
        });
    }

    private void makeExchange(String currencyValueFrom, String currencyValueTo, String sum) {


        ///////// BYN
        if (currencyValueFrom.equals("BYN") && currencyValueTo.equals("USD")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromBynToUsd(sum);
        }

        if (currencyValueFrom.equals("BYN") && currencyValueTo.equals("EUR")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromBynToEuro(sum);
        }

        if (currencyValueFrom.equals("BYN") && currencyValueTo.equals("RUB")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromBynToRub(sum);
        }
        ///////// USD
        if (currencyValueFrom.equals("USD") && currencyValueTo.equals("BYN")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromUsdToByn(sum);
        }

        if (currencyValueFrom.equals("USD") && currencyValueTo.equals("EUR")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromUsdToEuro(sum);
        }

        if (currencyValueFrom.equals("USD") && currencyValueTo.equals("RUB")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromUsdToRub(sum);
        }
        ///////// EUR
        if (currencyValueFrom.equals("EUR") && currencyValueTo.equals("BYN")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromEuroToByn(sum);
        }

        if (currencyValueFrom.equals("EUR") && currencyValueTo.equals("USD")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromEuroToUsd(sum);
        }

        if (currencyValueFrom.equals("EUR") && currencyValueTo.equals("RUB")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromEuroToRub(sum);
        }
        ///////// RUB
        if (currencyValueFrom.equals("RUB") && currencyValueTo.equals("BYN")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromRubToByn(sum);
        }

        if (currencyValueFrom.equals("RUB") && currencyValueTo.equals("EUR")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromRubToEuro(sum);
        }

        if (currencyValueFrom.equals("RUB") && currencyValueTo.equals("USD")) {
            CurrencyConverter Operation = new CurrencyConverter();
            Double TransferSum = Operation.convertFromRubToUsd(sum);
        }

    }
}

////        ExchangeVolume.EXCHANGE_VOLUME.
//        throw new UnsupportedOperationException();
