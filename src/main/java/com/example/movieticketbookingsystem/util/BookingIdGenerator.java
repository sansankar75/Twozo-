package com.example.movieticketbookingsystem.util;

import java.util.UUID;

public class BookingIdGenerator {

    UUID bookingID() {
        return UUID.randomUUID();
    }
}
