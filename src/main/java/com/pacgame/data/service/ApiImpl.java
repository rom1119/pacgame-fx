package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import com.sun.imageio.plugins.common.LZWCompressor;
import javafx.scene.image.Image;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URI;
import java.util.*;

public class ApiImpl implements Api {

    public static String LOGOUT_URL;
    private Environment env;

    public static String GET_LOGGED_USER_URL;
    public static String GET_USER_URL;
    public static String GET_USERS_URL;
    public static String PUT_USER_URL;
    public static String PUT_USER_IMAGE_URL;
    public static String REGISTER_URL;
    public static String RESOURCE_URL;

    public static String CLIENT_ID;
    public static String CLIENT_SECRET;

    public static String GET_TOKEN_URL;

    private RestTemplate restTemplate;

    private Token token;
    private User loggedUser;

    public ApiImpl() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    @Override
    public Token postToken(String username, String password) throws ResourceAccessException, HttpClientErrorException {

        if (token != null) {
            return token;
        }

        HashMap<String, String> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", "password");
        bodyRequest.put("username", username);
        bodyRequest.put("password", password);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "x-www-form-urlencoded"));
        requestHeaders.add("Authorization", "Basic " + hashClientIdAndPassword());

        HttpEntity<String> request = new HttpEntity<>(getDataString(bodyRequest), requestHeaders);
        return restTemplate.postForObject(GET_TOKEN_URL, request, Token.class);

    }

    @Override
    public User getUser(Long id) throws ResourceAccessException, HttpClientErrorException
    {
        if (token == null) {
            throw new ResourceAccessException("Token not exist");
        }

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<String> request = new HttpEntity<>(requestHeaders);

        ResponseEntity<User> responseUser = null;
        if (id == null) {
            responseUser = restTemplate.exchange(GET_LOGGED_USER_URL, HttpMethod.GET, request, User.class);
        } else {
            responseUser = restTemplate.exchange(GET_USER_URL + String.valueOf(id), HttpMethod.GET, request, User.class);

        }
        return responseUser.getBody();

    }

    @Override
    public User registerUser(User user) throws ResourceAccessException, HttpClientErrorException, JSONException {

//        HashMap<String, String> bodyRequest = new HashMap<>();
//        bodyRequest.put("username", user.getUsername());
//        bodyRequest.put("password", user.getPassword());
//        bodyRequest.put("confirmPassword", user.getConfirmPassword());

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("username", user.getUsername());
        bodyRequest.put("password", user.getPassword());
        bodyRequest.put("confirmPassword", user.getConfirmPassword());

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));

        HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), requestHeaders);

        User responseUser = null;

        responseUser = restTemplate.postForObject(REGISTER_URL, request, User.class);
        return responseUser;
    }

    @Override
    public List<User> getUsers() throws ResourceAccessException, HttpClientErrorException {
        if (token == null) {
            throw new ResourceAccessException("Token not exist");
        }

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<String> request = new HttpEntity<>(requestHeaders);

        ResponseEntity<List<User>> responseUser = null;

        responseUser = restTemplate.exchange(GET_USERS_URL, HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>(){});

        return responseUser.getBody();
    }

    @Override
    public boolean logoutUser() throws ResourceAccessException, HttpClientErrorException {
        if (token == null) {
            return false;
        }

        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setContentType(new MediaType("application", "x-www-form-urlencoded"));
        requestHeaders.add("Authorization", "Basic " + hashClientIdAndPassword());
        requestHeaders.add("AUTH-TOKEN", getToken().getAccess_token());

        HttpEntity<String> request = new HttpEntity<>(requestHeaders);


        restTemplate.exchange(LOGOUT_URL, HttpMethod.DELETE, request, java.lang.Object.class);

        return true;

    }

    private String hashClientIdAndPassword()
    {
        String clientIdAndSecret = CLIENT_ID + ":" + CLIENT_SECRET;

        return Base64Utils.encodeToString(clientIdAndSecret.getBytes());
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

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    @Override
    public User putUser(User user) throws ResourceAccessException, HttpClientErrorException, JSONException {
        if (token == null) {
            throw new ResourceAccessException("Token not exist");
        }

        JSONObject bodyRequest = new JSONObject();
        JSONObject userDetails = new JSONObject();
        bodyRequest.put("id", getLoggedUser().getId());
        userDetails.put("firstName", user.getUserDetails().getFirstName());
        userDetails.put("lastName", user.getUserDetails().getFirstName());
        bodyRequest.put("userDetails", userDetails);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        requestHeaders.add("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<String> request = new HttpEntity<>(bodyRequest.toString(), requestHeaders);

        ResponseEntity<User> responseUser = null;

        responseUser = restTemplate.exchange(PUT_USER_URL, HttpMethod.PUT, request, User.class);

        return responseUser.getBody();
    }

    @Override
    public User putUserImage(File file) throws ResourceAccessException, HttpClientErrorException {
        if (token == null) {
            throw new ResourceAccessException("Token not exist");
        }

//        try (FileInputStream fileInputStream = new FileInputStream(file)) {
//            byte imageData[] = new byte[(int) file.length()];
//            fileInputStream.read(imageData);
//            String base64Image = Base64.getEncoder().encodeToString(imageData);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();

        HttpEntity fileSend = new HttpEntity(new FileSystemResource(file));

        body.add("file", fileSend);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        requestHeaders.add("Authorization", "Bearer " + token.getAccess_token());

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, requestHeaders);

        ResponseEntity<User> responseUser = null;

        responseUser = restTemplate.exchange(getUrlWithParams(PUT_USER_IMAGE_URL), HttpMethod.PUT, request, User.class);

        return responseUser.getBody();
    }

    private String getUrlWithParams(String putUserImageUrl) {
        return putUserImageUrl.replaceFirst("\\{id\\}", getLoggedUser().getId());
    }

    @Override
    public Image getUserImage(User user) {
        return new Image(RESOURCE_URL + "userdetails/" +  user.getUserDetails().getFileName());
    }
}
