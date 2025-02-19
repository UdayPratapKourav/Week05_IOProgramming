package com.jsondata.practiceproblems.convertobjectintojson;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Create Car object
        Car car = new Car("Innova", "2025", 300.0);

        // Convert object to JSON
        JSONObject jsonObject = new JSONObject(car);




        // Print JSON string
        System.out.println(jsonObject.toString(4)); // Pretty print with indentation
    }
}
