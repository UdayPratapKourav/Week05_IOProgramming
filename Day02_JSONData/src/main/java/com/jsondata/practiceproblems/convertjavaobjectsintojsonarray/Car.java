package com.jsondata.practiceproblems.convertjavaobjectsintojsonarray;



import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("speed")
    private double speed;

    // Constructor
    public Car(String name, String model, double speed) {
        this.name = name;
        this.model = model;
        this.speed = speed;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }
}
