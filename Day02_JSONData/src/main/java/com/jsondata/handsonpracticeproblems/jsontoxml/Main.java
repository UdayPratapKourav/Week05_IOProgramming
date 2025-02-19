package com.jsondata.handsonpracticeproblems.jsontoxml;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/jsondata/handsonpracticeproblems/jsontoxml/file.json";
        try{
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonData);
            String xmlData = XML.toString(jsonObject,"root");
            System.out.println("Converted XML:\n" + xmlData);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
