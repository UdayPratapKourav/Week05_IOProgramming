package com.jsondata.practiceproblems.validatejsonstructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("id")
    private int id ;
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;
    public User(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
