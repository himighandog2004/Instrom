package com.mycompany.instrom.Keyboard;

import com.mycompany.instrom.MusicalInstrument;

public class Keyboard extends MusicalInstrument {
    private final int numberOfKeys;
    public boolean isAcoustic;

    public Keyboard(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, int numberOfKeys, boolean isAcoustic) {
        super(name, brand, id, description, image, InstrumentCategory.KEYBOARD, warrantyPeriod, price, available, quantity);
        this.numberOfKeys = numberOfKeys;
        this.isAcoustic = isAcoustic;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }
    
    public boolean getAcoustic(){
        return isAcoustic;
    }
    
}
