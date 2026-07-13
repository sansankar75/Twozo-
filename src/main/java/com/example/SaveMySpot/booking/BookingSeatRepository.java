package com.example.SaveMySpot.booking;

import java.util.List;

public interface BookingSeatRepository {

    void save(BookingSeat bookingSeat);
    List<BookingSeat> findByBooking(int bookingId);

}
