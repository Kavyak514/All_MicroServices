package com.example.ordersmicroservice.controller;

import com.example.ordersmicroservice.response.User;
import com.example.ordersmicroservice.rest.RestTemplateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private RestTemplateServices restTemplateServices;

    @Autowired
    public OrderController(RestTemplateServices restTemplateServices) {
        this.restTemplateServices = restTemplateServices;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Hurray , The Order Service is Working Good and Fine!!";
    }

    @GetMapping("/status/getUser")
    public User getUser() {
        return restTemplateServices.makeGetRequest();
    }
    @GetMapping("/status/postUser")
    public User postUser() {
        return restTemplateServices.makePostRequest();
    }
}

