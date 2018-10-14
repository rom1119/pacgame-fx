package com.pacgame.data.model;

public class SubError {

    private String objectName;
    private String field;
    private String rejectedValue;
    private String message;

    public SubError(String objectName, String field, String rejectedValue, String message) {
        this.objectName = objectName;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
