package com.pacgame.data.service;

import com.pacgame.data.model.Token;

public interface ApiService {

    Token loginUser(String username, String password);
    boolean logoutUser();
}
