package com.mycompany.controller.cashier;



import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.MobileOperationsDAO;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.MobilePhoneData;
import com.mycompany.factory.impl.MobileOperationFactory;
import com.mycompany.util.AlertDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class NextStepToPayMobPhoneController {

    @FXML
    private TextField PhoneNumberField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField SurnameField;

    @FXML
    private Button PrintBillButton;

    @FXML
    private Button TopUpButton;

    @FXML
    private TextField AmountField;

    @FXML
    private Button BackButton;

    private boolean checkIsPayment;

    @FXML
    void initialize() {
        PhoneNumberField.setDisable(true);
        PhoneNumberField.setText(MobilePhoneData.getInstance().getMobilePhoneField());

        NameField.setDisable(true);
        NameField.setText(MobilePhoneData.getInstance().getNameField());


        SurnameField.setDisable(true);
        SurnameField.setText(MobilePhoneData.getInstance().getSurnameField());

    }

    @FXML
    private void onBackButtonClick() {
        BackButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getPayForMobPhone());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    void onPrintBillButtonClick(ActionEvent event) {
        PrintBillButton.setOnAction(actionEvent -> {
            if (!checkIsPayment) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, AmountField.getScene().getWindow(),
                        "Print bill Error!", "Please make a payment first.");
                return;
                }
            else {
                FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getBill());
                App.changeScene(actionEvent, loader);
            }
        });
    }

    @FXML
    void onTopUpButtonClick(ActionEvent event) {
        TopUpButton.setOnAction(actionEvent -> {
            try {
                AbstractDAO abstractDAO = new MobileOperationsDAO();
                String sum = AmountField.getText().trim();

                if (AmountField.getText().isEmpty()) {
                    AlertDialog.showAlert(Alert.AlertType.ERROR, AmountField.getScene().getWindow(),
                            "Form Error!", "Please enter the amount.");
                    return;
                }

                MobilePhoneData.getInstance().setSumField(sum);

                checkIsPayment = abstractDAO.create(MobileOperationFactory.MOBILE_OPERATION_FACTORY.create(PhoneNumberField.getText().trim(),
                        NameField.getText().trim(), SurnameField.getText().trim(), AmountField.getText().trim()));

                if (!checkIsPayment) {
                    return;
                }
                else {
                    AlertDialog.showAlert(Alert.AlertType.INFORMATION, TopUpButton.getScene().getWindow(),
                            "Payment Successful!", "You have just paid " + AmountField.getText() + " byn on your mobile phone.");

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }
}
