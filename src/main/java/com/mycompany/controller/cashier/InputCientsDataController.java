package com.mycompany.controller.cashier;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.OperationDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.Operation;
import com.mycompany.factory.impl.OperationFactory;
import com.mycompany.util.AlertDialog;
import com.mycompany.util.InputDataStorage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class InputCientsDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField clientNameField;

    @FXML
    private TextField clientSurnameField;

    @FXML
    void initialize() {

    }

    @FXML
    private void onSubmitButtonClick() {
        submitButton.setOnAction(actionEvent -> {
//            if (inputField.getText().isEmpty()) {
//                AlertDialog.showAlert(Alert.AlertType.ERROR, inputField.getScene().getWindow(),
//                        "Form Error!", "Please enter new limit");
//                return;
//            }
//
//            RadioButton selectedCurrencyFrom = (RadioButton) currencyToBeExchanged.getSelectedToggle();
//            String currencyValueFrom = selectedCurrencyFrom.getText();
//
//            RadioButton selectedCurrencyTo = (RadioButton) currencyToExchange.getSelectedToggle();
//            String currencyValueTo = selectedCurrencyTo.getText();


            try {
                AbstractDAO abstractDAO = new OperationDAO();

                if (clientNameField.equals(null) || clientNameField.getText().isEmpty()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, clientNameField.getScene().getWindow(),
                            "Form Error!", "Please enter correct clients' name");
                    return;
                }

                if (clientSurnameField.equals(null) || clientSurnameField.getText().isEmpty()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, clientNameField.getScene().getWindow(),
                            "Form Error!", "Please enter correct clients' surname");
                    return;
                }

                abstractDAO.create(OperationFactory.OPERATION_FACTORY.create(clientNameField.getText().trim() + " " +
                        clientSurnameField.getText().trim(), InputDataStorage.INPUT_DATA_STORAGE.getBuyOrSellOperation(),
                        InputDataStorage.INPUT_DATA_STORAGE.getCurrencyValueFrom(), InputDataStorage.INPUT_DATA_STORAGE.getCurrencyValueTo(),
                        Double.parseDouble(InputDataStorage.INPUT_DATA_STORAGE.getSum()), LocalDateTime.now()));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getChooseCurrency());
            App.changeScene(actionEvent, loader);
        });
    }
}


