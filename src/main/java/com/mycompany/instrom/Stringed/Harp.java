package com.mycompany.instrom.Stringed;

public class Harp extends Plucked {
    public boolean isPedalHarp;

    public Harp(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, Stringed.StringType typeOfString, String bodyShape, String color, boolean isPedalHarp) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, numberOfStrings, typeOfString, bodyShape, color, 0);
        this.isPedalHarp = isPedalHarp;
    }
    
    public Harp(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, Stringed.StringType typeOfString, String bodyShape, String color) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, numberOfStrings, typeOfString, bodyShape, color, 0);
        this.isPedalHarp = true;
    }
    
    public boolean getHarpPedal(){
        return isPedalHarp;
    }
    
}
