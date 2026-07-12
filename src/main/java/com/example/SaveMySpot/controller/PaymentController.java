package com.example.SaveMySpot.controller;

import com.example.SaveMySpot.model.Payment;
import com.example.SaveMySpot.service.Implement.PaymentServiceImpl;
import com.example.SaveMySpot.service.Interface.PaymentService;
import com.example.SaveMySpot.view.user.PaymentView;

public class PaymentController {

    private final PaymentView paymentView;
    private final PaymentService paymentService;

    public PaymentController() {
        paymentView = new PaymentView();
        paymentService = new PaymentServiceImpl();
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