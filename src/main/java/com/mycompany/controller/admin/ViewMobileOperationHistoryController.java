package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.MobileOperationsDAO;
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

public class ViewMobileOperationHistoryController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Entity> mobileOperationHistoryTable;

    @FXML
    private TableColumn<Entity, Integer> idCol;

    @FXML
    private TableColumn<Entity, String> mobile_phoneCol;

    @FXML
    private TableColumn<Entity, String> nameCol;

    @FXML
    private TableColumn<Entity, String> surnameCol;

    @FXML
    private TableColumn<Entity, String> sumCol;


    @FXML
    void initialize() {
        try {
            AbstractDAO abstractDAO = new MobileOperationsDAO();

            ObservableList<Entity> entities = FXCollections.observableArrayList(abstractDAO.getAll());

            idCol.setCellValueFactory(new PropertyValueFactory<>("mobileOperationId"));
            mobile_phoneCol.setCellValueFactory(new PropertyValueFactory<>("mobilePhone"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
            surnameCol.setCellValueFactory(new PropertyValueFactory<>("clientSurname"));
            sumCol.setCellValueFactory(new PropertyValueFactory<>("Sum"));

            mobileOperationHistoryTable.setItems(entities);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getViewOperations());
            App.changeScene(actionEvent, loader);
        });
    }
}
