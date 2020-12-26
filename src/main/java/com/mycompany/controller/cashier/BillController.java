package com.mycompany.controller.cashier;


import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.MobilePhoneData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BillController {

    @FXML
    private TextField PhoneNumberField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField SurnameField;

    @FXML
    private TextField SumField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        PhoneNumberField.setDisable(true);
        PhoneNumberField.setText(MobilePhoneData.getInstance().getMobilePhoneField());

        NameField.setDisable(true);
        NameField.setText(MobilePhoneData.getInstance().getNameField());


        SurnameField.setDisable(true);
        SurnameField.setText(MobilePhoneData.getInstance().getSurnameField());

        SumField.setDisable(true);
        SumField.setText(MobilePhoneData.getInstance().getSumField());
    }

    @FXML
    private void onBackButtonClick() {
        BackButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCashierMenu());
            App.changeScene(actionEvent, loader);
        });
    }
}
