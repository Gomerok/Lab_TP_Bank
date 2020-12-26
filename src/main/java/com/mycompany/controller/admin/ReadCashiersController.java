package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.CashierDAO;
import com.mycompany.domain.Entity;
import com.mycompany.domain.impl.ApplicationProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReadCashiersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Entity> userTable;

    @FXML
    private TableColumn<Entity, Integer> idCol;

    @FXML
    private TableColumn<Entity, String> mobPhoneCol;

    @FXML
    private TableColumn<Entity, String> nameCol;

    @FXML
    private TableColumn<Entity, String> surnameCol;

    @FXML
    private TableColumn<Entity, String> loginCol;

    @FXML
    private TableColumn<Entity, String> passwordCol;

    @FXML
    void initialize() {
        try {
            AbstractDAO abstractDAO = new CashierDAO();

            ObservableList<Entity> entities = FXCollections.observableArrayList(abstractDAO.getAll());

//            System.out.println("*****************");
//            entities.forEach(System.out::println);

            idCol.setCellValueFactory(new PropertyValueFactory<>("cashierId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
            mobPhoneCol.setCellValueFactory(new PropertyValueFactory<>("mobilePhone"));
            loginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
            passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

            userTable.setItems(entities);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getCrudCashier());
            App.changeScene(actionEvent, loader);
        });
    }
}
