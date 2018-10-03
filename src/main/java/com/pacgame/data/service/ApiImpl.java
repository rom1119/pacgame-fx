package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.TokenRequest;
import com.pacgame.data.model.User;
import com.pacgame.data.service.Api;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ApiImpl implements Api {

    private final String client_id = "clientIdPassword";
    private final String client_secret = "secret";

    public static boolean loginUser(User user) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new ResourceHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setGrantType("password");
        tokenRequest.setUsername(user.getEmail());
        tokenRequest.setPassword(user.getPassword());

        HashMap<String, String> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", "password");
        bodyRequest.put("username", user.getEmail());
        bodyRequest.put("password", user.getPassword());

//        StringBuilder requestBody = new StringBuilder();
//        requestBody.append("grant_type=password&");
//        requestBody.append("username=" + user.getEmail() + "&");
//        requestBody.append("password=" + user.getPassword());


        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "x-www-form-urlencoded"));
        requestHeaders.add("Authorization", "Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=");

        HttpEntity<String> request = new HttpEntity<>(getDataString(bodyRequest), requestHeaders);


        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=");
        headers.put("Content-Type", "application/x-www-form-urlencoded");

        Token token = restTemplate.postForObject("http://localhost:8080/oauth/token", request, Token.class);

        return true;

    }

    private static String getDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }


}
