package com.pacgame.data.service;

import com.pacgame.data.model.User;
import com.pacgame.data.model.Token;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

public interface Api {

    Token postToken(String username, String password) throws ResourceAccessException, HttpClientErrorException;

    User getUser(Long id) throws ResourceAccessException, HttpClientErrorException;

    User registerUser(User user) throws ResourceAccessException, HttpClientErrorException, JSONException;

    List<User> getUsers() throws ResourceAccessException, HttpClientErrorException;

    boolean logoutUser();

    Token getToken();

    void setToken(Token token);

    void setLoggedUser(User loggedUser);

    User getLoggedUser();

}
