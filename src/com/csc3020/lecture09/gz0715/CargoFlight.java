package com.csc3020.lecture09.gz0715;

public class CargoFlight extends Flight {
    // Global variables or propertoes of CargoFlight
    public float maxCargoSpace = 1000.0f;
    public float usedCargoSpace;
    //public int seats = 12;

    // Override Accessor & Mutator Functions
    @Override
    public int getSeat() {
        return 12;
    }

    // Functions
    public void add1Package(float h, float w, float d) {
        double size = h * w * d;

        if (hasCargoSpace(size)) {
            usedCargoSpace += size;
        } else {
            handleNoSpace();
        }
    }

    private void handleNoSpace() {
        System.out.println("Not enough space.");
    }

    private boolean hasCargoSpace(double size) {
        return usedCargoSpace + size <= maxCargoSpace;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("[ Max Cargo Space = " + maxCargoSpace + ", Used Cargo Space = " +usedCargoSpace + " ]");
    }
}