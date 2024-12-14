package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.beans.property.*;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class CartController implements Initializable {
    
    @FXML
    private void switchToDashboard() throws IOException{
        App.changeStage("Dashboard", "Welcome to Dashboard!", 980, 588);
    }
    
    //Connecting FXML to Controllers
    @FXML
    private TableView<MusicalInstrument> cartTableView;
    
    @FXML
    private TableColumn<MusicalInstrument, String> productColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, Double> priceColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, Integer> quantityColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, Double> subtotalColumn;
    
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     
    //private ObservableList<MusicalInstrument> cartList;
    /*
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //Columns
        productColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        priceColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPrice()));
        //Custom cell factory for quantity (adding buttons and textfield inside of each row)
        quantityColumn.setPrefWidth(120);
        quantityColumn.setCellValueFactory(col -> {
            return new TableCell<>(){
                private final HBox buttons = new HBox();
                private final Button plusButton = new Button("+");
                private final Button minusButton = new Button("-");
                private final TextField quantityField = new TextField();
                {
                    //+ and - button listeners
                    plusButton.setOnAction(event -> changeQuantity(1));
                    minusButton.setOnAction(event -> changeQuantity(-1));
                    
                    //textfield
                    quantityField.setMaxWidth(40);
                    quantityField.setText("1");
                    quantityField.textProperty().addListener((observable, oldValue, newValue) -> {
                        //Sets textfield to accept only numbers.
                        if(!newValue.matches("\\d*")){
                            quantityField.setText(newValue.replaceAll("[^\\d]", ""));
                        }
                    });
                    
                    buttons.getChildren().addAll(minusButton, quantityField, plusButton);
                    buttons.setSpacing(5);
                }
                
                @Override
                private void updateItem(Integer quantity, boolean empty){
                    super.updateItem(quantity, empty);
                    if(empty || quantity == null){
                        setGraphic(null);
                    } else {
                        quantityField.setText(String.valueOf(quantity));
                        setGraphic(buttons);
                    }
                }
                
                private void changeQuantity(int change){
                    int index = getIndex();
                    MusicalInstrument item = cartTableView.getItems().get(index);
                    int newQuantity = item.getQuantity() + change;
                    
                    if(newQuantity <= 0){
                        cartTableView.getItems().remove(index);
                    } else {
                        item.setQuantity(newQuantity);
                        quantityField.setText(String.valueOf(newQuantity));
                    }
                }
                
            };
        });
        
        subtotalColumn.setCellValueFactory(cellData -> {
            return Bindings.createDoubleBinding(() ->
                cellData.getValue().getPrice() * cellData.getValue().getQuantity(),
                cellData.getValue().priceProperty(),
                cellData.getValue().quantityProperty());
        });
        
        cartList = FXCollections.observableArrayList(
                new MusicalInstrument("BAT1M Tahoma", "Bromo", "Description", "/image/path", MusicalInstrument.InstrumentCategory.STRINGED, "1 Year", 9000.00, true, 1)   
        );
        cartTableView.setItems(cartList);
    }
    */
}