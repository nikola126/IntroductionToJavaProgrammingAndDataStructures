package com.programming.java.IntroductionToJavaLiang.ch11_InheritancePolymorphism;

import java.util.ArrayList;

public class CourseList {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents;

    public CourseList(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students.toArray(String[]::new);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Left as an exercise in Programming Exercise 10.9
        students.remove(student);
    }

    public void clear() {
        students = new ArrayList<>();
        numberOfStudents = 0;
    }
}