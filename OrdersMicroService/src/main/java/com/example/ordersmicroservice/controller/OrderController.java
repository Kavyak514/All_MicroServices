package com.example.ordersmicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/status/check")
    public String status() {
        return "Hurray , The Order Service is Working Good and Fine!!";
    }
}

