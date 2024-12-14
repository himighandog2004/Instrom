package com.mycompany.instrom.Percussion;

public class Drums extends Percussion {
    public String drumSetConfiguration;
    public final DrumType typeOfDrum;
    
    public enum DrumType {
        ACOUSTIC,
        ELECTRONIC,
        HYBRID,
        OTHERS
    }
    
    public Drums(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String material, String size, String tone, String drumSetConfiguration, DrumType typeOfDrum) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, material, size, tone);
        this.drumSetConfiguration = drumSetConfiguration;
        this.typeOfDrum = typeOfDrum;
    }
    
    public Drums(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String material, String size, String tone, DrumType typeOfDrum) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, material, size, tone);
        this.typeOfDrum = typeOfDrum;
    }
    
}
