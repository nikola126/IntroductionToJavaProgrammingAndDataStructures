package com.programming.java.IntroductionToJavaNakov.ch4_ConsoleIO;

import java.util.Scanner;

public class ChapterFour {
    public static void taskOne() {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter integer [%d/%d]: ", i + 1, 3);
            sum += scanner.nextInt();
        }

        System.out.println("Sum: " + sum);
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        double perimeter = 2.0 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }

    public static void taskThree() {
        String companyName, companyAddress, companyPhoneNumber, companyFaxNumber, companyWebsite;
        String managerFirstName, managerLastName, managerPhoneNumber;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter company name: ");
        companyName = scanner.next();
        System.out.print("Enter company address:");
        companyAddress = scanner.next();
        System.out.print("Enter company phone number: ");
        companyPhoneNumber = scanner.next();
        System.out.print("Enter company fax number: ");
        companyFaxNumber = scanner.next();

        System.out.print("Enter manager first name: ");
        managerFirstName = scanner.next();
        System.out.print("Enter manager last name: ");
        managerLastName = scanner.next();
        System.out.print("Enter manager phone number: ");
        managerPhoneNumber = scanner.next();

        System.out.println("----- ----- -----");
        System.out.println(companyName);
        System.out.println(companyAddress);
        System.out.println("Phone: " + companyPhoneNumber);
        System.out.println("Fax: " + companyFaxNumber);
        System.out.println("----- ----- -----");
        System.out.println("Manager: " + managerFirstName + " " + managerLastName);
        System.out.println("Phone: " + managerPhoneNumber);
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer 1: ");
        int numOne = scanner.nextInt();
        System.out.print("Enter integer 2: ");
        int numTwo = scanner.nextInt();

        int divisibleBy5 = 0;

        if (numOne % 5 == 0)
            divisibleBy5 += 1;
        if (numTwo % 5 == 0)
            divisibleBy5 += 1;

        while (numOne % 5 != 0) {
            numOne += 1;
        }

        while (numTwo % 5 != 0) {
            numTwo -= 1;
        }

        int difference = numTwo - numOne;
        divisibleBy5 += difference / 5;

        System.out.println("Numbers divisible by 5: " + divisibleBy5);
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer 1: ");
        int a = scanner.nextInt();
        System.out.print("Enter integer 2: ");
        int b = scanner.nextInt();

        a = a - b;
        b = b + a;
        a = b - a;

        System.out.println(a + " > " + b);
    }

    public static void taskSix() {
        float sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, 5);
            sum += scanner.nextFloat();
        }

        System.out.println("Sum: " + sum);
    }

    public static void taskSeven() {
        double max = Double.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, 5);
            double number = scanner.nextDouble();
            max = Math.max(max, number);
        }

        System.out.println("Max: " + max);
    }

    public static void printAll() {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
    }

    public static void main(String[] args) {
        printAll();
    }
}
