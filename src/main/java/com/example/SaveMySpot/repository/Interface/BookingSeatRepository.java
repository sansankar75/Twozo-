package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.BookingSeat;

import java.util.List;

public interface BookingSeatRepository {

    void save(BookingSeat bookingSeat);
    List<BookingSeat> findByBooking(int bookingId);

}
