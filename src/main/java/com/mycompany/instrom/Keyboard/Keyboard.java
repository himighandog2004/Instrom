package com.mycompany.instrom.Keyboard;

import com.mycompany.instrom.MusicalInstrument;

public class Keyboard extends MusicalInstrument {
    private final int numberOfKeys;
    public boolean isAcoustic;

    public Keyboard(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, int numberOfKeys, boolean isAcoustic) {
        super(name, brand, description, image, InstrumentCategory.KEYBOARD, warrantyPeriod, price, available);
        this.numberOfKeys = numberOfKeys;
        this.isAcoustic = isAcoustic;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }
    
}
