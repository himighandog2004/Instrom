module com.mycompany.instrom.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires fontawesomefx;
    
    opens com.mycompany.instrom.app to javafx.fxml;
    exports com.mycompany.instrom.app;
}
