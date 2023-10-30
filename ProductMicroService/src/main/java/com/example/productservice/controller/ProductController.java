package com.example.productservice.controller;

import com.example.productservice.response.User;
import com.example.productservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    UserService userService;

    @GetMapping("/welcome/message")
    public String welcome() {
        return "Hurray , The Product Service is Working Good and Fine!!";
    }

    @PostMapping("/createUser")
    public User createUser() {
        return userService.makePostRequest();
    }
}
