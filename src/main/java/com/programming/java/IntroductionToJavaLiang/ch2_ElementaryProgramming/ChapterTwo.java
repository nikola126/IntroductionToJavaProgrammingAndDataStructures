package com.programming.java.IntroductionToJavaLiang.ch2_ElementaryProgramming;

import java.util.Scanner;

public class ChapterTwo {
    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (9.0 / 5) * celsius + 32;
        System.out.println("Fahrenheit: " + fahrenheit);
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius and length of a cylinder: ");
        double radius = scanner.nextDouble();
        double length = scanner.nextDouble();
        double area = radius * radius * Math.PI;
        System.out.println("Area: " + area);
        System.out.println("Volume: " + (area * length));
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter feet: ");
        double feet = scanner.nextDouble();
        System.out.println(feet + " feet is " + feet * 0.305 + " meters");
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number in pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " pounds is " + pounds * 0.454 + " kilograms");
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter subtotal and gratuity rate: ");
        double subtotal = scanner.nextDouble();
        double gratuityRate = scanner.nextDouble();
        System.out.println(
            "The gratuity is $" + gratuityRate / 10 + " and total is $" + (subtotal + gratuityRate / 10));
    }

    public static void taskSix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 1000: ");
        int n = scanner.nextInt();
        int sum = 0;
        int multiplier = 10;

        while (n > 0) {
            int digit = n % multiplier;
            sum += digit;
            n /= 10;
        }
        System.out.println("The sum of digits is " + sum);
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of minutes: ");
        long minutes = scanner.nextLong();
        long years = minutes / 60 / 24 / 365;
        long days = (minutes - (years * 365 * 24 * 60)) / 60 / 24;
        System.out.println(minutes + " is approximately " + years + " years and " + days + " days");
    }

    public static void taskEight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time zone offset to GMT: ");
        int offset = scanner.nextInt();

        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = totalHours % 24;
        currentHour -= offset;
        if (currentHour < 0)
            currentHour += 24;
        if (currentHour > 23)
            currentHour -= 24;

        // Display results
        System.out.println(
            "Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter v0, v1, and t: ");

        double v0 = scanner.nextDouble();
        double v1 = scanner.nextDouble();
        double t = scanner.nextDouble();

        double acceleration = (v1 - v0) / t;
        System.out.println("Average accelerations is " + acceleration);
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of water in kilograms: ");
        double waterKg = scanner.nextDouble();
        System.out.println("Enter initial temperature: ");
        double tempInit = scanner.nextDouble();
        System.out.println("Enter final temperature: ");
        double tempFinal = scanner.nextDouble();

        double energy = waterKg * (tempFinal - tempInit) * 4184;
        System.out.println("Energy needed is: " + energy);
    }

    public void taskEleven() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of years: ");
        int years = scanner.nextInt();

        double initial = 312032486;
        for (int year = 0; year < 5; year++) {
            double endOfYearDelta = 0;
            for (int i = 0; i < 365 * 24 * 60 * 60; i++) {
                if (i % 7 == 0) {
                    endOfYearDelta += 1;
                }
                if (i % 13 == 0) {
                    endOfYearDelta -= 1;
                }
                if (i % 45 == 0) {
                    endOfYearDelta += 1;
                }
            }
            initial += endOfYearDelta;
        }
        System.out.println("Population in " + years + " is " + initial);
    }

    public void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter speed and acceleration: ");
        double speed = scanner.nextDouble();
        double acceleration = scanner.nextDouble();

        double length = Math.pow(speed, 2) / (2 * acceleration);
        System.out.println("The minimum runway length for this airplane is: " + length);
    }

    public void taskThirteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter monthly saving amount: ");
        double amount = scanner.nextDouble();

        double value = amount;
        double interest = 5.0 / 100 / 12;
        for (int i = 0; i < 5; i++) {
            value = (amount + value) * (1 + interest);
        }
        System.out.println("After the sixth month, account value is: $" + value);
    }

    public void taskFourteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter weight in pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println("Enter height in inches: ");
        double height = scanner.nextDouble();

        double BMI = (pounds * 0.45359237) / Math.pow((height * 0.0254), 2);
        System.out.println("BMI is " + BMI);
    }


    public void taskFifteen() {
        Scanner scanner = new Scanner(System.in);
        double x1, y1, x2, y2;

        System.out.println("Enter x1 and y1: ");
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        System.out.println("Enter x2 and y2: ");
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();

        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("Distance between the two points is: " + distance);
    }

    public void taskSixteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of the side: ");
        double side = scanner.nextDouble();

        double area = Math.pow(side, 2) * 3 * Math.sqrt(3.0) / 2;
        System.out.println("Area of hexagon is: " + area);
    }

    public void taskSeventeen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature in Fahrenheit between -58F and +41F");
        double fahrenheit = scanner.nextDouble();
        System.out.println("Enter wind speed ( >= 2 ) in miles/hr: ");
        double windSpeed = scanner.nextDouble();

        double windChillIndex = 35.74 + 0.6125 * fahrenheit - 35.75 * Math.pow(windSpeed, 0.16) +
            0.4275 * fahrenheit * Math.pow(windSpeed, 0.16);
        System.out.println("Wind chill index is: " + windChillIndex);
    }

    public void taskEighteen() {
        System.out.println("a\t\tb\t\tpow(a,b)");
        for (int i = 1; i < 6; i++) {
            System.out.println(i + "\t\t" + (i + 1) + "\t\t" + Math.pow(i, i + 1));
        }
    }

    public void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        double x1, y1, x2, y2, x3, y3;
        double area;

        System.out.println("Enter the coordinates of 3 points separated by spaces: ");
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();
        x3 = scanner.nextDouble();
        y3 = scanner.nextDouble();

        double expression = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        area = 0.5 * Math.abs(expression);

        System.out.println("The area of the triangle is: " + area);
    }

    public void taskTwenty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter balance and interest rate[%]: ");
        double balance = scanner.nextDouble();
        double interestRate = scanner.nextDouble();

        double interest = balance * (interestRate / 1200);
        System.out.println("The interest is: " + interest);
    }

    public void taskTwentyOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter investment amount: ");
        double investmentAmount = scanner.nextDouble();
        System.out.println("Enter annual interest rate[%]: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.println("Enter number of years: ");
        int years = scanner.nextInt();

        double futureValue = investmentAmount * Math.pow((1 + annualInterestRate / 12), (years * 12));
        System.out.println("Future value is: $" + futureValue);
    }

    public void taskTwentyTwo() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Receive the amount
        System.out.print("Enter an amount in digits, for example 1156: ");
        int remainingAmount = input.nextInt();

        int dollars = remainingAmount / 100;
        remainingAmount %= 100;

        int quarters = remainingAmount / 25;
        remainingAmount %= 25;

        int dimes = remainingAmount / 10;
        remainingAmount %= 10;

        int nickels = remainingAmount / 5;
        remainingAmount %= 5;

        // Display results
        System.out.println("Your amount " + remainingAmount + " consists of");
        System.out.println(" " + dollars + " dollars");
        System.out.println(" " + quarters+ " quarters ");
        System.out.println(" " + dimes + " dimes");
        System.out.println(" " + nickels + " nickels");
        System.out.println(" " + remainingAmount + " pennies");
    }


    public void taskTwentyThree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter driving distance: ");
        double distance = scanner.nextDouble();
        System.out.println("Enter miles per gallon: ");
        double milesPerGallon = scanner.nextDouble();
        System.out.println("Enter price per gallon: ");
        double pricePerGallon = scanner.nextDouble();

        double price = (distance / milesPerGallon) * pricePerGallon;
        System.out.println("The cost of driving is: $" + price);
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
        taskTwentyOne();
        System.out.println();
        taskTwentyTwo();
        System.out.println();
        taskTwentyThree();
    }

}
