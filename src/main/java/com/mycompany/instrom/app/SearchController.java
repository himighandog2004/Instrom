package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SearchController implements Initializable {
    public static String searchQuery = "";
    public static ArrayList<MusicalInstrument> searchResults;
    
    @FXML
    private TextField searchBar;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private VBox itemsVBox;
    
    @FXML
    private Label searchResultLabel;
    
    @FXML
    private AnchorPane noResultsPane;
    
    @FXML
    private void switchToCart() throws IOException {
        App.changeStage("Cart", "My Cart", 980, 588);
    }

    @FXML
    private void switchToDashboard() throws IOException{
        App.changeStage("Dashboard", "Welcome to Dashboard!", 980, 588);
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
    public static void switchToSearch() throws IOException {
        // Display results
        if (searchResults.isEmpty()) {
            System.out.println("No instruments found matching the search term: " + SearchController.searchQuery);
        } else {
            System.out.println("Search Results:");
            for (MusicalInstrument instrument : searchResults) {
                System.out.println(" - " + instrument.getId() + " " + instrument.getName());
            }
        }
        App.changeStage("Search", "Search results for: " + searchQuery, 980, 588);
    }
    
    @FXML
    public void search() throws IOException {
        searchQuery = searchBar.getText();
        searchResults = MusicalInstrument.getItemBasedOnName(searchQuery);
        switchToSearch();
    }
    
    
    public HBox[] createHBox(int numberOfPanes) {
        // Create the HBox
        int numberOfHBoxes = (int) Math.ceil((double)numberOfPanes / 4);
        HBox hBox[] = new HBox[numberOfHBoxes];
        
        // Create and add Pane elements
        for (int i = 0; i < numberOfHBoxes; i++) {
            hBox[i] = new HBox();
            hBox[i].setSpacing(20); // Equivalent to Insets right="20.0" for HBox children
            // Add margins for the entire HBox
            VBox.setMargin(hBox[i], new Insets(20, 0, 20, 20)); // bottom, right, top, left
            for (int j = 0; j < 4; j++) {
                int currentPaneIndex = (i * 4) + j;
                if (currentPaneIndex < numberOfPanes) {
                    MusicalInstrument item = searchResults.get(currentPaneIndex);
                    Pane pane = createPane(item.getId(),item.getName(), "₱ " + item.getPrice(), item.getImage());
                    hBox[i].getChildren().add(pane);
                } else {
                    break;
                }
            }
        }
        

        return hBox;
    }
    
    
    private Pane createPane(String id, String name, String price, String image) {
        // Create the Pane
        Pane pane = new Pane();
        pane.setPrefSize(151, 176);
        pane.setStyle("-fx-border-color: black; -fx-border-width: 1;");
        pane.setId(id);
        
        // ScaleTransition for hover effect
        ScaleTransition scaleUp = new ScaleTransition(Duration.millis(300), pane); // 300ms animation
        scaleUp.setToX(1.05);
        scaleUp.setToY(1.05);

        ScaleTransition scaleDown = new ScaleTransition(Duration.millis(300), pane); // 300ms animation
        scaleDown.setToX(1.0); // Reset to original size
        scaleDown.setToY(1.0);  
            
        // Add event handlers for hover
        pane.setOnMouseEntered(event -> scaleUp.play());
        pane.setOnMouseExited(event -> scaleDown.play());
        
        pane.setOnMouseClicked(event -> {
            Pane source = (Pane) event.getSource();
            try {
                MusicalInstrument.displayItem(source.getId());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Create the ImageView
        ImageView imageView = new ImageView();
        imageView.setFitWidth(128);
        imageView.setFitHeight(120);
        imageView.setLayoutX(12);
        imageView.setLayoutY(10);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);

        // Optionally, set an image
        imageView.setImage(new Image(image));

        // Create the first Label
        Label label1 = new Label(name);
        label1.setPrefSize(128, 18);
        label1.setLayoutX(12);
        label1.setLayoutY(130);
        label1.setStyle("-fx-alignment: center;");

        // Create the second Label
        Label label2 = new Label(price);
        label2.setPrefSize(128, 18);
        label2.setLayoutX(12);
        label2.setLayoutY(150);
        label2.setStyle("-fx-alignment: center;");

        // Add children to the Pane
        pane.getChildren().addAll(imageView, label1, label2);

        return pane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBar.setText(searchQuery);
        searchResultLabel.setText(searchQuery);
        if (searchResults.isEmpty()) {
            noResultsPane.setManaged(true);
            noResultsPane.setVisible(true);
            return;
        } else {
            noResultsPane.setManaged(false);
            noResultsPane.setVisible(false);
        }
        HBox items[] = createHBox(searchResults.size());
        /*
        for (int i = 0; i < items.length; i++) {
            itemsVBox.getChildren().add(items[i]);
        }
        */
        
        itemsVBox.getChildren().addAll(items);
    }
}
