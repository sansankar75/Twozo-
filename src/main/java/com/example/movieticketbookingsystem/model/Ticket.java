package com.example.movieticketbookingsystem.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class Ticket {

    private final String movieName;
    private final String tickedId;
    private final String[] seats;
    private final LocalDate date;
}
