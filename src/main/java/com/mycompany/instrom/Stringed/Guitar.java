package com.mycompany.instrom.Stringed;

public class Guitar extends Plucked {

    public Guitar(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfStrings, Stringed.StringType typeOfString, String bodyShape, String color, int numberOfFrets, GuitarType typeOfGuitar) {
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
