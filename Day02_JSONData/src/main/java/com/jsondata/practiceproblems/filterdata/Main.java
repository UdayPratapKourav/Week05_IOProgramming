package com.jsondata.practiceproblems.filterdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/jsondata/practiceproblems/filterdata/file.json";
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person>list = Arrays.asList(objectMapper.readValue(new File(filePath),Person[].class));
            list.stream().filter(p -> p.age > 25).forEach(System.out::println);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
