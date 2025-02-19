package com.jsondata.handsonpracticeproblems.readandprint;

import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/jsondata/handsonpracticeproblems/readandprint/file.json";
       try{
           String content = new String(Files.readAllBytes(Paths.get(filePath)));
           JSONObject jsonObject = new JSONObject(content);
           Iterator<String >keys=jsonObject.keys();
           while (keys.hasNext()){
               String key = keys.next();
               Object value=jsonObject.get(key);
               System.out.println(key+" : "+value);
           }
       }catch (Exception e ){
           System.out.println(e.getMessage());
       }
    }
}
