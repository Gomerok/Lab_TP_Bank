package sample;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import DataBase.DatabaseHandler;


public class SignInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button SignUpButtonV;

    @FXML
    private Button SignInButton;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        SignInButton.setOnAction(actionEvent -> {

            String insert = "SELECT name,password FROM terminal.users where (idusers=38)";
            String insert2 = "SELECT name,password FROM terminal.users where (name=?)";

            ArrayList<String> UsePass = new ArrayList<>();
            UsePass = dbHandler.SelectUser(insert, 1, null);

            String Pass = UsePass.get(1);
            String Name = UsePass.get(0);

            SignInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            try {
                if (login_field.getText().equals(Name) && password_field.getText().equals(Pass)) {
                    loader.setLocation(getClass().getResource("/Admin/admin_menu.fxml"));

                    loader.load();

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } else {
                    ArrayList<String> rew = new ArrayList<>();
                    rew = dbHandler.SelectUser(insert2, 2, login_field.getText());
                    String Name1 = rew.get(0);
                    String Pass1 = rew.get(1);
                    if (login_field.getText().equals(Name1) && password_field.getText().equals(Pass1)) {
                        loader.setLocation(getClass().getResource("/Cashier/cashier_menu.fxml"));
                    }

                    loader.load();

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//        SignUpButtonV.setOnAction(Event -> {
//            SignInButton.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/Admin/create_cashier.fxml"));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//
//        });


    }
}
