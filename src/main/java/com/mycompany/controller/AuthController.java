package com.mycompany.controller;

import com.mycompany.App;
import com.mycompany.ApplicationContext;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.Cashier;
import com.mycompany.exception.InvalidStateException;
import com.mycompany.util.AlertDialog;
import com.mycompany.util.IsLoggedChecker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Optional;

public class AuthController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button SignInButton;

    @FXML
    void initialize() {
//        stage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
//            System.out.println("Key pressed: " + event.toString());
//
//            switch(event.getCode().getCode()) {
//                case 27 : { // 27 = ESC key
//                    stage.close();
//                    break;
//                }
//                case 10 : { // 10 = Return
//                    stage.setWidth(stage.getWidth() * 2);
//                }
//                default:  {
//                    System.out.println("Unrecognized key");
//                }
//            }
//        });

    }

    @FXML
    private void onButtonClick() {
        SignInButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            if (loginField.getText().isEmpty() && passwordField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, SignInButton.getScene().getWindow(),
                        "Form Error!", "Please enter a isLogged or password");
                return;
            }

            boolean isLogged = IsLoggedChecker.isLogged(login, password);
            if (isLogged) {
                AlertDialog.showAlert(Alert.AlertType.INFORMATION, SignInButton.getScene().getWindow(),
                        "Registration Successful!", "Welcome " + loginField.getText());

                String resourceName = login.equals("admin") ? ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu()
                        : ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu();

                if (!login.equals("admin")) {
                    placeCashierToApplicationContext(login);
                }

                FXMLLoader loader = App.loadFXML(resourceName);
                App.changeScene(actionEvent, loader);
            } else {
                AlertDialog.showAlert(Alert.AlertType.ERROR, SignInButton.getScene().getWindow(),
                        "Not found!", "Entity not found");
            }
        });
    }

    private void placeCashierToApplicationContext(String login) {
        try {
            CashierDAO cashierDAO = new CashierDAO();
            Optional<Cashier> optionalCashier = cashierDAO.getEntityByLogin(login);
            if (optionalCashier.isEmpty()) {
                throw new RuntimeException("Cashier not found");
            }
            ApplicationContext.APPLICATION_CONTEXT.setCurrentCashier(optionalCashier.get());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
