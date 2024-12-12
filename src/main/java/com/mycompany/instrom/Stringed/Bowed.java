package com.mycompany.instrom.Stringed;

public class Bowed extends Stringed {

    public Bowed(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color, BowType typeOfBow, String playingPosition) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color);
        this.typeOfBow = typeOfBow;
        this.playingPosition = playingPosition;
    }
    
    public Bowed(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color, BowType typeOfBow) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color);
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