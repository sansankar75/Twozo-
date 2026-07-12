package com.example.SaveMySpot.service.Interface;

import com.example.SaveMySpot.model.Payment;

public interface PaymentService {

    Payment processPayment(Payment payment);
    String getPaymentStatus(int paymentId);

}
