package com.programming.java.chapter5;

import java.util.Scanner;

public class ChapterFive {
    public void taskOne() {
        Scanner scanner = new Scanner(System.in);
        int countPositive = 0, countNegative = 0, countAll = 0;
        double total = 0, average = 0;

        int input = scanner.nextInt();

        System.out.println("Enter an integer, input ends if [0]: ");
        while (input != 0) {
            countAll += 1;
            total += input;
            if (input > 0)
                countPositive += 1;
            else if (input < 0) {
                countNegative += 1;
            }
            input = scanner.nextInt();
        }

        if (countAll > 0) {
            System.out.println("The number of positives is: " + countPositive);
            System.out.println("The number of negatives is: " + countNegative);
            System.out.println("The total is: " + total);
            System.out.println("The average is: " + total / countAll);
        } else {
            System.out.println("No numbers are entered except 0!");
        }
    }

    public void taskTwo() {
        final int NUMBER_OF_QUESTIONS = 10; // Number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();
        String output = " "; // output string is initially empty
        Scanner input = new Scanner(System.in);

        while (count < NUMBER_OF_QUESTIONS) {
            // 1. Generate two random single-digit integers
            int number1 = (int) (1 + Math.random() * 14);
            int number2 = (int) (1 + Math.random() * 14);

            // 3. Prompt the student to answer "What is number1 + number2?"
            System.out.print(
                    "What is " + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            // 4. Grade the answer and display the result
            if (number1 + number2 == answer) {
                System.out.println("You are correct!");
                correctCount++; // Increase the correct answer count
            } else
                System.out.println("Your answer is wrong.\n" + number1 + " + " + number2 + " should be " + (number1 + number2));

            // Increase the question count
            count++;

            output += "\n" + number1 + "+" + number2 + "=" + answer + ((number1 + number2 == answer) ? " correct" : " wrong");
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount +
                "\nTest time is " + testTime / 1000 + " seconds\n" + output);
    }

    public void taskThree() {
        System.out.printf("%10s\t%10s\n", "Kilograms", "Pounds");
        for (int i = 1; i < 199; i += 2) {
            System.out.printf("%10d\t%10f\n", i, i * 2.2);
        }
    }

    public void taskFour() {
        System.out.printf("%10s\t%10s\n", "Miles", "Kilometers");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%10d\t%10f\n", i, i * 1.609);
        }
    }

    public void taskFive() {
        int kilograms = 1;
        int pounds = 20;

        System.out.printf("%10s\t%10s|%10s\t%10s\n", "Kilograms", "Pounds", "Pounds", "Kilograms");
        while (kilograms <= 199 && pounds <= 515) {
            System.out.printf("%10d\t%10.1f|%10d\t%10.2f\n", kilograms, kilograms * 2.2, pounds, pounds / 2.2);
            kilograms += 2;
            pounds += 5;
        }
    }

    public void taskSix() {
        int miles = 1;
        int kilometers = 20;

        System.out.printf("%10s\t%10s|%10s\t%10s\n", "Miles", "Kilometers", "Kilometers", "Miles");
        while (miles <= 10 && kilometers <= 65) {
            System.out.printf("%10d\t%10.3f|%10d\t%10.3f\n", miles, miles * 1.609, kilometers, kilometers / 1.609);
            miles += 1;
            kilometers += 5;
        }
    }

    public void taskSeven() {
        double tuition = 10000;
        double percentageIncrease = 5;

        double tuitionAfterTenYears = tuition;
        for (int year = 0; year < 10; year++) {
            tuitionAfterTenYears += (percentageIncrease / 100) * tuitionAfterTenYears;
        }

        double totalCostForFourYearsAfterTenYears = 0;
        for (int year = 0; year < 4; year++) {
            totalCostForFourYearsAfterTenYears += tuitionAfterTenYears;
            tuitionAfterTenYears += (percentageIncrease / 100) * tuitionAfterTenYears;
        }

        System.out.println("Tuition after 10 years: " + tuitionAfterTenYears);
        System.out.println("Total cost of 4 year tuition after the 10th year: " + totalCostForFourYearsAfterTenYears);
    }

    public void taskTen() {
        int count = 0;
        for (int i = 100; i <= 1000; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                System.out.printf("%d ", i);
                count += 1;
            }
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
    }

    public void taskEleven() {
        int count = 0;
        for (int i = 100; i <= 200; i++) {
            if (i % 5 == 0 || i % 6 == 0) {
                System.out.printf("%d ", i);
                count += 1;
            }
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }

    public void taskTwelve() {
        int n = 1;
        while (Math.pow(n, 2) <= 12000) {
            n += 1;
        }
        System.out.println("The smallest N is: " + n);
        System.out.println("N^2 = " + Math.pow(n, 2));
    }
}