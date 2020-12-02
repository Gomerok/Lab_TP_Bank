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

public class AdminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button CRUDbutton;

    @FXML
    private Button HistoryButton;

    @FXML
    void initialize() {
        System.out.println("sdvsdvsdxv");
        CRUDbutton.setOnAction(actionEvent -> {
            System.out.println("sdvsdvsdxv");
            CRUDbutton.getScene().getWindow().hide();
            FXMLLoader load = new FXMLLoader();
            try {
               load.setLocation(getClass().getResource("/Admin/create_cashier.fxml"));
                load.load();
                Parent roo = load.getRoot();
                Stage stag = new Stage();
                stag.setScene(new Scene(roo));
                stag.showAndWait();
            }catch (IOException e11)
            {
                e11.printStackTrace();
            }



        });

    }
}
