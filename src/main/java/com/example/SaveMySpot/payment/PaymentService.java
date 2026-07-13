package com.example.SaveMySpot.payment;

public interface PaymentService {

    Payment processPayment(Payment payment);
    String getPaymentStatus(int paymentId);

}
