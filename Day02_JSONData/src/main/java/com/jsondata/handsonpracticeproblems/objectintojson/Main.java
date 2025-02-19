package com.jsondata.handsonpracticeproblems.objectintojson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 20));
        list.add(new Person("Bob", 22));
        list.add(new Person("Charlie", 21));

        JSONArray jsonArray = new JSONArray();
        for (Person person : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", person.getName());
            jsonObject.put("age", person.getAge());
            jsonArray.put(jsonObject); // Add JSON object to JSON array
        }
        System.out.println(jsonArray.toString(3));

    }
}
