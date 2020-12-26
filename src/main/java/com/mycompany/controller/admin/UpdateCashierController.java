package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.Cashier;
import com.mycompany.util.AlertDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class UpdateCashierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField mobPhoneField;

    @FXML
    private TextField userIdField;

    @FXML
    void initialize() {

    }

    @FXML//here
    private void onUpdateButtonClick() {
        updateButton.setOnAction(actionEvent ->  {
            try {
                AbstractDAO abstractDAO = new CashierDAO();
                // validate empty string case
                Long id = Long.parseLong(userIdField.getText().trim());

                if (id.equals(null) || id <= 0) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, updateButton.getScene().getWindow(),
                            "Form Error!", "Please enter correct id");
                    return;
                }

                Optional<Cashier> optionalCashier = abstractDAO.getEntityById(id);
                if (optionalCashier.isEmpty()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, updateButton.getScene().getWindow(),
                            "Not found!", "Entity not found");
                    return;
                }

                String mobilePhone = mobPhoneField.getText().trim();
                String login = loginField.getText().trim();
                String password = passwordField.getText().trim();

                if (mobilePhone.isEmpty() && login.isEmpty() && password.isEmpty()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, updateButton.getScene().getWindow(),
                            "Form Error!", "Please enter any update data");
                    return;
                }


                if (!login.isEmpty()) {
                    optionalCashier.get().setMobilePhone(mobilePhone);
                }

                if (!login.isEmpty()) {
                    optionalCashier.get().setLogin(login);
                }

                if (!password.isEmpty()) {
                    optionalCashier.get().setPassword(password);
                }

                abstractDAO.update(optionalCashier.get());

                FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getUpdateCashier());
                App.changeScene(actionEvent, loader);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier()));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
//
//            Stage stage = new Stage();
//            Parent root = loader.getRoot();
//            stage.setScene(new Scene(root));
//            stage.show();
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
            App.changeScene(actionEvent, loader);
        });
    }
}
