package com.mycompany.instrom.Stringed;

import com.mycompany.instrom.MusicalInstrument;

public class Stringed extends MusicalInstrument {

    public Stringed(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color) {
        super(name, brand, description, image, InstrumentCategory.STRINGED, warrantyPeriod, price, available);
        this.numberOfStrings = numberOfStrings;
        this.typeOfString = typeOfString;
        this.bodyShape = bodyShape;
        this.color = color;
    }
    
    public enum StringType {
        NYLON,
        STEEL,
        GUT
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