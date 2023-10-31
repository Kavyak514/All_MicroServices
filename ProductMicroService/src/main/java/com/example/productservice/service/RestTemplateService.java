package com.example.productservice.service;

import com.example.productservice.response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    @Value("${postUrl}")
    private String postUrl;

    @Value("${getUrl}")
    private String getUrl;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //GetForEntity is used for returning single Object for List use exchange method.

    public List<User> makeGetRequest() {
        String getUserUrl = getUrl;
        ResponseEntity<List<User>> response = restTemplate.exchange(getUserUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return Collections.emptyList();
        }
    }

    public User makePostRequest() {
        String createUserUrl = postUrl;
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", "Nitesh");
        requestBody.put("password", "Nitesh123");
        requestBody.put("roleName", "admin");
        requestBody.put("active", "true");
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody);
        ResponseEntity<User> response = restTemplate.postForEntity(createUserUrl, requestEntity, User.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
