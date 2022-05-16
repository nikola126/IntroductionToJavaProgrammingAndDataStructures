package com.programming.java.IntroductionToJavaNakov.ch14_Classes.students;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Student {
    public static int totalStudents = 0;
    private String firstName;
    private String middleName;
    private String lastName;
    private short year;
    private Major major;
    private University university;
    private String email;
    private String phoneNumber;


    public Student(String firstName, String middleName, String lastName, short year, Major major, University university, String email, String phoneNumber) {
        totalStudents += 1;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.year = year;
        this.major = major;
        this.university = university;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(String firstName, String middleName, String lastName, String email, String phoneNumber) {
        totalStudents += 1;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student() {
        totalStudents += 1;
    }

    public void getInfo() {
        System.out.printf("%s %s %s\n", this.firstName, this.middleName, this.lastName);
        System.out.printf("Phone number: %s\tEmail: %s", this.phoneNumber, this.email);
        System.out.printf("%d year %s student in %s", this.year, this.major, this.university);
    }

    public int getTotalStudents() {
        return totalStudents;
    }
}
