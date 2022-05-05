package com.programming.java.IntroductionToJavaLiang.ch11_InheritancePolymorphism;

import java.util.ArrayList;
import java.util.Date;

public class AccountWithHistory {
    private int id;
    private String name;
    private double balance;
    private Date dateCreated;

    private ArrayList<Transaction> transactions;

    private double annualInterestRate;

    public double withdraw(double amount) {
        double newBalance = this.balance - amount;
        this.balance = newBalance;
        this.transactions.add(new Transaction(new Date(), 'W', amount, newBalance, "Made a withdrawal"));
        return newBalance;
    }

    public double deposit(double amount) {
        double newBalance = this.balance + amount;
        this.balance = newBalance;
        this.transactions.add(new Transaction(new Date(), 'D', amount, newBalance, "Made a deposit"));
        return newBalance;
    }

    public AccountWithHistory(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.dateCreated = new Date();
        this.transactions = new ArrayList<>();
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 12;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Transaction transaction : transactions) {
            stringBuilder.append(transaction.toString());
            stringBuilder.append("\n");
        }
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                ", annualInterestRate=" + annualInterestRate +
                '}' + "\n" + stringBuilder.toString();
    }
}
