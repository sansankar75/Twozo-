package com.example.SaveMySpot.view;

import com.example.SaveMySpot.Enum.PaymentMethod;
import com.example.SaveMySpot.common.ConsoleReader;
import com.example.SaveMySpot.entity.Payment;
import com.example.SaveMySpot.exception.PaymentException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentView {

    public Payment showPayment() {
        Payment payment = new Payment();

        System.out.println("\n==========================================");
        System.out.println("                PAYMENT");
        System.out.println("==========================================");
        payment.setPaymentMethod(selectPaymentMethod());
        payment.setPaymentDate(LocalDateTime.now());
        System.out.print("Amount : ");
        payment.setAmount(BigDecimal.valueOf(ConsoleReader.SCANNER.nextInt()));
        System.out.println("==========================================");

        return payment;
    }

    public PaymentMethod selectPaymentMethod() {

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. UPI");
        System.out.println("4. Net Banking");
        System.out.println("5. Wallet");
        System.out.println("6. Cash");
        System.out.print("Choice : ");

        int choice = Integer.parseInt(ConsoleReader.SCANNER.nextLine());

        return switch (choice) {
            case 1 -> PaymentMethod.CREDIT_CARD;
            case 2 -> PaymentMethod.DEBIT_CARD;
            case 3 -> PaymentMethod.UPI;
            case 4 -> PaymentMethod.NET_BANKING;
            case 5 -> PaymentMethod.WALLET;
            case 6 -> PaymentMethod.CASH;
            default -> throw new PaymentException("Invalid Payment Method");
        };
    }

    public void displayReceipt(Payment payment) {

        System.out.println("\n==========================================");
        System.out.println("             PAYMENT RECEIPT");
        System.out.println("==========================================");
        System.out.println("Payment ID     : " + payment.getPaymentId());
        System.out.println("Booking ID     : " + payment.getBookingId());
        System.out.println("Amount         : ₹" + payment.getAmount());
        System.out.println("Payment Method : " + payment.getPaymentMethod());
        System.out.println("Payment Time   : " + payment.getPaymentDate());
        System.out.println("Status         : " + payment.getPaymentStatus());

        System.out.println("==========================================");
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}