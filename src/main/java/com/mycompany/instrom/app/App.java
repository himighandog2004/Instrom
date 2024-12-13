package com.mycompany.instrom.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class App extends Application {

    private static Stage primaryStage; // Store a reference to the primary stage
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/images/icon.png")));
        primaryStage.setResizable(false);
        changeStage("Login", "Log in to your Instrom Account", 640, 480);
    }
    
    public static void changeStage(String fxml, String title, int width, int height) throws IOException {
        primaryStage.setTitle(title);
        scene = new Scene(loadFXML(fxml), width, height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}