package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;


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
    @FXML
    private TextField quantityField;
    @FXML
    private Button decrementButton;
    @FXML
    private Button incrementButton;
    @FXML
    private Button viewCartButton;
    @FXML
    private Button addToCartButton;
    @FXML
    private Text itemAvailabilityNote;
    
    public static String additionalDetails;
    public static MusicalInstrument instrument;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // First check if item is available
        if (!instrument.getAvailability()) {
            decrementButton.setDisable(true);
            incrementButton.setDisable(true);
            quantityField.setDisable(true);
            viewCartButton.setDisable(true);
            addToCartButton.setDisable(true);
            itemAvailabilityNote.setVisible(true);
            itemAvailabilityNote.setManaged(true);
        } else {
            itemAvailabilityNote.setVisible(false);
            itemAvailabilityNote.setManaged(false);
        }
        // Add a listener to allow only integers in the quantity field
        quantityField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) { // Regex: \d* allows digits only
                quantityField.setText(newValue.replaceAll("[^\\d]", "")); // Replace non-digits
            }
        });
        
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
 
        itemImage.setImage(new Image(instrument.getImage()));
        itemName.setText(instrument.getName());
        itemDescription.setText(instrument.getDescription());
        itemBrand.setText(instrument.getBrand());
        itemCategory.setText(instrument.getCategory().name());
        itemWarrantyPeriod.setText(instrument.getWarrantyPeriod());
        itemAdditionalDetails.setText(additionalDetails);
        itemPrice.setText("₱ " + instrument.getPrice());      
    }    
    
    @FXML
    private void goBack() throws IOException {
        App.changeStage("Dashboard", "Welcome to Instrom", 980, 588);
    }
    
    @FXML
    private void decrementQuantity() {
        try {
            int currentValue = Integer.parseInt(quantityField.getText());
            if (currentValue > 1) { // Prevent going below 1
                quantityField.setText(String.valueOf(currentValue - 1));
            }
        } catch (NumberFormatException e) {
            quantityField.setText("1"); // Reset to "1" if invalid
        }
    }
    
    @FXML
    private void incrementQuantity() throws IOException {
        int qty = Integer.parseInt(quantityField.getText());
        quantityField.setText("" + (qty + 1));
    }
    
    @FXML
    private void switchToCart() throws IOException {
        App.changeStage("Cart", "My Cart", 980, 588);
    }
    
    @FXML
    private void addItemToCart() throws IOException {
        // First get the quantity
        int qty = Integer.parseInt(quantityField.getText());
        int currentItemQuantity = instrument.getQuantity();
        // Validate
        if (qty > currentItemQuantity) {
            JOptionPane.showMessageDialog(null, "Unable to add item! There's " + currentItemQuantity + " item(s) remaining in stock.");
            return;
        }
        // Proceed to add the item to the cart
        if (!MusicalInstrument.cart.contains(instrument)) {
            MusicalInstrument.cart.add(instrument);
        }
        
        instrument.setQuantity(currentItemQuantity - qty);
        System.out.println("The item now has: " + instrument.getQuantity());
        
        JOptionPane.showMessageDialog(null, "Successfully added the item to the cart!");
    }

    public static void setAdditionalDetails(String details) {
        additionalDetails = details;
    } 
}
