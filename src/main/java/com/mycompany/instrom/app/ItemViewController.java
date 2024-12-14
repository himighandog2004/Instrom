package com.mycompany.instrom.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class ItemViewController implements Initializable {
    @FXML
    private ImageView itemImage;
    @FXML
    private Label itemName;
    @FXML
    private Label itemDescription;
    @FXML
    private Label itemBrand;
    @FXML
    private Label itemCategory;
    @FXML
    private Label itemWarrantyPeriod;
    @FXML
    private Label itemPrice;
    @FXML
    private Label itemAdditionalDetails;
    
    public static String image, name, brand, description, category, warrantyPeriod, price, additionalDetails;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ScaleTransition for hover effect
        ScaleTransition scaleUp = new ScaleTransition(Duration.millis(300), itemImage); // 300ms animation
        scaleUp.setToX(1.05);
        scaleUp.setToY(1.05);

        ScaleTransition scaleDown = new ScaleTransition(Duration.millis(300), itemImage); // 300ms animation
        scaleDown.setToX(1.0); // Reset to original size
        scaleDown.setToY(1.0);  
            
        // Add event handlers for hover
        itemImage.setOnMouseEntered(event -> scaleUp.play());
        itemImage.setOnMouseExited(event -> scaleDown.play());
            
        itemImage.setImage(new Image(image));
        itemName.setText(name);
        itemDescription.setText(description);
        itemBrand.setText(brand);
        itemCategory.setText(category);
        itemWarrantyPeriod.setText(warrantyPeriod);
        itemAdditionalDetails.setText(additionalDetails);
        itemPrice.setText(price);
    }    
    
    @FXML
    private void goBack() throws IOException {
        App.changeStage("Dashboard", "Welcome to Instrom", 980, 588);
    }

   public static void setImage(String img) {
       image = img;
   }
   
   public static void setName(String nm) {
       name = nm;
   }
   
   public static void setDescription(String desc) {
       description = desc;
   }
   
   public static void setCategory(String ctg) {
       category = ctg;
   }
   
   public static void setWarrantyPeriod(String period) {
       warrantyPeriod = period;
   }
   
   public static void setPrice(String pr) {
       price = pr;
   }
   
   public static void setBrand(String br) {
       brand = br;
   }
   
   public static void setAdditionalDetails(String details) {
       additionalDetails = details;
   }
   
}
