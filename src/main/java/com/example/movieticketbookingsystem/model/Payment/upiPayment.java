package com.example.movieticketbookingsystem.model.Payment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class upiPayment {

    private final String upiId;
    private final int amount;

}
