package com.mycompany.instrom;

public class MusicalInstrument {

    public MusicalInstrument(String name, String brand, String description, String image, InstrumentCategory category, String warrantyPeriod, double price, boolean available) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.image = image;
        this.category = category;
        this.warrantyPeriod = warrantyPeriod;
        this.price = price;
        this.available = available;
    }
    
    public enum InstrumentCategory {
        STRINGED,
        PERCUSSION,
        WIND,
        KEYBOARD
    };
    
    private final String name;
    private final String brand;
    private final String description;
    private final String image;
    private final InstrumentCategory category;
    private String warrantyPeriod;
    private double price;
    private boolean available;

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public InstrumentCategory getCategory() {
        return category;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return available;
    }
    
    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }
    
    // TODO: We need to finish Dashboard ASAP to implement these methods
    public void addToCart() {
        
    }
    
    public void displayItem() {
        
    }
}
