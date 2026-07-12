package com.example.SaveMySpot.repository.Interface;

import com.example.SaveMySpot.model.Payment;

public interface PaymentRepository {

    void save(Payment payment);
    Payment findByBooking(int bookingId);

}
