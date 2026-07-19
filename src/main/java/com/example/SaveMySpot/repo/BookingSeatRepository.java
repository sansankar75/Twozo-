package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.BookingSeat;

import java.util.List;

public interface BookingSeatRepository {

    void save(BookingSeat bookingSeat);
    List<BookingSeat> findByBooking(int bookingId);

    List<BookingSeat> getSeatsByBooking(int bookingId);

    double getTotalPriceByBooking(int bookingId);

    void delete(int bookingSeatId);
}
