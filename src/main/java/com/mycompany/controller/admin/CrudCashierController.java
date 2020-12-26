package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class CrudCashierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button updateCashierInfoButton;

    @FXML
    private Button deleteCashierButton;

    @FXML
    private Button viewAllCashiersButton;

    @FXML
    private Button createCashierButton;

    @FXML
    void initialize() {
    }

    @FXML
    private void onUpdateCashierInfoButtonClick() {
        updateCashierInfoButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getUpdateCashier());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onDeleteCashierButtonClick() {
        deleteCashierButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getDeleteCashier());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onViewAllCashiersButtonClick() {
        viewAllCashiersButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getReadCashiers());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onCreateCashierButtonClick() {
        createCashierButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCreateCashier());
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
