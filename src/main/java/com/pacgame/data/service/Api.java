package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

public interface Api {

    Token postToken(String username, String password) throws ResourceAccessException, HttpClientErrorException;

    User getUser(Long id) throws ResourceAccessException, HttpClientErrorException;

    boolean logoutUser();

    public Token getToken();

    public void setToken(Token token);

    public void setLoggedUser(User loggedUser);

    public User getLoggedUser();

}
