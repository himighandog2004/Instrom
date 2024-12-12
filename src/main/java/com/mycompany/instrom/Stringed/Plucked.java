package com.mycompany.instrom.Stringed;

public class Plucked extends Stringed {
    public int numberOfFrets;

    public Plucked(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color, int numberOfFrets) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color);
        this.numberOfFrets = numberOfFrets;
    }

}

class Harp extends Plucked {
    public boolean isPedalHarp;

    public Harp(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color, boolean isPedalHarp) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color, 0);
        this.isPedalHarp = isPedalHarp;
    }
    
    public Harp(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color, 0);
        this.isPedalHarp = true;
    }
}

class Guitar extends Plucked {

    public Guitar(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, StringType typeOfString, String bodyShape, String color, int numberOfFrets, GuitarType typeOfGuitar) {
        super(name, brand, description, image, warrantyPeriod, price, available, numberOfStrings, typeOfString, bodyShape, color, numberOfFrets);
        this.typeOfGuitar = typeOfGuitar;
    }

    public enum GuitarType {
        ELECTRIC,
        ACOUSTIC,
        BASS,
        CLASSICAL,
        OTHERS
    }
    
    public GuitarType typeOfGuitar;
}
