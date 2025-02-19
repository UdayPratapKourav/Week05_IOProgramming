package com.jsondata.handsonpracticeproblems.csvtojson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file1Path = "src/main/java/com/jsondata/handsonpracticeproblems/csvtojson/file1.csv";

        try{
            List<String> lines= Files.readAllLines(Paths.get(file1Path));
            String[] headers = lines.get(0).split(",");
            JSONArray jsonArray = new JSONArray();
            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split(",");
                JSONObject jsonObject = new JSONObject();

                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], values[j]);
                }

                jsonArray.put(jsonObject);
            }
            System.out.println("Converted JSON:\n" + jsonArray.toString(4));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
