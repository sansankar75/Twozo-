package com.example.movieticketbookingsystem.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class VerifyPassword {

    public Boolean verifyPassword(String password,String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(password, hashedPassword);
    }
}
