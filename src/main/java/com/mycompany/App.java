package com.mycompany;

import com.mycompany.domain.impl.ApplicationProperties;
import com.mycompany.util.ExchangeRatesInformer;
import com.mycompany.util.PropertyReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
//public class App extends Application {
//
//    private static Scene scene;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"));
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//}
//
//public class App extends Application {
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("src/main/resources/com.mycompany.auth.fxml"));
//
//        stage.setTitle("My Application");
//        stage.setScene(new Scene(root));
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//}

public class App extends Application {

    @Override
    public void start(Stage stage) {
        PropertyReader.loadProperties();
        PropertyReader.readProperties();

        ExchangeRatesInformer.EXCHANGE_RATES_INFORMER.setDaemon(true);
        ExchangeRatesInformer.EXCHANGE_RATES_INFORMER.start();

        stage.setTitle("DMT Terminal");

        FXMLLoader loader = loadFXML(ApplicationProperties.APPLICATION_PROPERTIES.getAuth());
        Scene scene = new Scene(loader.getRoot());
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();
    }

    public static FXMLLoader loadFXML(String fxml)  {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(fxml + ".fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loader;
    }

    public static void changeScene(ActionEvent actionEvent, FXMLLoader loader) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));

        stage.setResizable(false);

        stage.show();
    }

//    public static void main(String[] args) {
//        launch();
//    }

}