package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.model.Ticket;
import com.example.movieticketbookingsystem.util.BookingIDGenerator;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private static final Map<String, Ticket> userTicket = new HashMap<>();

    BookingIDGenerator bookingIDGenerator = new BookingIDGenerator();

    public void addTicket(Ticket ticket){
        String bookID = bookingIDGenerator.bookingID();
        userTicket.put(bookID, ticket);
    }

}
