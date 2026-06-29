package com.example.movieticketbookingsystem.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Movie {

    private final String movieName;
    private final String time;
    private final List<String> seats;

}
