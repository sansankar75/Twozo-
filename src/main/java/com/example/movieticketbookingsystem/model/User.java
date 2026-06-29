package com.example.movieticketbookingsystem.model;

import lombok.Builder;
import lombok.Getter;

import org.mindrot.jbcrypt.BCrypt;

@Getter
@Builder
public class User {

    private final String userName;
    private final String password;

    public static class UserBuilder {

        public UserBuilder password(String rawPassword) {
            this.password = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
            return this;
        }

    }
}
