package com.mycompany.instrom.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ItemViewController {
    @FXML
    static ImageView itemImage;
    @FXML
    static Label itemName;
    @FXML
    static Label description;
    @FXML
    static Label category;
    @FXML
    static Label warrantyPeriod;
    
    @FXML
    static Label price;
    
    @FXML
    private void goBack() throws IOException {
        App.changeStage("Dashboard", "Welcome to Instrom", 980, 588);
    }
    
   public static void setImage(String image) {
       itemImage.setImage(new Image(image));
   }
   
   public static void setName(String name) {
       itemName.setText(name);
   }
   
   public static void setDescription(String desc) {
       description.setText(desc);
   }
   
   public static void setCategory(String ctg) {
       category.setText(ctg);
   }
   public static void setWarrantyPeriod(String period) {
       warrantyPeriod.setText(period);
   }
   
   public static void setPrice(String price) {
       
   }
   
}
