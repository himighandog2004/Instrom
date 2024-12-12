package com.mycompany.instrom.Percussion;

public class Bells extends Percussion {
    public String shape;
    public String pitchRange;

    public Bells(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String material, String size, String tone, String shape, String pitchRange) {
        super(name, brand, description, image, warrantyPeriod, price, available, material, size, tone);
        this.shape = shape;
        this.pitchRange = pitchRange;
    }
    
    public Bells(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String material, String size, String tone) {
        super(name, brand, description, image, warrantyPeriod, price, available, material, size, tone);
    }
}
