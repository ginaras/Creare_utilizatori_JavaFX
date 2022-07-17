module com.creare.creare_utilizatori_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.creare.creare_utilizatori_2 to javafx.fxml;
    exports com.creare.creare_utilizatori_2;
}