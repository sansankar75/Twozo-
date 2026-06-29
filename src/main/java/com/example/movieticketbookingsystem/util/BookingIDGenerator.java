package com.example.movieticketbookingsystem.util;

import java.util.UUID;

public class BookingIDGenerator {

    public String bookingID() {
        return UUID.randomUUID().toString();
    }
}
