package com.mycompany.instrom.Wind;

public class Woodwind extends Wind {
    public ReedType typeOfReed;
    public int numberOfKeys;
    public String ligatureType;
    public enum ReedType {
        SINGLE,
        DOUBLE
    }

    public Woodwind(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String pitchRange, String boreShape, int numberOfKeys, String ligatureType, ReedType typeOfReed) {
        super(name, brand, description, image, warrantyPeriod, price, available, pitchRange, boreShape);
        this.typeOfReed = typeOfReed;
        this.numberOfKeys = numberOfKeys;
        this.ligatureType = ligatureType;
    }

    public Woodwind(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String pitchRange, String boreShape, ReedType typeOfReed) {
        super(name, brand, description, image, warrantyPeriod, price, available, pitchRange, boreShape);
        this.typeOfReed = typeOfReed;
    }
    
}
