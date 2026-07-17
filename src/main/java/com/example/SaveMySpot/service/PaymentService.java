package com.example.SaveMySpot.service;

import com.example.SaveMySpot.entity.Payment;

public interface PaymentService {

    Payment processPayment(Payment payment);
    String getPaymentStatus(int paymentId);

}
