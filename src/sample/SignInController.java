package sample;


import java.io.IOException;
import java.net.URL;
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
        String insert= "SELECT name FROM terminal.users where (idusers=33)";
        String  NNNN= dbHandler.SelectUser(insert);
        System.out.println(NNNN);
System.out.println(insert);
        SignInButton.setOnAction(actionEvent -> {
           SignInButton.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();

           String name = "admin";
           String pass = "12345678";
           if(login_field.getText().equals(name) && password_field.getText().equals(pass)){
               System.out.println(login_field.getText());
               System.out.println(password_field.getText());
               //FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/Admin/admin_menu.fxml"));

               try {
                   loader.load();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               Parent root = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.showAndWait();
           }else{
               loader.setLocation(getClass().getResource("/Cashier/cashier_menu.fxml"));
               try {
                   loader.load();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               Parent root = loader.getRoot();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.showAndWait();
           }

       });

        SignUpButtonV.setOnAction(Event -> {
            SignInButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Admin/create_cashier.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });


    }
}
