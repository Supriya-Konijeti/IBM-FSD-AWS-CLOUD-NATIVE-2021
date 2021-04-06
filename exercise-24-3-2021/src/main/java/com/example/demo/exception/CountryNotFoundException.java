package com.example.demo.exception;

public class CountryNotFoundException extends RuntimeException {
    private String message;

    public CountryNotFoundException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
