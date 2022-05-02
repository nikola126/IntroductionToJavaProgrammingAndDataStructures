package com.programming.java.chapter11;

import com.programming.java.chapter10.MyDate;

public class Staff extends Employee {
    private String title;

    public Staff() {
    }

    public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, MyDate dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Staff Name: " + this.getName();
    }
}
