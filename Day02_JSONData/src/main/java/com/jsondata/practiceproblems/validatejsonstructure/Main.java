package com.jsondata.practiceproblems.validatejsonstructure;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/jsondata/practiceproblems/validatejsonstructure/file.json";
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            User user = objectMapper.readValue(new File(filePath), User.class);
            System.out.println("Valid JSON! User Data:");
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        }catch (IOException e){
            System.out.println("Invalid ! "+e.getMessage());
        }
    }
}
