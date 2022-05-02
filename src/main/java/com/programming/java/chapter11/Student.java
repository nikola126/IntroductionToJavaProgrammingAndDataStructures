package com.programming.java.chapter11;

public class Student extends Person {
    private final String status;

    public Student(String status) {
        this.status = status;
    }

    public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
