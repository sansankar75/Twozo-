package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.service.PaymentService;
import com.example.SaveMySpot.service.PaymentServiceImpl;
import com.example.SaveMySpot.view.PaymentView;
import com.example.SaveMySpot.entity.Payment;

public class PaymentController {
    private final PaymentView paymentView;
    private final PaymentService paymentService;

    public PaymentController(PaymentView paymentView, PaymentService paymentService) {

        this.paymentView = paymentView;
        this.paymentService = paymentService;
    }
    public Payment processPayment(Payment payment) {
        Payment savedPayment = paymentService.processPayment(payment);
        paymentView.showMessage("Payment successful.");

        return savedPayment;
    }
    public String getPaymentStatus(int paymentId) {
        return paymentService.getPaymentStatus(paymentId);
    }
}