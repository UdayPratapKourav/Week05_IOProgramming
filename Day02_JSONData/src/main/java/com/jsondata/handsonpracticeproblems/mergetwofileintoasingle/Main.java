package com.jsondata.handsonpracticeproblems.mergetwofileintoasingle;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath1 = "src/main/java/com/jsondata/handsonpracticeproblems/mergetwofileintoasingle/file1.json";
        String filePath2= "src/main/java/com/jsondata/handsonpracticeproblems/mergetwofileintoasingle/file2.json";

        try{
            String json1=new String(Files.readAllBytes(Paths.get(filePath1)));
            String json2=new String(Files.readAllBytes(Paths.get(filePath2)));

            JSONObject jsonObject1 = new JSONObject(json1);
            JSONObject jsonObject2 = new JSONObject(json2);

            for(String key:jsonObject2.keySet()){
                jsonObject1.put(key,jsonObject2.get(key));
            }

            System.out.println("Merged JSON: " + jsonObject1.toString(4));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
