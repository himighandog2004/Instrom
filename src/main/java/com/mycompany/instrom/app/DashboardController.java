package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class DashboardController implements Initializable {
    @FXML
    private Pane whatsNew;
    
    @FXML
    private Pane onSale;
    
    @FXML
    private TextField searchBar;
    
    @FXML
    private void clickOnItem(MouseEvent event) throws IOException {
        // Retrieve the source node (the Pane that was clicked)
        Pane source = (Pane) event.getSource();
        MusicalInstrument.displayItem(source.getId());
    }
  
    @FXML
    private void switchToCart() throws IOException {
        App.changeStage("Cart", "My Cart", 980, 588);
    }
    
    @FXML
    private void switchToAccount() throws IOException {
        App.changeStage("Account", "Instrom Account", 980, 588);
    }
    
    @FXML
    private void switchToCategories() throws IOException {
        App.changeStage("Categories", "Categories", 980, 588);
    }
    
    @FXML
    private void searchItem() throws IOException {
        SearchController.searchQuery = searchBar.getText();
        SearchController.searchResults = MusicalInstrument.getItemBasedOnName(SearchController.searchQuery);
        SearchController.switchToSearch();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fill in the dashboard with new items and items that are on sale
        ObservableList<Node> whatsNewChildren = whatsNew.getChildren();
        ObservableList<Node> onSaleChildren = onSale.getChildren();
        
        for (int i = 0; i < MusicalInstrument.whatsNew.length; i++) {
            Pane currentPane = (Pane) whatsNewChildren.get(i);
            ObservableList<Node> itemPane = currentPane.getChildren();
            
            // ScaleTransition for hover effect
            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(300), currentPane); // 300ms animation
            scaleUp.setToX(1.05);
            scaleUp.setToY(1.05);

            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(300), currentPane); // 300ms animation
            scaleDown.setToX(1.0); // Reset to original size
            scaleDown.setToY(1.0);  
            
            // Add event handlers for hover
            currentPane.setOnMouseEntered(event -> scaleUp.play());
            currentPane.setOnMouseExited(event -> scaleDown.play());
            
            // Set the Pane's id to the instrument's id...
            currentPane.setId(MusicalInstrument.whatsNew[i].getId());
           
            for (int j = 0; j < itemPane.size(); j++) {
                ImageView img = (ImageView) itemPane.get(j);
                img.setImage(new Image(MusicalInstrument.whatsNew[i].getImage()));

                Label name = (Label) itemPane.get(++j);
                name.setText(MusicalInstrument.whatsNew[i].getName());

                Label price = (Label) itemPane.get(++j);
                price.setText("₱ " + MusicalInstrument.whatsNew[i].getPrice());
            }
        }
        
        for (int i = 0; i < MusicalInstrument.onSale.length; i++) {
            Pane currentPane = (Pane) onSaleChildren.get(i);
            ObservableList<Node> itemPane = currentPane.getChildren();
            
            // ScaleTransition for hover effect
            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(300), currentPane); // 300ms animation
            scaleUp.setToX(1.05); // Scale to 120%
            scaleUp.setToY(1.05);

            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(300), currentPane); // 300ms animation
            scaleDown.setToX(1.0); // Reset to original size
            scaleDown.setToY(1.0);  
            
            // Add event handlers for hover
            currentPane.setOnMouseEntered(event -> scaleUp.play());
            currentPane.setOnMouseExited(event -> scaleDown.play());
            
            // Set the Pane's id to the instrument's id...
            currentPane.setId(MusicalInstrument.onSale[i].getId());
            
            for (int j = 0; j < itemPane.size(); j++) {
                ImageView img = (ImageView) itemPane.get(j);
                img.setImage(new Image(MusicalInstrument.onSale[i].getImage()));

                Label name = (Label) itemPane.get(++j);
                name.setText(MusicalInstrument.onSale[i].getName());

                Label price = (Label) itemPane.get(++j);
                price.setText("₱ " + MusicalInstrument.onSale[i].getPrice());
            }
        }
    }
}