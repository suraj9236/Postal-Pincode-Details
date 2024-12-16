package com.suraj.postalPincode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    String BaseUrl = "http://www.postalpincode.in/api/pincode/";
    String BaseUrl2 = "https://api.postalpincode.in/postoffice/";
    @Autowired
    private RestTemplate restTemplate;


    public Map<String, Object> pincodeBranch(int pincode) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = BaseUrl + "/"+ pincode;
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<Map<String, Object>>() {});
        return response.getBody();
    }

    public List<Map<String, Object>> branchDetails(String BranchName) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = BaseUrl2 + "/"+ BranchName;
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {});
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
