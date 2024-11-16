module com.mycompany.instrom {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.instrom to javafx.fxml;
    exports com.mycompany.instrom;
}
