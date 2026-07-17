package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Payment;
import com.example.SaveMySpot.repo.PaymentRepository;
import com.example.SaveMySpot.repo.PaymentRepositoryImpl;

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository = new PaymentRepositoryImpl();

    @Override
    public Payment processPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null.");
        }
        paymentRepository.save(payment);

        return payment;
    }

    @Override
    public String getPaymentStatus(int bookingId) {
        Payment payment = paymentRepository.findByBooking(bookingId);

        if (payment == null) {
            return "Payment Not Found";
        }

        return payment.getPaymentStatus().name();
    }
}