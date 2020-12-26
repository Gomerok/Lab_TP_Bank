package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.domain.impl.ExchangeVolume;
import com.mycompany.util.AlertDialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LimitExchangeVolumeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button applyButton;

    @FXML
    private Button backButton;

    @FXML
    private Button seeLimitVolumesButton;

    @FXML
    private RadioButton usdRadioButton;

    @FXML
    private ToggleGroup currency;

    @FXML
    private RadioButton bynRadioButton;

    @FXML
    private RadioButton rubRadioButton;

    @FXML
    private RadioButton eurRadioButton;

    @FXML
    private TextField newLimitField;

    @FXML
    private RadioButton buyRadioButton;

    @FXML
    private ToggleGroup operation;

    @FXML
    private RadioButton sellRadioButton;

    @FXML
    void initialize() {

    }

    @FXML
    private void onSeeLimitVolumesButtonButtonClick() {
        seeLimitVolumesButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Volume data");
            VBox dialogPaneContent = new VBox();

            HBox hBox1 = new HBox();
            Label label = new Label("usd_buy_volume:");
            Text text = new Text();
            text.setText(ExchangeVolume.EXCHANGE_VOLUME.getUsdBuyVolume().toString());
            hBox1.getChildren().addAll(label, text);

            HBox hBox2 = new HBox();
            Label label2 = new Label("usd_sell_volume:");
            Text text2 = new Text();
            text2.setText(ExchangeVolume.EXCHANGE_VOLUME.getUsdSellVolume().toString());
            hBox2.getChildren().addAll(label2, text2);

            HBox hBox3 = new HBox();
            Label label3 = new Label("eur_buy_volume:");
            Text text3 = new Text();
            text3.setText(ExchangeVolume.EXCHANGE_VOLUME.getEurBuyVolume().toString());
            hBox3.getChildren().addAll(label3, text3);

            HBox hBox4 = new HBox();
            Label label4 = new Label("eur_sell_volume:");
            Text text4 = new Text();
            text4.setText(ExchangeVolume.EXCHANGE_VOLUME.getEurSellVolume().toString());
            hBox4.getChildren().addAll(label4, text4);

            HBox hBox5 = new HBox();
            Label label5 = new Label("rub_buy_volume:");
            Text text5 = new Text();
            text5.setText(ExchangeVolume.EXCHANGE_VOLUME.getRubBuyVolume().toString());
            hBox5.getChildren().addAll(label5, text5);

            HBox hBox6 = new HBox();
            Label lable6 = new Label("rub_sell_volume:");
            Text text6 = new Text();
            text6.setText(ExchangeVolume.EXCHANGE_VOLUME.getRubSellVolume().toString());
            hBox6.getChildren().addAll(lable6, text6);

            HBox hBox7 = new HBox();
            Label label7 = new Label("byn_buy_volume:");
            Text text7 = new Text();
            text7.setText(ExchangeVolume.EXCHANGE_VOLUME.getBynBuyVolume().toString());
            hBox7.getChildren().addAll(label7, text7);

            HBox hBox8 = new HBox();
            Label lable8 = new Label("byn_sell_volume:");
            Text text8 = new Text();
            text8.setText(ExchangeVolume.EXCHANGE_VOLUME.getBynSellVolume().toString());
            hBox8.getChildren().addAll(lable8, text8);

            dialogPaneContent.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5, hBox6, hBox7, hBox8);

            alert.getDialogPane().setContent(dialogPaneContent);
            alert.showAndWait();

            return;
        });
    }

    @FXML
    private void onApplyButtonClick() {
        applyButton.setOnAction(actionEvent -> {
            if (newLimitField.getText().isEmpty()) {
                AlertDialog.showAlert(Alert.AlertType.ERROR, newLimitField.getScene().getWindow(),
                        "Form Error!", "Please enter new limit");
                return;
            }


            RadioButton selectedCurrency = (RadioButton) currency.getSelectedToggle();
            String currencyValue = selectedCurrency.getText();

            RadioButton selectedOperation = (RadioButton) operation.getSelectedToggle();
            String operationValue = selectedOperation.getText();

            setNewVolume(currencyValue, operationValue);

            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getLimitExchangeVolume());
            App.changeScene(actionEvent, loader);
        });
    }

    private void setNewVolume(String currencyValue, String operationValue) {
        final String byn = "BYN";
        final String eur = "EUR";
        final String usd = "USD";
        final String rub = "RUB";

        Double newLimit = Double.parseDouble(newLimitField.getText().trim());
        switch (currencyValue) {
            case byn:
                if (operationValue.equals("Buy")) {
                    ExchangeVolume.EXCHANGE_VOLUME.setBynBuyVolume(newLimit);
                } else {
                    ExchangeVolume.EXCHANGE_VOLUME.setBynSellVolume(newLimit);
                }
                break;
            case eur:
                if (operationValue.equals("Buy")) {
                    ExchangeVolume.EXCHANGE_VOLUME.setEurBuyVolume(newLimit);
                } else {
                    ExchangeVolume.EXCHANGE_VOLUME.setEurSellVolume(newLimit);
                }
                break;
            case usd:
                if (operationValue.equals("Buy")) {
                    ExchangeVolume.EXCHANGE_VOLUME.setUsdBuyVolume(newLimit);
                } else {
                    ExchangeVolume.EXCHANGE_VOLUME.setUsdSellVolume(newLimit);
                }
                break;
            case rub:
                if (operationValue.equals("Buy")) {
                    ExchangeVolume.EXCHANGE_VOLUME.setRubBuyVolume(newLimit);
                } else {
                    ExchangeVolume.EXCHANGE_VOLUME.setRubSellVolume(newLimit);
                }
                break;
            default:
                throw new RuntimeException("Unknown exception");
        }
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu());
            App.changeScene(actionEvent, loader);
        });
    }
}
