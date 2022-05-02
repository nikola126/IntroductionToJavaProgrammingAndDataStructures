package com.programming.java.chapter11;

import com.programming.java.chapter9.Account;

public class SavingsAccount extends Account {

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public double withdraw(double amount) {
        if (this.getBalance() - amount < 0)
            return 0;
        else
            return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount{}" + super.toString();
    }
}
