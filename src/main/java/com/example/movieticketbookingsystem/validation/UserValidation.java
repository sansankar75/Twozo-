package com.example.movieticketbookingsystem.validation;

import com.example.movieticketbookingsystem.util.VerifyPassword;
import com.example.movieticketbookingsystem.repository.UserRepository;

public class UserValidation {

    boolean authenticateUser(String userName, String password){
        boolean isUserNameValid = UserRepository.getUserName(userName);
        boolean isPasswordValid = VerifyPassword.verifyPassword(password, UserRepository.getUserPassword(userName));

        if(isUserNameValid & isPasswordValid){
            return true;
        }else{
            return false;
        }
    }

}
