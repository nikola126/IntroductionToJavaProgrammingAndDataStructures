package com.programming.java.IntroductionToJavaLiang.ch5_Loops;

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

    public void taskEight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int NUMBER_OF_STUDENTS = scanner.nextInt();

        if (NUMBER_OF_STUDENTS < 1)
            return;

        int maxScore = Integer.MIN_VALUE;
        String studentWithMaxScore = "";

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.printf("Enter student [%d/%d] name and score: \n", i + 1, NUMBER_OF_STUDENTS);
            String name = scanner.next();
            int score = scanner.nextInt();

            if (score >= maxScore) {
                maxScore = score;
                studentWithMaxScore = name;
            }
        }

        System.out.printf("Student with max score (%d): %s\n", maxScore, studentWithMaxScore);
    }

    public void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int NUMBER_OF_STUDENTS = scanner.nextInt();

        if (NUMBER_OF_STUDENTS < 1)
            return;

        int maxScore = Integer.MIN_VALUE;
        int secondMaxScore = Integer.MIN_VALUE;
        String studentWithMaxScore = "";
        String studentWithSecondMaxScore = "";

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.printf("Enter student [%d/%d] name and score: \n", i + 1, NUMBER_OF_STUDENTS);
            String name = scanner.next();
            int score = scanner.nextInt();

            if (score >= maxScore) {
                studentWithSecondMaxScore = studentWithMaxScore;
                secondMaxScore = maxScore;

                maxScore = score;
                studentWithMaxScore = name;
            }
        }

        System.out.printf("Student with max score (%d): %s\n", maxScore, studentWithMaxScore);
        System.out.printf("Student with second max score (%d): %s\n", secondMaxScore, studentWithSecondMaxScore);
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

    public void taskThirteen() {
        int n = 1;
        while (Math.pow(n, 3) <= 12000) {
            n += 1;
        }
        System.out.println("The largest N is: " + n);
        System.out.println("N^3 = " + Math.pow(n, 3));
    }

    public void taskFourteen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n1: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter n2: ");
        int n2 = scanner.nextInt();

        int gcd = 1;
        int d = Math.min(n1, n2);
        for (int i = d; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0)
                gcd = Math.max(gcd, i);
        }

        System.out.printf("The GCD of %d and %d is: %d\n", n1, n2, gcd);
    }

    public void taskFifteen() {
        char c = '!';

        int n = 0;
        while (c != '~') {
            System.out.printf("%c ", c);
            n++;
            if (n == 10) {
                System.out.println();
                n = 0;
            }
            c += 1;
        }
    }

    public void taskSixteen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int N = scanner.nextInt();
        int factor = 2;

        while (N != 1) {
            if (N % factor == 0) {
                System.out.printf("%d ", factor);
                N /= factor;
            } else {
                factor += 1;
            }
        }
    }

    public void taskSeventeen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6 - i; j++)
                System.out.print("  ");
            for (int j = i; j >= 1; j--)
                System.out.printf("%d ", j + 1);
            for (int j = 0; j <= i; j++)
                System.out.printf("%d ", j + 1);

            System.out.println();
        }
    }

    public void taskEighteen() {
        System.out.println("Pattern A");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }

        System.out.println();
        System.out.println("Pattern B");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }

        System.out.println();
        System.out.println("Pattern C");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++)
                System.out.print("  ");
            for (int j = i; j >= 0; j--)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }

        System.out.println();
        System.out.println("Pattern D");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++)
                System.out.print("  ");
            for (int j = 0; j < 6 - i; j++)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }
    }

    public void taskNineteen() {
        int N = 8;
        int leftMultiplier = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++)
                System.out.print("\t");
            for (int j = i; j >= 1; j--) {
                System.out.printf("%d\t", leftMultiplier);
                leftMultiplier *= 2;
            }

            int rightMultiplier = leftMultiplier;

            for (int j = 0; j <= N; j++) {
                if (rightMultiplier > 0)
                    System.out.printf("%d\t", rightMultiplier);
                rightMultiplier /= 2;
            }

            System.out.println();
            leftMultiplier = 1;
        }
    }

    public void taskTwenty() {
        final int NUMBER_OF_PRIMES_PER_LINE = 8; // Display 10 per line
        int count = 0;
        int number = 2; // A number to be tested for primeness

        System.out.println("The prime numbers between 2 and 1000 are \n");

        // Repeatedly find prime numbers
        while (number <= 1000) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test whether number is prime
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Display the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count
                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    // Display the number and advance to the new line
                    System.out.println(number);
                    count = 0;
                } else
                    System.out.print(number + " ");
            }

            // Check if the next number is prime
            number++;
        }
    }

    public void printAll() {
        System.out.println(this.getClass().getName());
        taskOne();
        System.out.println();
        taskTwo();
        System.out.println();
        taskThree();
        System.out.println();
        taskFour();
        System.out.println();
        taskFive();
        System.out.println();
        taskSix();
        System.out.println();
        taskSeven();
        System.out.println();
        taskEight();
        System.out.println();
        taskNine();
        System.out.println();
        taskTen();
        System.out.println();
        taskEleven();
        System.out.println();
        taskTwelve();
        System.out.println();
        taskThirteen();
        System.out.println();
        taskFourteen();
        System.out.println();
        taskFifteen();
        System.out.println();
        taskSixteen();
        System.out.println();
        taskSeventeen();
        System.out.println();
        taskEighteen();
        System.out.println();
        taskNineteen();
        System.out.println();
        taskTwenty();
        System.out.println();
    }
}