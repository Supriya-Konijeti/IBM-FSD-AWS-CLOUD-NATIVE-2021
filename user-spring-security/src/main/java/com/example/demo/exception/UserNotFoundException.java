package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
