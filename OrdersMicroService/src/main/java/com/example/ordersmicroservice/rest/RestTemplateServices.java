package com.example.ordersmicroservice.rest;

import com.example.ordersmicroservice.response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

@Service
public class RestTemplateServices {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User makeGetRequest() {
        String apiUrl = "http://localhost:9001/product/welcome/message";
        ResponseEntity<User> response = restTemplate.getForEntity(apiUrl, User.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public User makePostRequest() {
        String apiUrl = "https://api.example.com/resource";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("key1", "value1");
        requestBody.add("key2", "value2");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<User> response = restTemplate.postForEntity(apiUrl, requestEntity, User.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
