package com.jsondata.practiceproblems.mergetwojsonobjects;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","uday");
        jsonObject.put("age","20");
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("email","uday@gmail.com");
        jsonObject1.put("city","imaliya");
        for(String key:jsonObject1.keySet()){
            jsonObject.put(key,jsonObject1.get(key));
        }
        System.out.println(jsonObject.toString(4));

    }
}
