package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
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

public class DashboardController implements Initializable {
    @FXML
    private Pane whatsNew;
    
    @FXML
    private Pane onSale;
    
    @FXML
    private void clickOnItem(MouseEvent event) throws IOException {
         // Retrieve the source node (the Pane that was clicked)
        Pane source = (Pane) event.getSource();
        ObservableList<Node> children = source.getChildren();
        String itemName = ((Label)children.get(1)).getText();
        //TODO:  FIND INSTRUMENT INDEX HMMMM
        MusicalInstrument.displayItem(itemName, );
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fill in the dashboard with new items and items that are on sale
        ObservableList<Node> whatsNewChildren = whatsNew.getChildren();
        ObservableList<Node> onSaleChildren = onSale.getChildren();
        
        for (int i = 0; i < MusicalInstrument.whatsNew.length; i++) {
            ObservableList<Node> itemPane = ((Pane) whatsNewChildren.get(i)).getChildren();
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
            ObservableList<Node> itemPane = ((Pane) onSaleChildren.get(i)).getChildren();
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