package com.example.usermicroservice.response;

import com.example.usermicroservice.entity.User;
import lombok.Data;

@Data
public class Response {
    private String status;
    private String message;
    private User user;
}
