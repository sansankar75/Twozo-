package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Payment;

public interface PaymentRepository {

    void save(Payment payment);
    Payment findByBooking(int bookingId);

}
