package com.example.SaveMySpot.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {
    static BCryptPasswordEncoder encoder;

    public PasswordHashing(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    }
    public static String hashPassword(String password){

        return encoder.encode(password);
    }

}
