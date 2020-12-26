package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.util.AlertDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteCashierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField userIdField;

    @FXML
    void initialize() {

    }

    @FXML //here
    private void onDeleteButtonClick() {
        deleteButton.setOnAction(actionEvent -> {
            try {
                AbstractDAO abstractDAO = new CashierDAO();

                if (!validate()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, deleteButton.getScene().getWindow(),
                            "Form Error!", "Please enter correrct id");
                    return;
                }

                Long id = Long.parseLong(userIdField.getText().trim());

                if (id.equals(null)) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, deleteButton.getScene().getWindow(),
                            "Form Error!", "Please enter id");
                    return;
                }

                abstractDAO.delete(id);

                FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
                App.changeScene(actionEvent, loader);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
            App.changeScene(actionEvent, loader);
        });
    }

    private boolean validate() {
        Pattern p;
        Matcher m;

        final String idPattern = "\\d*";
        p = Pattern.compile(idPattern);
        m = p.matcher(userIdField.getText().trim());
        if (!m.matches()) {
            return false;
        }

        return true;
    }
}
