package com.pacgame.data.model;

import java.util.Set;

public class ResponseError {

    private String status;
    private String message;
    private Set<SubError> errors;

    public ResponseError() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<SubError> getErrors() {
        return errors;
    }

    public void setErrors(Set<SubError> errors) {
        this.errors = errors;
    }
}
