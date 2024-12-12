package com.mycompany.instrom.Wind;

import com.mycompany.instrom.MusicalInstrument;

public class Wind extends MusicalInstrument {
    private final String pitchRange;
    private final String boreShape;

    public Wind(String name, String brand, String description, String image, String warrantyPeriod, double price, boolean available, String pitchRange, String boreShape) {
        super(name, brand, description, image, InstrumentCategory.WIND, warrantyPeriod, price, available);
        this.pitchRange = pitchRange;
        this.boreShape = boreShape;
        
    }

    public String getPitchRange() {
        return pitchRange;
    }

    public String getBoreShape() {
        return boreShape;
    }
    
    
}
