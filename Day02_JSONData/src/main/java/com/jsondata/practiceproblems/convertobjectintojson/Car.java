package com.jsondata.practiceproblems.convertobjectintojson;

public class Car {
    public String carName;
    public String modelNo;
    public double highestSpeed;

    // Constructor
    public Car(String carName, String modelNo, double highestSpeed) {
        this.carName = carName;
        this.modelNo = modelNo;
        this.highestSpeed = highestSpeed;
    }

    public String getCarName() {
        return carName;
    }

    public String getModelNo() {
        return modelNo;
    }

    public double getHighestSpeed() {
        return highestSpeed;
    }
}
