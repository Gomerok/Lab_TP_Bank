module com.mycompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.slf4j;
    requires java.net.http;

    opens com.mycompany to javafx.fxml;
    opens com.mycompany.controller to javafx.fxml;
    opens com.mycompany.controller.admin to javafx.fxml;
    opens com.mycompany.controller.cashier to javafx.fxml;
    opens com.mycompany.domain.impl to javafx.base;
    exports com.mycompany;
}