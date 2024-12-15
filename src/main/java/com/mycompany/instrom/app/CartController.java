package com.mycompany.instrom.app;

import com.mycompany.instrom.MusicalInstrument;
import com.mycompany.instrom.app.AccountController.PaymentMethod;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

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
    private TableColumn<MusicalInstrument, String> priceColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, Integer> quantityColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, String> amountColumn;
    
    @FXML
    private TableColumn<MusicalInstrument, String> itemIdColumn;
    
    // For Receipt details
    @FXML
    private Label date;
    
    @FXML 
    private Label subtotal;
    
    @FXML
    private Label vat;
    
    @FXML
    private ChoiceBox<String> paymentMethod;
    
    @FXML
    private Label grandTotalAmount;
    
    @FXML
    private TextField amountTendered;
    
    @FXML
    private Text amountTenderedLabel;
    
    @FXML
    private Label change;
    
    @FXML
    private Label discount;
    
    @FXML
    private Text changeLabel;
    
    @FXML
    private Button proceedToCheckoutButton;
    
    @FXML
    private Button removeFromCartButton;
    
    @FXML
    private Button viewItemFromStoreButton;
    
    private ObservableList<MusicalInstrument> cartList;
    private PaymentMethod currentPaymentMethodSelected = App.myAccount.getUserPaymentMethod();
    private double sbAmnt = 0.0, gtAmnt = 0.0, vtAmnt = 0.0, dscAmnt = 0.0, chngAmnt;
    
    @FXML
    private void removeSelectedInstrument() {
        // Get the selected item
        MusicalInstrument selectedInstrument = cartTableView.getSelectionModel().getSelectedItem();
        
        if (selectedInstrument != null) {
            // Remove the selected item from the cartList
            cartList.remove(selectedInstrument);
            MusicalInstrument.cart.remove(selectedInstrument);
            selectedInstrument.setQuantity(selectedInstrument.getQuantity() + selectedInstrument.cartQuantity);
            selectedInstrument.cartQuantity = 0;
            // Optionally refresh the TableView (not usually necessary)
            cartTableView.refresh();
            calculateReceipt();
            
            // Print a confirmation message
            System.out.println("Removed: " + selectedInstrument.getName() + ": quantity -> " + selectedInstrument.getQuantity() + ", cartQuantity -> " + selectedInstrument.cartQuantity);
            // Also check if there are no items in the cart...
            if (MusicalInstrument.cart.isEmpty()) {
                proceedToCheckoutButton.setDisable(true);
                viewItemFromStoreButton.setDisable(true);
                removeFromCartButton.setDisable(true);
                changeLabel.setManaged(false);
                changeLabel.setVisible(false);
                change.setManaged(false);
                change.setVisible(false);
            } else {
                proceedToCheckoutButton.setDisable(false);
                viewItemFromStoreButton.setDisable(false);
                removeFromCartButton.setDisable(false);            
                changeLabel.setManaged(true);
                changeLabel.setVisible(true);
                change.setManaged(true);
                change.setVisible(true);
            }
        } else {
            // Show an alert if no item is selected
            JOptionPane.showMessageDialog(null, "No Selection, Please select an item to remove.");
        }
    }

    @FXML
    private void viewItemFromStore() throws IOException {
        // Get the selected item
        MusicalInstrument selectedInstrument = cartTableView.getSelectionModel().getSelectedItem();
        if (selectedInstrument != null) {
            MusicalInstrument.displayItem(selectedInstrument.getId());
        } else {
            JOptionPane.showMessageDialog(null, "No Selection, Please select an item to view.");           
        }
    }
    
    @FXML
    private void proceedToCheckout() throws IOException {
        // Remove items from cart then set each cart quantity to 0, also refresh the balance
        
        App.myAccount.setBalance(currentPaymentMethodSelected, chngAmnt);
        for (MusicalInstrument item : MusicalInstrument.cart) {
            item.cartQuantity = 0;
        }
        //new ArrayList instead of clearing the cart. bc faster.
        MusicalInstrument.cart = new ArrayList<>();
        
        JOptionPane.showMessageDialog(null, "Payment Successful! Thank you for your purchase!");           
        switchToDashboard();
    }
   
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // If there are no items in cart
        if (MusicalInstrument.cart.isEmpty()) {
            proceedToCheckoutButton.setDisable(true);
            viewItemFromStoreButton.setDisable(true);
            removeFromCartButton.setDisable(true);
            changeLabel.setManaged(false);
            changeLabel.setVisible(false);
            change.setManaged(false);
            change.setVisible(false);
        } else {
            proceedToCheckoutButton.setDisable(false);
            viewItemFromStoreButton.setDisable(false);
            removeFromCartButton.setDisable(false);            
            changeLabel.setManaged(true);
            changeLabel.setVisible(true);
            change.setManaged(true);
            change.setVisible(true);
        }
        cartList = FXCollections.observableArrayList(
            MusicalInstrument.cart
        );        
        //Columns
        itemIdColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getId()));
        productColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        priceColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper("₱ " + cellData.getValue().getPrice()));
        // This creates a customized Cell for the quantity column, basically an HBox to modify the quantity
        quantityColumn.setCellFactory(col -> new TableCell<MusicalInstrument, Integer>() {
            private final HBox buttons = new HBox();
            private final Button plusButton = new Button("+");
            private final Button minusButton = new Button("-");
            private final TextField quantityField = new TextField();
            {
                // Button listeners
                plusButton.setOnAction(event -> incrementQuantity());
                minusButton.setOnAction(event -> decrementQuantity());

                // TextField setup
                quantityField.setMaxWidth(40);
                quantityField.setEditable(false);
                quantityField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*")) { // Accept only digits
                        quantityField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
                
                buttons.getChildren().addAll(minusButton, quantityField, plusButton);
                buttons.setSpacing(5);
                buttons.setAlignment(Pos.CENTER);
                
            }

            @Override
            protected void updateItem(Integer quantity, boolean empty) {
                super.updateItem(quantity, empty);

                if (empty || quantity == null) {
                    setGraphic(null);
                } else {
                    quantityField.setText(String.valueOf(quantity));
                    setGraphic(buttons);
                }
            }
            
            private void decrementQuantity() {
                int indexOfItem = getIndex();
                MusicalInstrument currItem = getTableView().getItems().get(indexOfItem);
                try {
                    int currentValue = Integer.parseInt(quantityField.getText());
                    if (currentValue > 1) { // Prevent going below 1
                        quantityField.setText(String.valueOf(currentValue - 1));
                        currItem.cartQuantity -= 1; // For cartQuantity
                        currItem.setQuantity(currItem.getQuantity() + 1); // For stock/quantity
                        System.out.println("The quantity of item is: " + currItem.getQuantity() + " while in cart: " + currItem.cartQuantity);
                        cartTableView.refresh();
                        calculateReceipt();
                        return;
                    }
                    System.out.println("Unable to decrement quantity so its still, quantity: " + currItem.getQuantity() + " and cartQuantity: " + currItem.cartQuantity);
                } catch (NumberFormatException e) {
                    quantityField.setText("1"); // Reset to "1" if invalid
                }
            }
            
            private void incrementQuantity() {
                int indexOfItem = getIndex();
                MusicalInstrument currItem = getTableView().getItems().get(indexOfItem);
                try {
                   int currentValue = Integer.parseInt(quantityField.getText());
                   if (currItem.getQuantity() != 0) {
                        quantityField.setText(String.valueOf(currentValue + 1));
                        currItem.cartQuantity += 1; // For cartQuantity
                        currItem.setQuantity(currItem.getQuantity() - 1); // For stock/quantity
                        System.out.println("The quantity of item is: " + currItem.getQuantity() + " while in cart: " + currItem.cartQuantity);
                        cartTableView.refresh();
                        calculateReceipt();
                        return;
                   }
                   System.out.println("Unable to increment quantity so its still, quantity: " + currItem.getQuantity() + " and cartQuantity: " + currItem.cartQuantity);
                } catch (NumberFormatException e) {
                   quantityField.setText("1");
                }
            }
            
        });

        quantityColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().cartQuantity));
  
        amountColumn.setCellValueFactory(cellData -> {
            double amnt = cellData.getValue().getPrice() * cellData.getValue().cartQuantity;
            return new ReadOnlyStringWrapper("₱ " + amnt);
        });
        
        cartTableView.setItems(cartList);
        cartTableView.setPlaceholder(new Label("No items in cart"));
        
        // Set the date within the receipt
        date.setText(getFormattedDate());
        
        paymentMethod.getItems().addAll(App.myAccount.getBalanceAsString());
        // Add a listener to react to changes in the selected option
        paymentMethod.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            System.out.println("Selected: " + newValue);
            String[] possibleMethods = App.myAccount.getBalanceAsString();
            // If the user picks Cash on Delivery, show the field for amount tendered
            if (paymentMethod.getValue().equals(possibleMethods[0])) { //CC
                currentPaymentMethodSelected = PaymentMethod.CREDIT_CARD;
            } else if (paymentMethod.getValue().equals(possibleMethods[1])) { // GCASH
                currentPaymentMethodSelected = PaymentMethod.GCASH;
            } else if (paymentMethod.getValue().equals(possibleMethods[2])) {
                amountTenderedLabel.setManaged(true);
                amountTenderedLabel.setVisible(true);
                amountTendered.setManaged(true);
                amountTendered.setVisible(true);
                currentPaymentMethodSelected = PaymentMethod.CASH_ON_DELIVERY;
                calculateChange();
                return;
            }
            
            amountTenderedLabel.setManaged(false);
            amountTenderedLabel.setVisible(false);
            amountTendered.setManaged(false);
            amountTendered.setVisible(false);
            calculateChange();
        });
        paymentMethod.setValue(App.myAccount.getUserPaymentMethodAsString());
        
        amountTendered.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) { // Accept only digits
                amountTendered.setText(newValue.replaceAll("[^\\d]", ""));
            }
            calculateChange();
        });
        
        calculateReceipt();
    }
    
    public void calculateReceipt() {
        // Reset the values just in case
        sbAmnt = 0.0; gtAmnt = 0.0; vtAmnt = 0.0; dscAmnt = 0.0; chngAmnt = 0.0;
        // Loop over the cart to calculate the subAmount;
        for (MusicalInstrument item : MusicalInstrument.cart) {
            sbAmnt += item.getPrice() * item.cartQuantity;
        }
        
        // For receipt details, calculate vat, discount, and grand total
        vtAmnt = sbAmnt * 0.12;
        dscAmnt = (sbAmnt + vtAmnt) * 0.20;
        gtAmnt = (sbAmnt + vtAmnt) - dscAmnt;
        calculateChange();
                
        subtotal.setText("₱ " + round(sbAmnt));
        vat.setText("₱ " + round(vtAmnt));
        discount.setText(App.myAccount.getIsPwdOrSenior() ? String.valueOf("₱ " + round(dscAmnt)) : "N/A");
        grandTotalAmount.setText("₱ " + round(gtAmnt));
        

    }

    public void calculateChange() {
        // If payment method is not COD
        if (!paymentMethod.getValue().equals(App.myAccount.getBalanceAsString()[2])) {
            chngAmnt = App.myAccount.getBalance() - gtAmnt;
        } else {
            try {
                chngAmnt = Double.parseDouble(amountTendered.getText()) - gtAmnt;
            } catch (NumberFormatException e) {
                chngAmnt = 0.0;
            }
        }
        change.setText("₱ " + round(chngAmnt));
        
        // If the change is negative disable the proceed to checkout button
        if (chngAmnt < 0 || MusicalInstrument.cart.isEmpty()) {
            proceedToCheckoutButton.setDisable(true);
        } else {
            proceedToCheckoutButton.setDisable(false);
        }
    }
    
    public double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
    public static String getFormattedDate() {
        LocalDateTime dateTime = LocalDateTime.now(); // Includes both date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm a"); // hh for 12-hour clock
        return dateTime.format(formatter);
    }   
    
}