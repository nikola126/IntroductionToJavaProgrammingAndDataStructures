package com.programming.java.chapter9;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private Date dateCreated;

    private double annualInterestRate;

    public double withdraw(double amount) {
        double newBalance = this.balance - amount;
        this.balance = newBalance;
        return newBalance;
    }

    public double deposit(double amount) {
        double newBalance = this.balance + amount;
        this.balance = newBalance;
        return newBalance;
    }

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
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
}
