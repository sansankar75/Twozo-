package com.example.SaveMySpot.validation;

import com.example.SaveMySpot.util.VerifyPassword;
import com.example.SaveMySpot.repository.InMemory.UserRepository;

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
