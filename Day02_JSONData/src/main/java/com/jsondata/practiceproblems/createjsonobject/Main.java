package com.jsondata.practiceproblems.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Ankit");
        jsonObject.put("Age",22);
        JSONArray jsonArray=new JSONArray();
        jsonArray.put("DataStructure");
        jsonArray.put("ComputerNetwork");
        jsonArray.put("ObjectOrientedProgramming");
        jsonObject.put("Subjects",jsonArray);
        System.out.println(jsonObject.toString(4));

    }
}
