package com.jsondata.practiceproblems.convertjavaobjectsintojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            List<Car> carList= Arrays.asList(
                    new Car("Toyota", "Camry", 220.5),
                    new Car("Honda", "Civic", 200.0),
                    new Car("Ford", "Mustang", 250.0)
            );
            ObjectMapper objectMapper=new ObjectMapper();
            String jsonArray=objectMapper.writeValueAsString(carList);
            System.out.println(jsonArray);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
