package com.mycompany.controller.cashier;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.ExchangeRates;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CashierMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button makeExchangeButton;

    @FXML
    private Button payForTelButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField usdBuyField;

    @FXML
    private TextField usdSellField;

    @FXML
    private TextField eurBuyField;

    @FXML
    private TextField eurSellField;

    @FXML
    private TextField rubBuyField;

    @FXML
    private TextField rubSellField;

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
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAuth());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onPayForTelButtonClick() {
        payForTelButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getPayForMobPhone());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onMakeExchangeButtonClick() {
        makeExchangeButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getChooseCurrency());
            App.changeScene(actionEvent, loader);
        });
    }
}
