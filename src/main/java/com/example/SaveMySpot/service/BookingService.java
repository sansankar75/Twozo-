package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking, List<Integer> seatIds);
    void cancelBooking(int bookingId);
    boolean checkAvailability(int showId);

    List<Booking> getBookingsByUser(int userId);

    BigDecimal getTotalPrice(int bookingId);

    Booking getBookingById(int bookingId);
}
