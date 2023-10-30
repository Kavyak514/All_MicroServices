package com.example.ordersmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrdersMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersMicroServiceApplication.class, args);
    }
}