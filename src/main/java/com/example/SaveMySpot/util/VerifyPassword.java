package com.example.SaveMySpot.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class VerifyPassword {

    public static boolean verifyPassword(String password,String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(password, hashedPassword);
    }
}
