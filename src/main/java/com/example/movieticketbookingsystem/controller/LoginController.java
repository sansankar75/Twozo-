package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.view.LoginView;
import com.example.movieticketbookingsystem.validation.UserValidation;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.loggersystem.UserLogger;
import com.example.movieticketbookingsystem.exceptionhandler.user.InvalidLoginException;

public class LoginController {
    private static LoginView loginView;
    private static UserValidation userValidation;

    public LoginController(){
        loginView = new LoginView();
        userValidation = new UserValidation();
    }

    public void userLogin(){
        loginView.show();
    }

}
