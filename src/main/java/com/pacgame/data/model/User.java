package com.pacgame.data.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Set;

public class User {

    private SimpleStringProperty id;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty passwordConfirm;
    private boolean acceptTerms;

    private SimpleObjectProperty<UserDetails> userDetails;

    private SimpleStringProperty userRoles;

    public User() {

        id = new SimpleStringProperty();
        email = new SimpleStringProperty();
        password = new SimpleStringProperty();
        passwordConfirm = new SimpleStringProperty();
        userDetails = new SimpleObjectProperty<>();
        userRoles = new SimpleStringProperty();

        setUserDetails(new UserDetails());
    }

    public String getId() {
        return idProperty().get();
    }


    public String getEmail() {
        return emailProperty().get();
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

    public SimpleStringProperty emailProperty() {
        return email;
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

    public void setEmail(String email) {
        this.email.set(email);
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
