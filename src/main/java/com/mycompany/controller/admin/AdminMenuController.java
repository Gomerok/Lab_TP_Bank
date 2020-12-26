package com.mycompany.controller.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button crudCashierButton;

    @FXML
    private Button changeRatesButton;

    @FXML
    private Button limitExchangeVolumeButton;

    @FXML
    private Button viewOperationHistoryButton;

    @FXML
    void initialize() {

    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAuth());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onCrudCashierButtonClick() {
        crudCashierButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onViewOperationHistoryClick() {
        viewOperationHistoryButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getViewOperations());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onChangeRatesClick() {
        changeRatesButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getChangeExchangeRates());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onLimitExchangeVolumeButtonClick() {
        limitExchangeVolumeButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getLimitExchangeVolume());
            App.changeScene(actionEvent, loader);
        });
    }
}
