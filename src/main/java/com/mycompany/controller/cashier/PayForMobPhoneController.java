package com.mycompany.controller.cashier;


import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.MobilePhoneData;
import com.mycompany.util.AlertDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PayForMobPhoneController {

    @FXML
    private TextField MobilePhoneField;

    @FXML
    private Button NextButton;

    @FXML
    private TextField NameField;

    @FXML
    private TextField SurnameField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
    }

    @FXML
    private void onBackButtonClick() {
        BackButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    private void onNextButtonClick() {
        NextButton.setOnAction(actionEvent -> {

            if (MobilePhoneField.getText().isEmpty() || NameField.getText().isEmpty() || SurnameField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, NextButton.getScene().getWindow(),
                        "Form Error!", "Please fill in all the fields");
                return;
            }
            else {
                String mobile_phone = MobilePhoneField.getText().trim();
                String name = NameField.getText().trim();
                String surname = SurnameField.getText().trim();

                MobilePhoneData.getInstance().setMobilePhoneField(mobile_phone);
                MobilePhoneData.getInstance().setNameField(name);
                MobilePhoneData.getInstance().setSurnameField(surname);

                FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getNextStepToPayMobPhone());
                App.changeScene(actionEvent, loader);
            }
            });
        }
}
