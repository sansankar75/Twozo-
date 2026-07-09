package com.example.SaveMySpot.exceptionhandler.movie;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(String message) {
        super(message);
    }
}
