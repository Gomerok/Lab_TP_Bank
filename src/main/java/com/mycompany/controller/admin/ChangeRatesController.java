package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.ExchangeRates;
import com.mycompany.util.AlertDialog;
import com.mycompany.util.ExchangeRatesInformer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ChangeRatesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button applyButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField usdBuyField;

    @FXML
    private TextField eurBuyField;

    @FXML
    private TextField rubBuyField;

    @FXML
    private TextField rubSellField;

    @FXML
    private TextField eurSellField;

    @FXML
    private TextField usdSellField;

    @FXML
    private RadioButton usdRadioButton;

    @FXML
    private ToggleGroup currency;

    @FXML
    private RadioButton eurRadioButton;

    @FXML
    private RadioButton rubRadioButton;

    @FXML
    private RadioButton sellRadioButton;

    @FXML
    private ToggleGroup operation;

    @FXML
    private RadioButton buyRadioButton;

    @FXML
    private TextField newRateField;

    @FXML
    void initialize() {
        usdBuyField.setDisable(true);
        usdBuyField.setText(ExchangeRates.getInstance().getUsdBuy().toString());
        usdSellField.setDisable(true);
        usdSellField.setText(ExchangeRates.getInstance().getUsdSell().toString());

        eurBuyField.setDisable(true);
        eurBuyField.setText(ExchangeRates.getInstance().getEurBuy().toString());
        eurSellField.setDisable(true);
        eurSellField.setText(ExchangeRates.getInstance().getEurSell().toString());

        rubBuyField.setDisable(true);
        rubBuyField.setText(ExchangeRates.getInstance().getRubBuy().toString());
        rubSellField.setDisable(true);
        rubSellField.setText(ExchangeRates.getInstance().getRubSell().toString());
    }

    @FXML
    private void onApplyButtonClick() {
        applyButton.setOnAction(actionEvent -> {
            if (newRateField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, newRateField.getScene().getWindow(),
                        "Form Error!", "Please enter new limit");
                return;
            }

            RadioButton selectedCurrency = (RadioButton) currency.getSelectedToggle();
            String currencyValue = selectedCurrency.getText();

            RadioButton selectedOperation = (RadioButton) operation.getSelectedToggle();
            String operationValue = selectedOperation.getText();

            setNewRate(currencyValue, operationValue);

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getChangeExchangeRates());
            App.changeScene(actionEvent, loader);
        });
    }

    private void setNewRate(String currencyValue, String operationValue) {
        final String eur = "EUR";
        final String usd = "USD";
        final String rub = "RUB";

        Double rate = Double.parseDouble(newRateField.getText().trim());
        switch (currencyValue) {
            case eur:
                if (operationValue.equals("Buy")) {
                    ExchangeRates.getInstance().setEurBuy(rate);
                } else {
                    ExchangeRates.getInstance().setEurSell(rate);
                }
                break;
            case usd:
                if (operationValue.equals("Buy")) {
                    ExchangeRates.getInstance().setUsdBuy(rate);
                } else {
                    ExchangeRates.getInstance().setUsdSell(rate);
                }
                break;
            case rub:
                if (operationValue.equals("Buy")) {
                    ExchangeRates.getInstance().setRubBuy(rate);
                } else {
                    ExchangeRates.getInstance().setRubSell(rate);
                }
                break;
            default:
                throw new RuntimeException("Unknown exception");
        }

        initialize();
    }

    @FXML
    private void onLoadButtonClick() {
        loadButton.setOnAction(actionEvent -> {
            ExchangeRatesInformer.EXCHANGE_RATES_INFORMER.interrupt();
            initialize();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getChangeExchangeRates());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu());
            App.changeScene(actionEvent, loader);
        });
    }
}
