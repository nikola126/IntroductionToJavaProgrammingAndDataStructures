package com.programming.java.IntroductionToJavaLiang.ch10_OOThinking;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    private String courseName;
    private String[] students = new String[2];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents > students.length) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return Arrays.copyOf(students, numberOfStudents);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Left as an exercise in Programming Exercise 10.9
        String[] newStudents = new String[numberOfStudents - 1];
        int idx = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            if (!Objects.equals(students[i], student)) {
                newStudents[idx++] = students[i];
            }
        }
        numberOfStudents--;
        students = newStudents;
    }

    public void clear() {
        students = new String[2];
        numberOfStudents = 2;
    }
}