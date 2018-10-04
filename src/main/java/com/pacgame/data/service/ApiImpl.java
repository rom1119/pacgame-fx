package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ApiImpl implements Api {

    private Environment env;

    public static String GET_LOGGED_USER_URL;

    public static String CLIENT_ID;

    public static String CLIENT_SECRET;

    public static String GET_TOKEN_URL;

    private RestTemplate restTemplate;

    private Token token;
    private ResponseEntity<User> responseUser;
    private User loggedUser;

    public ApiImpl() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    public Token postApiToken(User user) throws ResourceAccessException, HttpClientErrorException {

//        TokenRequest tokenRequest = new TokenRequest();
//        tokenRequest.setGrantType("password");
//        tokenRequest.setUsername(user.getEmail());
//        tokenRequest.setPassword(user.getPassword());

        HashMap<String, String> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", "password");
        bodyRequest.put("username", user.getEmail());
        bodyRequest.put("password", user.getPassword());

        String clientIdAndSecret = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedClientIdAndSecret = Base64Utils.encodeToString(clientIdAndSecret.getBytes());
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "x-www-form-urlencoded"));
        requestHeaders.add("Authorization", "Basic " + encodedClientIdAndSecret);

        HttpEntity<String> request = new HttpEntity<>(getDataString(bodyRequest), requestHeaders);

        token = restTemplate.postForObject(GET_TOKEN_URL, request, Token.class);

        return token;

    }

    public User getLoggedUser() throws ResourceAccessException, HttpClientErrorException
    {
        if (loggedUser != null) {
            return loggedUser;
        }

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<String> request = new HttpEntity<>(requestHeaders);

        responseUser = restTemplate.exchange(GET_LOGGED_USER_URL, HttpMethod.GET, request, User.class);

        loggedUser = responseUser.getBody();

        return loggedUser;

    }

    private static String getDataString(HashMap<String, String> params)  {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");
            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
        }
        return result.toString();
    }


}
