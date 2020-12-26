package com.mycompany.controller.cashier;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.util.InputDataStorage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ExchangeBillController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField  exSumField;

    @FXML
    private TextField finalSumField;

    @FXML
    private TextField  nameField;

    @FXML
    private TextField  surnameField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        nameField.setDisable(true);
        nameField.setText(InputDataStorage.INPUT_DATA_STORAGE.getName());

        surnameField.setDisable(true);
        surnameField.setText(InputDataStorage.INPUT_DATA_STORAGE.getSurname());


        exSumField.setDisable(true);
        exSumField.setText(String.valueOf(InputDataStorage.INPUT_DATA_STORAGE.getExSum()));

        finalSumField.setDisable(true);
        finalSumField.setText(String.valueOf(InputDataStorage.INPUT_DATA_STORAGE.getFinalSum()));
    }

    @FXML
    private void onBackButtonClick() {
        BackButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu());
            App.changeScene(actionEvent, loader);
        });
    }
}
