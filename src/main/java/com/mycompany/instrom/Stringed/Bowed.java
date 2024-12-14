package com.mycompany.instrom.Stringed;

public class Bowed extends Stringed {

    public Bowed(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, StringType typeOfString, String bodyShape, String color, BowType typeOfBow, String playingPosition) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, numberOfStrings, typeOfString, bodyShape, color);
        this.typeOfBow = typeOfBow;
        this.playingPosition = playingPosition;
    }
    
    public Bowed(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, StringType typeOfString, String bodyShape, String color, BowType typeOfBow) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, numberOfStrings, typeOfString, bodyShape, color);
        this.typeOfBow = typeOfBow;
    }
    
    public enum BowType {
        VIOLIN,
        LYRA_AND_REBEC,
        ROSINED_WHEEL,
        OTHERS
    }
    
    public final BowType typeOfBow;
    public String playingPosition;
}