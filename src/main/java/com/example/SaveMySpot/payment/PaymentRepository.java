package com.example.SaveMySpot.payment;

public interface PaymentRepository {

    void save(Payment payment);
    Payment findByBooking(int bookingId);

}
