package com.mycompany.controller.admin;


import com.mycompany.App;
import com.mycompany.domain.impl.ApplicationProperties;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class ViewOperationController {

    @FXML
    private Button backButton;

    @FXML
    private Button ExchangeOperationHistoryButton;

    @FXML
    private Button MobileOperationHistoryButton;

    @FXML
    void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    void onExchangeOperationHistoryClick() {
        ExchangeOperationHistoryButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getViewOperationHistory());
            App.changeScene(actionEvent, loader);
        });
    }

    @FXML
    void onMobileOperationHistoryClick() {
        MobileOperationHistoryButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getViewMobileOperationHistory());
            App.changeScene(actionEvent, loader);
        });
    }

}
