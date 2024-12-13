package com.mycompany.instrom.Percussion;

public class Bells extends Percussion {
    public String shape;
    public String pitchRange;

    public Bells(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String material, String size, String shape, String pitchRange) {
        super(name, brand, description, image, warrantyPeriod, price, available, material, size, "N/A");
        this.shape = shape;
        this.pitchRange = pitchRange;
    }
    
    public Bells(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String material, String size) {
        super(name, brand, description, image, warrantyPeriod, price, available, material, size, "N/A");
    }
}
