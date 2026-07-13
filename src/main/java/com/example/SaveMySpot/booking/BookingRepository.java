package com.example.SaveMySpot.booking;

import java.util.List;

public interface BookingRepository {

    void save(Booking booking);
    Booking findById(int bookingId);
    List<Booking> findByUser(int userId);

}
