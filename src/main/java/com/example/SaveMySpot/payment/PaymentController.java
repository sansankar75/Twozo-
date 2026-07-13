package com.example.SaveMySpot.payment;

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