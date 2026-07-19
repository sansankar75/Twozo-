package com.example.SaveMySpot.repo;

import com.example.SaveMySpot.entity.Payment;

import java.util.List;

public interface PaymentRepository {

    void save(Payment payment);
    Payment findByBooking(int bookingId);

    Payment getPaymentByBooking(int bookingId);

    List<Payment> getPaymentsByStatus(String status);

    Payment getPaymentByTransactionId(String transactionId);

    double getTotalRevenue();

    void update(Payment payment);
}
