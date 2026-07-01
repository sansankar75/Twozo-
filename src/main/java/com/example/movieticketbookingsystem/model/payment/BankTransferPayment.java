package com.example.movieticketbookingsystem.model.payment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankTransferPayment {

    private final String accountNumber;
    private final String bankName;
    private final String ifscCode;
    private final String firstName;
    private final String lastName;

}
