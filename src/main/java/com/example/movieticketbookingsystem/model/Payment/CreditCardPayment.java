package com.example.movieticketbookingsystem.model.Payment;

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
