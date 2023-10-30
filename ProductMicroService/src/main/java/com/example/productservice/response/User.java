package com.example.productservice.response;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String active;
    private boolean isEnabled;
}
