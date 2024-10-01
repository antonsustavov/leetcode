package com.sustav.ALGORITHM.pattern.behavioral.chain_of_responcibility.bank;

import java.math.BigDecimal;

public class BankPaymentHandler extends PaymentHandler {
    @Override
    public void handlePayment(BigDecimal amount) {
        if (BigDecimal.valueOf(500).compareTo(amount) < 0) {
            System.out.println("Paind using account");
        } else {
            next.handlePayment(amount);
        }
    }
}
