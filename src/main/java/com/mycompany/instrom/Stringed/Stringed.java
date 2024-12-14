package com.mycompany.instrom.Stringed;

import com.mycompany.instrom.MusicalInstrument;

public class Stringed extends MusicalInstrument {

    public Stringed(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, StringType typeOfString, String bodyShape, String color) {
        super(name, brand, id, description, image, InstrumentCategory.STRINGED, warrantyPeriod, price, available, quantity);
        this.numberOfStrings = numberOfStrings;
        this.typeOfString = typeOfString;
        this.bodyShape = bodyShape;
        this.color = color;
    }
    
    public enum StringType {
        NYLON,
        STEEL,
        GUT,
        NICKEL
    }
    
    private final int numberOfStrings;
    private final StringType typeOfString;
    private final String bodyShape;
    private final String color;

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public StringType getTypeOfString() {
        return typeOfString;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public String getColor() {
        return color;
    }
    
}