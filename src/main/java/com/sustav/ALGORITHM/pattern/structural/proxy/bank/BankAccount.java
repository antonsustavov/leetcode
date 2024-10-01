package com.sustav.ALGORITHM.pattern.structural.proxy.bank;

public class BankAccount implements Account {
    @Override
    public void withdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw();
    }

    @Override
    public String accountNumber() {
        return null;
    }
}
