package com.example.productservice.openfeign;

import com.example.productservice.response.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("USER-SERVICE")
public interface OpenFeignClient {
    @GetMapping("/user-service/getUser")
    List<User> getUser();

    @PostMapping("/user-service/createUser")
    User createUser(@RequestBody User user);
}
