package com.pacgame.data.service;

import com.pacgame.App;
import com.pacgame.data.model.Token;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.ServerError;

import static com.pacgame.App.user;

public class ApiServiceImpl implements ApiService {

    private Api api;

    public ApiServiceImpl(Api api) {
        this.api = api;
    }

    @Override
    public Token loginUser(String username, String password) {

        Token token = null;
        try {
            token = api.postToken(username, password);
            api.setToken(token);
            user = api.getUser(null);
            api.setLoggedUser(user);
            App.setUser(user);
            App.bindUserProperty();
            App.setLoggedUser(true);
            token.setUser(user);
        } catch (ResourceAccessException e) {
            token = new Token();
            token.setErrorType(Token.SERVER_ERROR);
            token.setError("error");
        } catch (HttpClientErrorException e) {
            token = new Token();
            token.setErrorType(Token.CREDENTIALS_ERROR);
            token.setError("error");
        }

        return token;
    }

    @Override
    public boolean logoutUser() {
        try {
            api.logoutUser();
            onLogoutSuccess();
        } catch (ResourceAccessException e) {
            return false;
        } catch (HttpClientErrorException e) {
            return false;
        }

        return true;
    }

    private void onLogoutSuccess()
    {
        api.setToken(null);
        api.setLoggedUser(null);
        App.setUser(null);
        App.setLoggedUser(false);
    }
}
