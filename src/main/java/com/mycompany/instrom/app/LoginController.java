package com.mycompany.instrom.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {
    private final String email = "admin@gmail.com";
    private final String password = "password";
    private int attempts = 4;
    private final String slideImgs[] = {
        "/assets/images/guitar0.jpg",
        "/assets/images/guitar1.jpg",
        "/assets/images/violin0.jpg",
        "/assets/images/saxophone0.jpg",
        "/assets/images/drums0.jpg"
        
    };
    private int imageIndexCount = 0;
    
    @FXML
    private TextField userInput;
    
    @FXML
    private PasswordField userPass;
    
    @FXML
    private AnchorPane loginImage;
    
    @FXML
    private Rectangle rect;
    
    @FXML
    private Text userAttempt;
    
    @FXML
    private void Login() throws IOException {
        // Validate login here and then proceed to home/dashboard
        String userEmail = userInput.getText();
        String userPassword = userPass.getText();
        if(userEmail.equals(email) && userPassword.equals(password)){            
            App.changeStage("Dashboard", "Welcome to Instrom", 980, 588);
        } else {
            attempts--;
            userAttempt.setText("Attempts remaining: " + attempts);
            if(attempts == 0){
                JOptionPane.showMessageDialog(null, "All attempts failed. Exiting program...");
                System.exit(0);
            }
        }
        
    }
    
    @FXML
    public void buttonPressed(KeyEvent e) throws IOException
    {
        if(e.getCode().toString().equals("ENTER"))
        {
        Login();
        }
    }
    
    
    private void changeLoginImage() {
        // Note that imageIndex must be in range... so we first check it
       if (imageIndexCount == slideImgs.length) {
           imageIndexCount = 0;
       }
       String imagePath = getClass().getResource(slideImgs[imageIndexCount]).toExternalForm();
       loginImage.setStyle("-fx-background-image: url('" + imagePath + "'); -fx-background-size: cover; ");
       imageIndexCount++;
    }
    
    private void startImageAnimation() {
        changeLoginImage();
        
        Timeline timeline = new Timeline();
        KeyValue transparent = new KeyValue(rect.opacityProperty(), 1.0);
        KeyValue opaque = new KeyValue(rect.opacityProperty(), 0.0);
        
        KeyFrame startFadeIn = new KeyFrame(Duration.ZERO, transparent);
        KeyFrame endFadeIn = new KeyFrame(Duration.millis(1000), opaque);
        KeyFrame startFadeOut = new KeyFrame(Duration.millis(5000), opaque);
        KeyFrame endFadeOut = new KeyFrame(Duration.millis(6000), e-> {
            changeLoginImage();
        }, transparent);

        timeline.getKeyFrames().addAll(startFadeIn, endFadeIn, startFadeOut, endFadeOut);

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startImageAnimation();        
    }
}
