package com.programming.java.IntroductionToJavaNakov.ch14_Classes;

import com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm.GSMCallHistoryTest;
import com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm.GSMTest;
import com.programming.java.IntroductionToJavaNakov.ch14_Classes.library.LibraryTest;
import com.programming.java.IntroductionToJavaNakov.ch14_Classes.school.SchoolTest;
import com.programming.java.IntroductionToJavaNakov.ch14_Classes.students.StudentTest;

import java.util.Arrays;

public class ChapterFourteen {
    public static void taskSeven() {
        StudentTest studentTest = new StudentTest(3);
        System.out.println(Arrays.toString(studentTest.getStudents()));
        System.out.println(studentTest.getNumberOfStudents());
    }

    public static void taskTwelve() {
        GSMTest gsmTest = new GSMTest(5);
        System.out.println(Arrays.toString(gsmTest.getGSMs()));
        System.out.println(gsmTest.getNumberOfGSMs());
        System.out.println(gsmTest.getGSMs()[0].getNokiaN95());
    }

    public static void taskSeventeen() {
        new GSMCallHistoryTest();
    }

    public static void taskNineteen() {
        new LibraryTest();
    }

    public static void taskTwenty() {
        new SchoolTest();
    }

    public static void main(String[] args) {
        taskSeven();
        taskTwelve();
        taskSeventeen();
        taskNineteen();
        taskTwenty();
    }
}
