package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);
    void cancelBooking(int bookingId);
    boolean checkAvailability(int showId);

}
