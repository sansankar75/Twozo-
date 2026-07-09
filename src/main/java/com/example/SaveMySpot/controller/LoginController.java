package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.view.LoginView;
import com.example.SaveMySpot.validation.UserValidation;

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
