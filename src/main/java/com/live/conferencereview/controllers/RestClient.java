package com.live.conferencereview.controllers;

import org.springframework.web.client.RestTemplate;

public class RestClient {

    static final String URL_ALLSESSIONS = "http://localhost:8080/api/v1/sessions/";
    static final String URL_GETSESSIONS = "http://localhost:8080/api/v1/sessions/1";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers
        String result = restTemplate.getForObject(URL_ALLSESSIONS, String.class);
        String result1 = restTemplate.getForObject(URL_GETSESSIONS, String.class);

        System.out.println(result);
        System.out.println(result1);
    }

}
