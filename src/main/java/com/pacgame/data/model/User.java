package com.pacgame.data.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private SimpleStringProperty id;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty passwordConfirm;
    private boolean acceptTerms;

    private SimpleObjectProperty<UserDetails> userDetails;

    private SimpleStringProperty userRoles;

    public User() {

        id = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        passwordConfirm = new SimpleStringProperty();
        userDetails = new SimpleObjectProperty<>();
        userRoles = new SimpleStringProperty();

        setUserDetails(new UserDetails());
    }

    public User(String firstName, String lastName, String username, String score) {
        this();
        getUserDetails().setFirstName(firstName);
        getUserDetails().setLastName(lastName);
        getUserDetails().setScore(score);
        setUsername(username);

    }

    public String getId() {
        return idProperty().get();
    }


    public String getUsername() {
        return usernameProperty().get();
    }

    public String getPassword() {
        return passwordProperty().get();
    }

    public String getPasswordConfirm() {
        return passwordConfirmProperty().get();
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public UserDetails getUserDetails() {
        return userDetailsProperty().get();
    }

    public String getUserRoles() {
        return userRolesProperty().get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public SimpleStringProperty passwordConfirmProperty() {
        return passwordConfirm;
    }

    public SimpleObjectProperty<UserDetails> userDetailsProperty() {
        return userDetails;
    }

    public SimpleStringProperty userRolesProperty() {
        return userRoles;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm.set(passwordConfirm);
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails.set(userDetails);
    }

    public void setUserRoles(String userRoles) {
        this.userRoles.set(userRoles);
    }
}
