package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);
    void cancelBooking(int bookingId);
    boolean checkAvailability(int showId);

}
