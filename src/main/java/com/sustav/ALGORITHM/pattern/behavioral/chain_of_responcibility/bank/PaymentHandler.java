package com.sustav.ALGORITHM.pattern.behavioral.chain_of_responcibility.bank;

import java.math.BigDecimal;

public abstract class PaymentHandler {

    protected PaymentHandler next;

    public void setNext(PaymentHandler next) {
        this.next = next;
    }

    public abstract void handlePayment(BigDecimal amount);
}
