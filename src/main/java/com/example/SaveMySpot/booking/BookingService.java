package com.example.SaveMySpot.booking;

public interface BookingService {

    Booking createBooking(Booking booking);
    void cancelBooking(int bookingId);
    boolean checkAvailability(int showId);

}
