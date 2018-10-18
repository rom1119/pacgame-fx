package com.pacgame.data.service;

import com.pacgame.App;
import com.pacgame.data.model.ResponseError;
import com.pacgame.data.model.SubError;
import com.pacgame.data.model.User;
import com.pacgame.data.model.Token;
import javafx.scene.image.Image;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            api.logoutUser();
            token = api.postToken(username, password);
            api.setToken(token);
            user = api.getUser(null);
            api.setLoggedUser(user);
            api.getLoggedUser().setPassword("");
            api.getLoggedUser().setConfirmPassword("");
            App.setUser(user);
            App.bindUserProperty();
            App.setLoggedUser(true);
            token.setBody(user);
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
    public Token registerUser(User user) {

        Token token = new Token();
        try {
            token.setBody(api.registerUser(user));
        } catch (ResourceAccessException e) {
            token.setErrorType(Token.SERVER_ERROR);
            token.setError("error");
        } catch (HttpClientErrorException e) {
            token.setErrorType(Token.CREDENTIALS_ERROR);
            token.setError("error");

            ResponseError responseError = null;
            try {
                responseError = createResponseErrorFromJsonString(e.getResponseBodyAsString());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            token.setResponseError(responseError);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return token;
    }

    @Override
    public Token updateUser(User userArg) {

        Token token = null;
        try {
            user = api.putUser(userArg);
            api.setLoggedUser(user);
            App.setUser(user);
            App.bindUserProperty();
            App.setLoggedUser(true);
            token.setBody(user);
        } catch (ResourceAccessException e) {
            token = new Token();
            token.setErrorType(Token.SERVER_ERROR);
            token.setError("error");
        } catch (HttpClientErrorException e) {
            token = new Token();
            token.setErrorType(Token.CREDENTIALS_ERROR);
            token.setError("error");
            ResponseError responseError = null;
            try {
                responseError = createResponseErrorFromJsonString(e.getResponseBodyAsString());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            token.setResponseError(responseError);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return token;
    }

    @Override
    public Token updateUserImage(File file) {

        Token token = new Token();
        try {
            user = api.putUserImage(file);
            api.setLoggedUser(user);
            App.setUser(user);
            App.bindUserProperty();
            App.setLoggedUser(true);
            token.setBody(user);
        } catch (ResourceAccessException e) {
            token.setErrorType(Token.SERVER_ERROR);
            token.setError("error");
        } catch (HttpClientErrorException e) {
            token.setErrorType(Token.CREDENTIALS_ERROR);
            token.setError("error");
            ResponseError responseError = null;
            try {
                responseError = createResponseErrorFromJsonString(e.getResponseBodyAsString());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            token.setResponseError(responseError);
        }

        return token;
    }

    @Override
    public List<User> getUsers() {

        List<User> users = null;
        try {
            users = api.getUsers();
        } catch (ResourceAccessException e) {

        } catch (HttpClientErrorException e) {

        }

        return users;
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

    private ResponseError createResponseErrorFromJsonString(String json) throws JSONException {
        JSONObject bodyResponse = new JSONObject(json);
        ResponseError responseError = new ResponseError();
        responseError.setStatus((String) bodyResponse.get("status"));
        responseError.setMessage((String) bodyResponse.get("message"));
        Set<SubError> errors = new HashSet<>();
        JSONArray errorsJson = bodyResponse.getJSONArray("errors");
        if (errorsJson != null) {
            for (int i = 0; i < errorsJson.length(); i++){
                JSONObject el = new JSONObject(errorsJson.getString(i));
                System.out.println(el.getString("objectName"));
                SubError subError = new SubError((String) el.get("objectName"), (String) el.get("field"), (String) el.get("rejectedValue"), (String) el.get("message"));
                errors.add(subError);
            }
        }

        responseError.setErrors(errors);

        return responseError;
    }

    @Override
    public Image getImageUser(User user)
    {
        if (user.getUserDetails() == null) {
            return null;
        }

        return user.getUserDetails().getFileName() == null ? null : api.getUserImage(user);
    }


    private void onLogoutSuccess()
    {
        api.setToken(null);
        api.setLoggedUser(null);
        App.setUser(null);
        App.setLoggedUser(false);
    }
}
