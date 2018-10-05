package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

public interface Api {

    Token postApiToken(String username, String password) throws ResourceAccessException, HttpClientErrorException;
    User getLoggedUser() throws ResourceAccessException, HttpClientErrorException;
}
