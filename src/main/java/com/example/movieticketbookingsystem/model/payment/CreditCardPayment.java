package com.example.movieticketbookingsystem.model.payment;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
public class CreditCardPayment {

    private final String cardNumber;
    private final String cardHolderName;
    private final LocalDate expiryDate;
    private final String cvv;

}
