package com.mycompany.instrom.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class AccountController implements Initializable {
    private final String email = "admin@gmail.com";
    private final String password = "password";
    private final boolean isPwdOrSenior = true;
    private double[] balance = {55000, 8500.0}; // balances are in order specifically CC, GCASH, and COD
        
    @FXML
    private void switchToDashboard() throws IOException{
        App.changeStage("Dashboard", "Welcome to Dashboard!", 980, 588);
    }
    
    @FXML
    private ChoiceBox <String>paymentMethod;
    
    public void initialize(URL url, ResourceBundle rb) {
        paymentMethod.getItems().addAll(App.myAccount.getBalanceAsString());
        // Add a listener to react to changes in the selected option
        paymentMethod.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            System.out.println("Selected: " + newValue);
            String[] possibleMethods = App.myAccount.getBalanceAsString();
            // If the user picks Cash on Delivery, show the field for amount tendered
            if (paymentMethod.getValue().equals(possibleMethods[0])) { //CC
                App.myAccount.setUserPaymentMethod(PaymentMethod.CREDIT_CARD);
            } else if (paymentMethod.getValue().equals(possibleMethods[1])) { // GCASH
                App.myAccount.setUserPaymentMethod(PaymentMethod.GCASH);
            } else if (paymentMethod.getValue().equals(possibleMethods[2])) {
                App.myAccount.setUserPaymentMethod(PaymentMethod.CASH_ON_DELIVERY);
            }
          
        });
        paymentMethod.setValue(App.myAccount.getUserPaymentMethodAsString());        
    }    
    
    public String[] getBalanceAsString() {
        return new String[]{
            PaymentMethod.CREDIT_CARD.name() + " - ₱ " + balance[0],
            PaymentMethod.GCASH.name() + " - ₱ " + balance[1],
            PaymentMethod.CASH_ON_DELIVERY.name()
        };
    }
    
    public String getUserPaymentMethodAsString() {
        return getBalanceAsString()[getUserPaymentMethod().ordinal()];
    }
    
    public double getBalance() {
        return balance[getUserPaymentMethod().ordinal()];
    }

    public void setBalance(PaymentMethod method, double balance) {
        switch (method) {
            case CREDIT_CARD:
                this.balance[0] = balance;
                break;
            case GCASH:
                this.balance[1] = balance;
                break;
            default:
                break;
        }
    }
    
    private PaymentMethod userPaymentMethod = PaymentMethod.CREDIT_CARD;

    public PaymentMethod getUserPaymentMethod() {
        return userPaymentMethod;
    }

    public void setUserPaymentMethod(PaymentMethod userPaymentMethod) {
        this.userPaymentMethod = userPaymentMethod;
    }
            
    public enum PaymentMethod {
        CREDIT_CARD,
        GCASH,
        CASH_ON_DELIVERY
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean getIsPwdOrSenior() {
        return isPwdOrSenior;
    }
    
}
