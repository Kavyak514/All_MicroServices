package com.example.productservice.controller;

import com.example.productservice.openfeign.OpenFeignClient;
import com.example.productservice.response.User;
import com.example.productservice.service.RestTemplateService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    RestTemplateService userService;
    OpenFeignClient openFeignClient;

    @Autowired
    public ProductController(RestTemplateService userService, OpenFeignClient openFeignClient) {
        this.userService = userService;
        this.openFeignClient = openFeignClient;
    }

    @GetMapping("/welcome/message")
    public String welcome() {
        return "Hurray , The Product Service is Working Good and Fine!!";
    }

    @PostMapping("/createUser")
    public User createUser() {
        return userService.makePostRequest();
    }

    @GetMapping("/getUser")
    public List<User> makeGetRequest() {
        return userService.makeGetRequest();
    }

    @PostMapping("/createFeignUser")
    public User createFeignUser(@RequestBody User user) {
        return openFeignClient.createUser(user);
    }

    public List<User> backUpMethod(Throwable throwable) {
        List<User> users = new ArrayList<>();
        users.add(new User());
        return users;
    }

    @GetMapping("/getFeignUserCircuitBreaker")
    @CircuitBreaker(name = "Feign-Client-Error", fallbackMethod = "backUpMethod")
    public List<User> makeGetFeignRequest() {
        throw new RuntimeException();
    }

    @GetMapping("/getUserException")
    public List<User> getUserHandleException() {
        throw new RuntimeException();
    }

    @GetMapping("/getFeignUser")
    public List<User> getFeignUser() {
        return openFeignClient.getUser();
    }
}
