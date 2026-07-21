package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Booking;
import com.example.SaveMySpot.entity.BookingSeat;

import java.util.List;

public interface BookingRepository {

    void save(Booking booking);
    Booking findById(int bookingId);

    List<Booking> getBookingsByUser(int userId);

    List<Booking> getBookingsByShow(int showId);

    List<Booking> getBookingsByStatus(String status);

    List<Booking> getUserBookingHistory(int userId);

    long countBookingsByUser(int userId);

    void update(Booking booking);

    void cancelBooking(int bookingId);

    List<BookingSeat> findByBooking(int bookingId);
}
