package com.programming.java.chapter11;

import com.programming.java.chapter9.Account;

public class CheckingAccount extends Account {
    private final double OVERDRAFT;

    public CheckingAccount(int id, double balance, double OVERDRAFT) {
        super(id, balance);
        this.OVERDRAFT = OVERDRAFT;
    }

    @Override
    public double withdraw(double amount) {
        if (Math.abs(this.getBalance() - amount) <= OVERDRAFT)
            return super.withdraw(amount);
        else
            return 0;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "OVERDRAFT=" + OVERDRAFT +
                '}' + super.toString();
    }
}
