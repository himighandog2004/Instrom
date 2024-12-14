package com.mycompany.instrom.Stringed;

public class Plucked extends Stringed {
    public int numberOfFrets;

    public Plucked(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfStrings, StringType typeOfString, String bodyShape, String color, int numberOfFrets) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, numberOfStrings, typeOfString, bodyShape, color);
        this.numberOfFrets = numberOfFrets;
    }

}