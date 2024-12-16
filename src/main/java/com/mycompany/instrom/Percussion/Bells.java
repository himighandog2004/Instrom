package com.mycompany.instrom.Percussion;

public class Bells extends Percussion {
    public String shape;
    public String pitchRange;

    public Bells(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String material, String size, String shape, String pitchRange) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, material, size, "N/A");
        this.shape = shape;
        this.pitchRange = pitchRange;
    }
    
    public Bells(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String material, String size) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, material, size, "N/A");
    }
    
    public String getShape(){
        return shape;
    }
    
    public String getPitchRange(){
        return pitchRange;
    }
    
}
