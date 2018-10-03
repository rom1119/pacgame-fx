package com.pacgame.data.model;

import java.io.Serializable;

public class TokenRequest implements Serializable {

    private String grant_type;
    private String username;
    private String password;

    public String getGrantType() {
        return grant_type;
    }

    public void setGrantType(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
