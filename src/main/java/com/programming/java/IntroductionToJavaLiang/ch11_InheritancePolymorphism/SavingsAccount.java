package com.programming.java.IntroductionToJavaLiang.ch11_InheritancePolymorphism;

import com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses.Account;

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
