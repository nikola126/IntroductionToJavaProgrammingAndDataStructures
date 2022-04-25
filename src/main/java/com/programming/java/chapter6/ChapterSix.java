package com.programming.java.chapter6;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class ChapterSix {
    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    public static int sumDigits(long n) {
        long sum = 0;

        if (n < 10)
            return (int) n;

        while (n > 9) {
            long digit = n % 10;
            sum += digit;
            n /= 10;
        }

        sum += n;
        return (int) sum;
    }

    public static int reverse(int number) {
        int sum = 0;

        while (number > 0) {
            int remainder = number % 10;
            sum = (sum * 10) + remainder;
            number /= 10;
        }

        return sum;
    }

    public static boolean isPalindrome(int number) {
        return reverse(number) == number;
    }

    public static void displayReversed(int number) {
        System.out.println(reverse(number));
    }

    public static void displaySortedNumbers(double num1, double num2, double num3) {
        if (num1 >= num2 && num2 >= num3) {
            System.out.printf("%f\t%f\t%f\n", num3, num2, num1);
        } else if (num1 >= num3 && num3 >= num2) {
            System.out.printf("%f\t%f\t%f\n", num2, num3, num1);
        } else if (num2 >= num1 && num1 >= num3) {
            System.out.printf("%f\t%f\t%f\n", num3, num1, num2);
        } else if (num2 >= num3 && num3 >= num1) {
            System.out.printf("%f\t%f\t%f\n", num1, num3, num2);
        } else if (num3 >= num1 && num1 >= num2) {
            System.out.printf("%f\t%f\t%f\n", num2, num1, num3);
        } else if (num3 >= num2 && num2 >= num1) {
            System.out.printf("%f\t%f\t%f\n", num1, num2, num3);
        }
    }

    public static void displayPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                System.out.print("  ");
            for (int j = i; j >= 0; j--)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow((1 + monthlyInterestRate / 12), (years * 12));
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = scanner.nextDouble();
        System.out.print("Enter annual interest rate: ");
        double interestRate = scanner.nextDouble();

        for (int i = 1; i <= 30; i++) {
            System.out.printf("%d\t\t%f\n", i, futureInvestmentValue(investmentAmount, interestRate / 100 / 12, i));
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    public static void taskEight() {
        System.out.printf("%10s\t%10s\t|\t%10s\t%10s\n", "Celsius", "Fahrenheit", "Fahrenheit", "Celsius");
        System.out.println("---------------------------------------------------");

        double celsius = 40;
        double fahrenheit = 120;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10.1f\t%10.1f\t|%10.1f\t%10.1f\n", celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
            celsius -= 1;
            fahrenheit -= 10;
        }
    }

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void taskNine() {
        System.out.printf("%10s\t%10s\t|\t%10s\t%10s\n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("---------------------------------------------------");

        double feet = 1;
        double meters = 20;
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10.1f\t%10.3f\t|%10.1f\t%10.3f\n", feet, footToMeter(feet), meters, meterToFoot(meters));
            feet += 1;
            meters += 5;
        }
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
                return false; // Number is not a prime
            }
        }

        return true; // Number is prime
    }

    public static void taskTen() {
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isPrime(i))
                count += 1;
        }
        System.out.println("There are " + count + " prime numbers smaller than 10000.");
    }

    public static double computeCommission(double salesAmount) {
        if (salesAmount <= 5000) {
            return ((8.0) / 100) * salesAmount;
        }

        double percentage = 8.0;
        double commission = 0;
        while (salesAmount > 5000) {

            if (percentage == 8.0) {
                commission += (percentage / 100) * salesAmount;

                percentage = 10.0;
                salesAmount -= 5000;
            } else if (percentage == 10.0) {
                commission += (percentage / 100) * salesAmount;

                percentage = 12.0;
                salesAmount -= 5000;
            } else {
                commission += (percentage / 100) * salesAmount;
                break;
            }
        }
        return commission;
    }

    public static void taskEleven() {
        System.out.printf("%15s\t%15s\n", "Sales Amount", "Commission");
        for (int sales = 10000; sales <= 100000; sales += 5000) {
            System.out.printf("%15d\t%15.1f\n", sales, computeCommission(sales));
        }
    }

    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int onLine = 0;
        while (ch1 <= ch2) {
            System.out.printf("%c ", ch1);
            ch1 += 1;
            onLine += 1;

            if (onLine == numberPerLine) {
                onLine = 0;
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void taskTwelve() {
        printChars('1', 'Z', 10);
    }

    public static double sumSeries(int n) {
        double sum = 0;
        double i = 1.0;

        while (n > 0) {
            sum += (i / (i + 1));
            n--;
            i++;
        }

        return sum;
    }

    public static void taskThirteen() {
        System.out.printf("%10s\t%10s\n", "i", "m(i)");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%10d\t%10.4f\n", i, sumSeries(i));
        }
        System.out.println();
    }

    public static double estimatePi(int n) {
        double estimate = 0;

        for (int i = 1; i < n; i++) {
            estimate += Math.pow(-1.0, i + 1) / (2.0 * i - 1);
            ;
        }

        return 4.0 * estimate;
    }

    public static void taskFourteen() {
        System.out.printf("%10s\t%10s\n", "i", "m(i)");
        for (int i = 1; i <= 901; i += 100) {
            System.out.printf("%10d\t%10.4f\n", i, estimatePi(i));
        }
    }

    public static double computeTax(int status, double taxableIncome) {
        // Compute tax
        double tax = 0;

        if (status == 0) {
            // Compute tax for single filers
            if (taxableIncome <= 8350) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 33950) {
                tax = 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            } else if (taxableIncome <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (taxableIncome - 33950) * 0.25;
            } else if (taxableIncome <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (82250 - 33950) * 0.25 + (taxableIncome - 82250) * 0.28;
            } else if (taxableIncome <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                        (taxableIncome - 171550) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                        (372950 - 171550) * 0.33 + (taxableIncome - 372950) * 0.35;
            }
        } else if (status == 1) { // Left as an exercise
            // Compute tax for married file jointly or qualifying widow(er)
            if (taxableIncome <= 16700) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 67900) {
                tax = 16700 * 0.10 + (taxableIncome - 8350) * 0.15;
            } else if (taxableIncome <= 137050) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                        (taxableIncome - 67900) * 0.25;
            } else if (taxableIncome <= 372950) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                        (137050 - 67900) * 0.25 + (taxableIncome - 137050) * 0.28;
            } else if (taxableIncome <= 372950) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                        (137050 - 67900) * 0.25 + (372950 - 137050) * 0.28 +
                        (taxableIncome - 372950) * 0.33;
            } else {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                        (137050 - 67900) * 0.25 + (372950 - 137050) * 0.28 +
                        (372950 - 372950) * 0.33 + (taxableIncome - 372950) * 0.35;
            }
        } else if (status == 2) { // Compute tax for married separately
            // Left as an exercise in Programming Exercise 3.13
            if (taxableIncome <= 8350) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 33950) {
                tax = 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            } else if (taxableIncome <= 68525) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (taxableIncome - 33950) * 0.25;
            } else if (taxableIncome <= 104425) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (68525 - 33950) * 0.25 + (taxableIncome - 68525) * 0.28;
            } else if (taxableIncome <= 186475) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                        (taxableIncome - 104425) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                        (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                        (186475 - 104425) * 0.33 + (taxableIncome - 186475) * 0.35;
            }
        } else if (status == 3) { // Compute tax for head of household
            // Left as an exercise in Programming Exercise 3.13
            if (taxableIncome <= 11950) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 45500) {
                tax = 11950 * 0.10 + (taxableIncome - 11950) * 0.15;
            } else if (taxableIncome <= 117450) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                        (taxableIncome - 45500) * 0.25;
            } else if (taxableIncome <= 190200) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                        (190200 - 45500) * 0.25 + (taxableIncome - 190200) * 0.28;
            } else if (taxableIncome <= 372950) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                        (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
                        (taxableIncome - 171550) * 0.33;
            } else {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                        (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
                        (372950 - 190200) * 0.33 + (taxableIncome - 372950) * 0.35;
            }
        } else {
            System.out.println("Error: invalid status");
            System.exit(1);
        }

        return tax;
    }

    public static void taskFifteen() {
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\n", "Taxable", "Single", "Married Joint", "Married", "Head of");
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\n", "Income", "", "or Qualifying", "Separate", "Household");
        System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\n", "", "", "Widow(er)", "", "");
        for (int i = 50000; i <= 60000; i += 50) {
            System.out.printf("%10d\t%10d\t%10d\t%10d\t%10d\n", i, Math.round(computeTax(0, i)), Math.round(computeTax(1, i)), Math.round(computeTax(2, i)), Math.round(computeTax(3, i)));
        }
    }

    public static int numberOfDaysInAYear(int year) {
        int days = 0;
        for (int month = 1; month <= 12; month++) {
            days += getNumberOfDaysInMonth(year, month);
        }

        return days;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void taskSixteen() {
        System.out.printf("%10s\t%10s\n", "Days", "Year");
        for (int year = 2000; year <= 2020; year += 1) {
            System.out.printf("%10d\t%10d\n", year, numberOfDaysInAYear(year));
        }
    }

    public static void printMatrix(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.printf("%d ", Math.round(Math.random()));
            }
            System.out.println();
        }
    }

    public static boolean isValidPassword(String password) {
        int length = password.length();
        if (length < 8)
            return false;

        int numberOfDigits = 0;
        for (Character c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c))
                return false; // invalid character
            if (Character.isDigit(c))
                numberOfDigits += 1;
        }

        return numberOfDigits >= 2;
    }

    public static void taskEighteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password))
            System.out.println("Valid password!");
        else
            System.out.println("Invalid password!");
    }

    public static boolean isValid(double side1, double side2, double side3) {
        double sum12 = side1 + side2;
        double sum13 = side1 + side3;
        double sum23 = side2 + side3;

        return sum12 > side3 && sum13 > side2 && sum23 > side1;
    }

    public static double area(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side [1/3]: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side [2/3]: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side [3/3]: ");
        double side3 = scanner.nextDouble();

        if (isValid(side1, side2, side3)) {
            System.out.println("Area of triangle: " + area(side1, side2, side3));
        } else {
            System.out.println("The triangle is invalid!");
        }
    }

    public static int countLetters(String s) {
        int letters = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                letters += 1;
        }

        return letters;
    }

    public static void taskTwenty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        System.out.println("Number of letters in string: " + countLetters(s));
    }

    public static int getNumber(char upperCaseLetter) {
        HashMap<Character, Integer> keypad = new HashMap<>();
        keypad.put('A', 2);
        keypad.put('B', 2);
        keypad.put('C', 2);
        keypad.put('D', 3);
        keypad.put('E', 3);
        keypad.put('F', 3);
        keypad.put('G', 4);
        keypad.put('H', 4);
        keypad.put('I', 4);
        keypad.put('J', 5);
        keypad.put('K', 5);
        keypad.put('L', 5);
        keypad.put('M', 6);
        keypad.put('N', 6);
        keypad.put('O', 6);
        keypad.put('P', 7);
        keypad.put('Q', 7);
        keypad.put('R', 7);
        keypad.put('S', 7);
        keypad.put('T', 8);
        keypad.put('U', 8);
        keypad.put('V', 8);
        keypad.put('W', 9);
        keypad.put('X', 9);
        keypad.put('Y', 9);
        keypad.put('Z', 9);

        return keypad.getOrDefault(upperCaseLetter, 0);
    }

    public static void taskTwentyOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String s = scanner.nextLine();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                System.out.printf("%d", getNumber(Character.toUpperCase(c)));
            } else if (Character.isDigit(c)) {
                System.out.printf("%c", c);
            }
        }
    }

    public static double sqrt(long n) {
        double nextGuess = n;
        double lastGuess = 1;

        double eps = 0.0001;

        while (nextGuess - lastGuess > eps) {
            nextGuess = ((nextGuess + lastGuess) / 2);
            lastGuess = n / nextGuess;
        }

        return nextGuess;
    }

    public static void taskTwentyTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value: ");
        long value = scanner.nextInt();
        System.out.println("Approximate square is: " + sqrt(value));
    }

    public static int count(String s, char a) {
        int occurences = 0;
        for (char c : s.toCharArray()) {
            if (c == a)
                occurences += 1;
        }
        return occurences;
    }

    public static void taskTwentyThree() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        System.out.print("Enter character: ");
        char c = scanner.nextLine().charAt(0);

        System.out.println(s + " contains [" + c + "] exactly " +

                count(s, c) + " times.");
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }

    public static void showCurrentDateAndTime() {
        long totalMilliseconds = System.currentTimeMillis();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(totalMilliseconds);

        long totalSeconds = totalMilliseconds / 1000;

        long currentSecond = totalSeconds % 60;

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = totalHours % 24;

        // Display results
        System.out.println("Today is " + getMonthName(calendar.get(Calendar.MONTH) + 1) + " " + calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR));
        System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");
    }

    public static String convertMillis(long millis) {
        long hours, minutes, seconds;

        hours = millis / 1000 / 60 / 60;
        minutes = (millis / 1000 / 60) - hours * 60;
        seconds = (millis / 1000) - hours * 60 * 60 - minutes * 60;

        return String.format("%d:%d:%d", hours, minutes, seconds);
    }

    public static void taskTwentyFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter milliseconds [long]: ");
        long millis = scanner.nextInt();

        System.out.println(convertMillis(millis));
    }

    public static void printAll() {
        System.out.println(ChapterSix.getPentagonalNumber(4));
        System.out.println(ChapterSix.sumDigits(12345));
        System.out.println(ChapterSix.isPalindrome(12321));
        ChapterSix.displayReversed(12345);
        ChapterSix.displaySortedNumbers(5, 10, 1);
        ChapterSix.displayPattern(5);
        System.out.println(ChapterSix.futureInvestmentValue(10000, 0.05, 5));
        ChapterSix.taskEight();
        ChapterSix.taskNine();
        ChapterSix.taskTen();
        ChapterSix.taskEleven();
        ChapterSix.taskTwelve();
        ChapterSix.taskThirteen();
        ChapterSix.taskFourteen();
        ChapterSix.taskFifteen();
        ChapterSix.taskSixteen();
        ChapterSix.printMatrix(5);
        ChapterSix.taskEighteen();
        ChapterSix.taskNineteen();
        ChapterSix.taskTwenty();
        ChapterSix.taskTwentyOne();
        ChapterSix.taskTwentyTwo();
        ChapterSix.taskTwentyThree();
        ChapterSix.showCurrentDateAndTime();
        ChapterSix.taskTwentyFive();
    }

}
