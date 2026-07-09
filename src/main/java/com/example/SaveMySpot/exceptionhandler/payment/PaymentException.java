package com.example.SaveMySpot.exceptionhandler.payment;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
