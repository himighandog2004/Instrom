package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DashboardController implements Initializable {
    @FXML
    private Pane whatsNew;
    private Pane onSale;
    
    @FXML
    private void switchToCart() throws IOException{
        App.changeStage("Cart", "My Cart", 980, 588);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Node> children = whatsNew.getChildren();
        for (int i = 0; i < MusicalInstrument.whatsNew.length; i++) {
            
            ObservableList<Node> itemPane = ((Pane) children.get(i)).getChildren();
            for (int j = 0; j < itemPane.size(); j++) {
                ImageView img = (ImageView) itemPane.get(j);
                img.setImage(new Image(MusicalInstrument.whatsNew[i].getImage()));

                Text name = (Text) itemPane.get(++j);
                name.setText(MusicalInstrument.whatsNew[i].getName());

                Text price = (Text) itemPane.get(++j);
                price.setText("₱ " + MusicalInstrument.whatsNew[i].getPrice());
            }
        }
        /*
        for (int i = 0, j = 0; i < children.size(); i++) {            
            if (i % 3 == 0) { // It's an image
                ImageView item = (ImageView) children.get(i);
                item.setImage(new Image(MusicalInstrument.whatsNew[j].getImage()));
            } else {
                i++;
                // It's a text specifically the name of the product
                Text name = (Text) children.get(i);
                name.setText(MusicalInstrument.whatsNew[i % 1].getName());
                i++;
                // Price
                Text price = (Text) children.get(i);
                price.setText("₱ " + MusicalInstrument.whatsNew[i % 2].getPrice());
            }
            j++;
        }
        */
        /*
        for (int i = 0; i < MusicalInstrument.whatsNew.length; i++) {
            ImageView item = (ImageView) children.get(i);
            //item.setStyle("-fx-background-image: url('" + MusicalInstrument.whatsNew[i].getImage() + "'); -fx-background-size: cover; ");
        }
        */
        // Assign images and such
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}