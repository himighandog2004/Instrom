package com.mycompany.instrom.Wind;

public class Woodwind extends Wind {
    public ReedType typeOfReed;
    public int numberOfKeys;
    public String ligatureType;
    public enum ReedType {
        SINGLE,
        DOUBLE
    }

    public Woodwind(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String pitchRange, String boreShape, int numberOfKeys, String ligatureType, ReedType typeOfReed) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, pitchRange, boreShape);
        this.typeOfReed = typeOfReed;
        this.numberOfKeys = numberOfKeys;
        this.ligatureType = ligatureType;
    }

    public Woodwind(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String pitchRange, String boreShape, ReedType typeOfReed) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, pitchRange, boreShape);
        this.typeOfReed = typeOfReed;
    }    
    
}
