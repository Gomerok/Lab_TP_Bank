package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.Cashier;
import com.mycompany.util.AlertDialog;
import com.mycompany.util.IsLoggedChecker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateCashierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField mobilePhoneField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void initialize() {


    }

    @FXML
    private void onRegisterButtonClick() {
        registerButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if (loginField.getText().isEmpty() || passwordField.getText().isEmpty()
                || mobilePhoneField.getText().isEmpty() || loginField.getText().isEmpty()
                || passwordField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, registerButton.getScene().getWindow(),
                        "Form Error!", "Please enter full information");
                return;
            }

            boolean isAlreadyLoggedLogged = IsLoggedChecker.isLogged(login, password);
            if (isAlreadyLoggedLogged) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, registerButton.getScene().getWindow(),
                        "Form Error!", "Please enter a isLogged or password");
                return;
            }

            register();

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCreateCashier());
            App.changeScene(actionEvent, loader);
        });
    }

    private void register() {
        String name = nameField.getText().trim();
        String surname = surnameField.getText().trim();
        String mobilePhone = mobilePhoneField.getText().trim();
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        AbstractDAO abstractDAO = null;
        try {
            abstractDAO = new CashierDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        abstractDAO.create(new Cashier(name, surname, mobilePhone, login, password ));
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
            App.changeScene(actionEvent, loader);
        });
    }
}
