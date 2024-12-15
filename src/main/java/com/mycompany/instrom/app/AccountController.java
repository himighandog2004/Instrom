package com.mycompany.instrom.app;

public class AccountController {
    private final String email = "admin@gmail.com";
    private final String password = "password";
    private final boolean isPwdOrSenior = true;
    private double[] balance = {55000, 8500.0}; // balances are in order specifically CC, GCASH, and COD
    
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
