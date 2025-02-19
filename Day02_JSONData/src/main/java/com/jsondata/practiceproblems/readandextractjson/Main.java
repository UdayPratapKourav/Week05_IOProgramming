package com.jsondata.practiceproblems.readandextractjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/jsondata/practiceproblems/readandextractjson/file.json";
        try{
           String content=new String(Files.readAllBytes(Paths.get(filePath)));
           JSONObject jsonObject=new JSONObject(content);
           String name =jsonObject.getString("name");
           String email=jsonObject.getString("email");
            System.out.println("Name : "+name);
            System.out.println("Email : "+email);

        }catch (IOException e){
            System.out.println();
        }

    }
}
