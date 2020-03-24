package com.rest.exception;


public class NotHaveAccessTokenException extends RuntimeException {
    public NotHaveAccessTokenException(String message) {
        super(message);
    }
}