package com.example.movieticketbookingsystem.exceptionhandler;

public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
