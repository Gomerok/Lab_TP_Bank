package sample;

import java.net.URL;
import java.util.ResourceBundle;

import DataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpSurname;

    @FXML
    private TextField SignUpLogin;

    @FXML
    private TextField SignUpPassword;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        SignUpButton.setOnAction(event ->{
            dbHandler.signUpUser(SignUpName.getText(), SignUpSurname.getText()
                    ,SignUpLogin.getText(),SignUpPassword.getText());
        });
    }
}
