package com.pacgame.data.service;

import com.pacgame.data.model.Token;
import com.pacgame.data.model.User;

import java.util.List;

public interface ApiService {

    Token loginUser(String username, String password);
    boolean logoutUser();
    List<User> getUsers();
}
