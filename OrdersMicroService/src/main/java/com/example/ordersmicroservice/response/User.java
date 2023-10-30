package com.example.ordersmicroservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private long id;
    private String name;
    private String email;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
}
