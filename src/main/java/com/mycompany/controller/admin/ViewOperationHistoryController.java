package com.mycompany.controller.admin;

import com.mycompany.App;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.dao.impl.OperationDAO;
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

public class ViewOperationHistoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TableView<Entity> operationHistoryTable;

    @FXML
    private TableColumn<Entity, Integer> idCol;

    @FXML
    private TableColumn<Entity, String> cashierCol;

    @FXML
    private TableColumn<Entity, String> clientCol;

    @FXML
    private TableColumn<Entity, String> buyOrSellCol;

    @FXML
    private TableColumn<Entity, String> fromCol;

    @FXML
    private TableColumn<Entity, String> toCol;

    @FXML
    private TableColumn<Entity, String> sumCol;

    @FXML
    private TableColumn<Entity, String> dateCol;

    @FXML
    void initialize() {
        try {
            AbstractDAO abstractDAO = new OperationDAO();

            ObservableList<Entity> entities = FXCollections.observableArrayList(abstractDAO.getAll());

//            System.out.println("*****************");
//            entities.forEach(System.out::println);

            idCol.setCellValueFactory(new PropertyValueFactory<>("operationId"));
            cashierCol.setCellValueFactory(new PropertyValueFactory<>("cashierName"));
            clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
            buyOrSellCol.setCellValueFactory(new PropertyValueFactory<>("buyOrSell"));
            fromCol.setCellValueFactory(new PropertyValueFactory<>("fromWhichCurrency"));
            toCol.setCellValueFactory(new PropertyValueFactory<>("toWhichCurrency"));
            sumCol.setCellValueFactory(new PropertyValueFactory<>("sum"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

            operationHistoryTable.setItems(entities);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    private void onBackButtonClick() {
        backButton.setOnAction(actionEvent -> {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getClassLoader().getResource(ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu()));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
//
//            Stage stage = new Stage();
//            Parent root = loader.getRoot();
//            stage.setScene(new Scene(root));
//            stage.show();
            FXMLLoader loader = App.loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAdminMenu());
            App.changeScene(actionEvent, loader);
        });
    }
}
