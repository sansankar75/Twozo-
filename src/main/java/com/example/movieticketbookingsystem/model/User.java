package com.example.movieticketbookingsystem.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private final String userName;
    private final String password;
}
