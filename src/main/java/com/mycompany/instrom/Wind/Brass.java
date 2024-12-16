package com.mycompany.instrom.Wind;

public class Brass extends Wind {
    public String mouthpiece;
    public int valves;
    public ValveType typeOfValve;
    public enum ValveType {
        BALL_VALVE,
        GATE_VALVE,
        GLOBE_VALVE,
        CHECK_VALVE
    }

    public Brass(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String pitchRange, String boreShape, String mouthpiece, int valves, ValveType typeOfValve) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, pitchRange, boreShape);
        this.mouthpiece = mouthpiece;
        this.valves = valves;
        this.typeOfValve = typeOfValve;
    }

    public Brass(String name, String brand, String id, String description, String image, String warrantyPeriod, double price, boolean available, int quantity, String pitchRange, String boreShape, ValveType typeOfValve) {
        super(name, brand, id, description, image, warrantyPeriod, price, available, quantity, pitchRange, boreShape);
        this.typeOfValve = typeOfValve;
    }
       
}
