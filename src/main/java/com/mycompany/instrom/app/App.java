package com.mycompany.instrom.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/images/icon.png")));
        stage.setTitle("Log in to your Instrom Account");
        scene = new Scene(loadFXML("Login"), 640, 480);
        stage.setScene(scene);  
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    // TODO: How to change stage or scene?
    /*
    https://stackoverflow.com/questions/33932309/how-to-access-a-javafx-stage-from-a-controller
    static void changeScene(String fxmlName, int width, int height) throws IOException {
        scene = new Scene(loadFXML(fxmlName), width, height);
    }
    */

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}