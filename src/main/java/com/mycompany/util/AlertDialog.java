package com.mycompany.util;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Window;

public class AlertDialog {
    private AlertDialog() {}

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.initModality(Modality.WINDOW_MODAL);

        alert.showAndWait();
    }
}
