package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Booking;

import java.util.List;

public interface BookingRepository {

    void save(Booking booking);
    Booking findById(int bookingId);
    List<Booking> findByUser(int userId);

}
