package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CashierMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button paytelephon;

    @FXML
    private Button back;

    @FXML
    void initialize() {
        back.setOnAction(event ->{
            back.getScene().getWindow().hide();
            FXMLLoader loader_back = new FXMLLoader();
            loader_back.setLocation(getClass().getResource("/Sample/auth.fxml"));

            try {
                loader_back.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root1 = loader_back.getRoot();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.showAndWait();

        });
        paytelephon.setOnAction(event ->{
            paytelephon.getScene().getWindow().hide();
            FXMLLoader loader_pay = new FXMLLoader();
            loader_pay.setLocation(getClass().getResource("/Cashier/pay_for_mob_phone.fxml"));

            try {
                loader_pay.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root2 = loader_pay.getRoot();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.showAndWait();
        });
    }
}
