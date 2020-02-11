module com.afpa.cruddao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.afpa.cruddao to javafx.fxml;
    exports com.afpa.cruddao;
}