package com.example.SaveMySpot.service.Implement;

import com.example.SaveMySpot.model.Payment;
import com.example.SaveMySpot.repository.Implement.PaymentRepositoryImpl;
import com.example.SaveMySpot.repository.Interface.PaymentRepository;
import com.example.SaveMySpot.service.Interface.PaymentService;

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