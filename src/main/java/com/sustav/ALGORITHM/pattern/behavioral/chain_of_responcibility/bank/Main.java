package com.sustav.ALGORITHM.pattern.behavioral.chain_of_responcibility.bank;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankPaymentHandler bankPaymentHandler = new BankPaymentHandler();
        CreditCardPaymentHandler creditCardPaymentHandler = new CreditCardPaymentHandler();
        bankPaymentHandler.setNext(creditCardPaymentHandler);

        bankPaymentHandler.handlePayment(BigDecimal.valueOf(300));
    }
}
