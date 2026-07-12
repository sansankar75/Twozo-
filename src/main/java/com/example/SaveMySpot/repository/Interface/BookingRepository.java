package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Booking;

import java.util.List;

public interface BookingRepository {

    void save(Booking booking);
    Booking findById(int bookingId);
    List<Booking> findByUser(int userId);

}
