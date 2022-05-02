package com.programming.java.chapter11;

import java.util.Date;

public class Transaction {
    Date date;
    char type;
    double amount;
    double balance;
    String description;

    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}
