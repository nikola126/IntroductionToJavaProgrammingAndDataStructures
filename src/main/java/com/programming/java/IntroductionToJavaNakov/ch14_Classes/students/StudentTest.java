package com.programming.java.IntroductionToJavaNakov.ch14_Classes.students;

public class StudentTest {
    private static Student[] students;

    public StudentTest(int count) {
        students = new Student[count];
        for (int i = 0; i < count; i++) {
            students[i] = new Student();
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return students[0].getTotalStudents();
    }
}
