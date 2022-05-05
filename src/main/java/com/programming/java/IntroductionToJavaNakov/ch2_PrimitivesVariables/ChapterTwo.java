package com.programming.java.IntroductionToJavaNakov.ch2_PrimitivesVariables;

public class ChapterTwo {
    public static void taskOne() {
        int positiveOne = 52130;
        byte negativeOne = -115;
        int positiveTwo = 4825832;
        byte positiveThree = 97;
        short negativeTwo = -10000;
    }

    public static void taskTwo() {
        double doubleOne = 34.567839023;
        float floatOne = 12.345f;
        double doubleTwo = 8923.1234857;
        float floatTwo = 3456.091f;

        System.out.println(doubleOne);
        System.out.println(floatOne);
        System.out.println(doubleTwo);
        System.out.println(floatTwo);
    }

    public static void taskThree() {
        int hex100 = 0x100;
        System.out.println("0x100 in decimal: " + hex100);
    }

    public static void taskFour() {
        boolean isMale = true;
        System.out.println("isMale: " + isMale);
    }

    public static void taskFive() {
        String hello = "Hello";
        String world = "World";
        Object concatenation = hello + " " + world;
        System.out.println(concatenation);
        String asString = (String) concatenation; // casting required
        System.out.println(asString);
    }

    public static void taskSix() {
        String output = "The \"use\" of quotations causes difficulties";
        System.out.println(output);
    }

    public static void taskSeven() {
        System.out.println("     *     ");
        System.out.println("    * *    ");
        System.out.println("   *   *   ");
        System.out.println("  *     *  ");
        System.out.println(" *       * ");
        System.out.println("***********");
    }

    public static void taskEight() {
        System.out.println("  o      o  ");
        System.out.println(" o  o  o  o ");
        System.out.println("  o      o  ");
        System.out.println("   o    o   ");
        System.out.println("    o  o    ");
        System.out.println("      o     ");
    }

    public static void taskNine() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        short age = 30;
        char gender = 'M';
        int ID = 27560000;
        int UUID = 27569999;

        System.out.println("Names: " + firstName + " " + lastName);
        System.out.println("Gender: " + gender + " Age: " + age);
        System.out.println("ID: " + ID);
        System.out.println("UUID: " + UUID);
    }

    public static void taskTen() {
        int a = 5;
        int b = 10;

        System.out.println("A = " + a + " B = " + b);

        int c = a;
        a = b;
        b = c;

        System.out.println("A = " + a + " B = " + b);
    }

    public static void printAll() {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
        taskEight();
        taskNine();
        taskTen();
    }

    public static void main(String[] args) {
        printAll();
    }
}
