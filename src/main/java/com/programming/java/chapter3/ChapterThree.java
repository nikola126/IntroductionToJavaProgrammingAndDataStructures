package com.programming.java.chapter3;

import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ChapterThree {
    public void taskOne() {
        Scanner scanner = new Scanner(System.in);
        double a, b, c, D, x1, x2;

        System.out.println("Enter a, b, c: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        D = Math.pow(b, 2) - 4 * a * c;
        if (D < 0) {
            System.out.println("The equation has no real roots");
        } else if (D == 0) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Equation has one root: " + x1);
        } else {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Equation has two roots: " + x1 + " and " + x2);
        }
    }

    public void taskTwo() {
        int number1 = (int) (System.currentTimeMillis() % 10);
        int number2 = (int) (System.currentTimeMillis() / 10 % 10);
        int number3 = (int) (System.currentTimeMillis() / 100 % 100);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("What is " + number1 + " + " + number2 + " + " + number3 + "? ");

        int answer = input.nextInt();

        System.out.println(number1 + " + " + number2 + " " + number3 + " = " + answer + " is " +
            (number1 + number2 + number3 == answer));
    }

    public void taskThree() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a, b, c, d, e, f:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();

        if ((a * d - b * c) == 0) {
            System.out.println("The equation has no solution!");
        } else {
            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - e * c) / (a * d - b * c);

            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }

    public void taskFour() {
        int min = 1;
        int max = 12;
        int N = (int) ((Math.random() * (max - min)) + min);

        switch (N) {
            case 1: {
                System.out.println("January");
                break;
            }
            case 2: {
                System.out.println("February");
                break;
            }
            case 3: {
                System.out.println("March");
                break;
            }
            case 4: {
                System.out.println("April");
                break;
            }
            case 5: {
                System.out.println("May");
                break;
            }
            case 6: {
                System.out.println("June");
                break;
            }
            case 7: {
                System.out.println("July");
                break;
            }
            case 8: {
                System.out.println("August");
                break;
            }
            case 9: {
                System.out.println("September");
                break;
            }
            case 10: {
                System.out.println("October");
                break;
            }
            case 11: {
                System.out.println("November");
                break;
            }
            case 12: {
                System.out.println("December");
                break;
            }
        }
    }

    public void taskFive() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter today's day: ");
        int today = scanner.nextInt();

        System.out.println("Enter number of days elapsed since today: ");
        int elapsed = scanner.nextInt();

        int future = (today + elapsed) % 7;

        switch (future) {
            case 1: {
                System.out.println("Monday");
                break;
            }
            case 2: {
                System.out.println("Tuesday");
                break;
            }
            case 3: {
                System.out.println("Wednesday");
                break;
            }
            case 4: {
                System.out.println("Thursday");
                break;
            }
            case 5: {
                System.out.println("Friday");
                break;
            }
            case 6: {
                System.out.println("Saturday");
                break;
            }
            case 0: {
                System.out.println("Sunday");
                break;
            }
        }
    }

    public void taskSix() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Enter height feet: ");
        double feet = input.nextDouble();

        System.out.println("Enter height inches: ");
        double inches = input.nextDouble();

        double height = feet / 0.08333 + inches;

        final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
        final double METERS_PER_INCH = 0.0254; // Constant

        // Compute BMI
        double weightInKilograms = weight * KILOGRAMS_PER_POUND;
        double heightInMeters = height * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);

        // Display result
        System.out.println("BMI is " + bmi);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

    public void taskSeven() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an amount in double, for example 11.56: ");
        double amount = input.nextDouble();

        int remainingAmount = (int) (amount * 100);

        // Find the number of one dollars
        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        // Find the number of quarters in the remaining amount
        int numberOfQuarters = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        // Find the number of dimes in the remaining amount
        int numberOfDimes = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        // Find the number of nickels in the remaining amount
        int numberOfNickels = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;

        // Find the number of pennies in the remaining amount
        int numberOfPennies = remainingAmount;

        // Display results
        System.out.println("Your amount " + amount + " consists of");

        if (numberOfOneDollars > 1) {
            System.out.println(" " + numberOfOneDollars + " dollars");
        } else {
            System.out.println(" " + numberOfOneDollars + " dollar");
        }

        if (numberOfQuarters > 1) {
            System.out.println(" " + numberOfQuarters + " quarters ");
        } else {
            System.out.println(" " + numberOfQuarters + " quarter ");
        }

        if (numberOfDimes > 1) {
            System.out.println(" " + numberOfDimes + " dimes");
        } else {
            System.out.println(" " + numberOfDimes + " dime");
        }

        if (numberOfNickels > 1) {
            System.out.println(" " + numberOfNickels + " nickels");
        } else {
            System.out.println(" " + numberOfNickels + " nickel");
        }

        if (numberOfPennies > 1) {
            System.out.println(" " + numberOfPennies + " pennies");
        } else {
            System.out.println(" " + numberOfPennies + " penny");
        }
    }

    public void taskEight() {
        Scanner scanner = new Scanner(System.in);

        int x, y, z;
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();

        if (x >= y && y >= z) {
            System.out.println(x + " " + y + " " + z);
        } else if (y >= x && x >= z) {
            System.out.println(y + " " + x + " " + z);
        } else if (z >= x && x >= y) {
            System.out.println(z + " " + x + " " + y);
        } else if (z >= y && y >= x) {
            System.out.println(z + " " + y + " " + x);
        } else if (y >= z && z >= x) {
            System.out.println(y + " " + z + " " + x);
        } else {
            System.out.println(y + " " + x + " " + z);
        }
    }

    public void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first 9 digits of an ISBN as integer: ");
        String firstNine = scanner.nextLine();

        int last = (firstNine.charAt(0) + firstNine.charAt(1) * 2 + firstNine.charAt(2) * 3 +
            firstNine.charAt(3) * 4 + firstNine.charAt(4) * 5 + firstNine.charAt(5) * 6 + firstNine.charAt(6) * 7 +
            firstNine.charAt(7) * 8 + firstNine.charAt(8) * 9) % 11;

        String ISBN = firstNine + (char) last;
        System.out.println("The ISBN-10 number is: " + ISBN);
    }

    public void taskTen() {
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if ((number1 + number2) == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " - " + number2 + " should be " + (number1 + number2));
        }
    }

    public void taskEleven() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter month (digit): ");
        int month = scanner.nextInt();

        System.out.printf("Enter year: ");
        int year = scanner.nextInt();

        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.println(
            yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + year + " has " + daysInMonth +
                " days.");
    }

    public void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a three-digit integer: ");
        int digit = scanner.nextInt();
        int test = Math.abs(digit);

        if (test % 10 == test / 100) {
            System.out.println(digit + " is a palindrome");
        } else {
            System.out.println(digit + "is not a palindrome");
        }
    }

    public void taskThirteen() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter filing status
        System.out.print("(0-single filer, 1-married jointly or " +
            "qualifying widow(er), 2-married separately, 3-head of " +
            "household) Enter the filing status: ");

        int status = input.nextInt();

        // Prompt the user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        // Compute tax
        double tax = 0;

        if (status == 0) {
            // Compute tax for single filers
            if (income <= 8350) {
                tax = income * 0.10;
            } else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (income - 33950) * 0.25;
            } else if (income <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            } else if (income <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                    (income - 171550) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                    (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        } else if (status == 1) { // Left as an exercise
            // Compute tax for married file jointly or qualifying widow(er)
            if (income <= 16700) {
                tax = income * 0.10;
            } else if (income <= 67900) {
                tax = 16700 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 137050) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                    (income - 67900) * 0.25;
            } else if (income <= 372950) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                    (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
            } else if (income <= 372950) {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                    (137050 - 67900) * 0.25 + (372950 - 137050) * 0.28 +
                    (income - 372950) * 0.33;
            } else {
                tax = 16700 * 0.10 + (67900 - 8350) * 0.15 +
                    (137050 - 67900) * 0.25 + (372950 - 137050) * 0.28 +
                    (372950 - 372950) * 0.33 + (income - 372950) * 0.35;
            }
        } else if (status == 2) { // Compute tax for married separately
            // Left as an exercise in Programming Exercise 3.13
            if (income <= 8350) {
                tax = income * 0.10;
            } else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 68525) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (income - 33950) * 0.25;
            } else if (income <= 104425) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
            } else if (income <= 186475) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                    (income - 104425) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                    (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
            }
        } else if (status == 3) { // Compute tax for head of household
            // Left as an exercise in Programming Exercise 3.13
            if (income <= 11950) {
                tax = income * 0.10;
            } else if (income <= 45500) {
                tax = 11950 * 0.10 + (income - 11950) * 0.15;
            } else if (income <= 117450) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                    (income - 45500) * 0.25;
            } else if (income <= 190200) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                    (190200 - 45500) * 0.25 + (income - 190200) * 0.28;
            } else if (income <= 372950) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
                    (income - 171550) * 0.33;
            } else {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
                    (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
            }
        } else {
            System.out.println("Error: invalid status");
            System.exit(1);
        }

        // Display the result
        System.out.println("Tax is " + (int) (tax * 100) / 100.0);
    }

    public void taskFourteen() {
        Scanner scanner = new Scanner(System.in);
        int rand = ((int) (Math.random() * 10) % 2);
        String coin;
        if (rand % 2 == 0) {
            coin = "heads";
        } else {
            coin = "tails";
        }

        System.out.println("Heads or tails? ");
        String guess = scanner.nextLine();

        if (Objects.equals(guess, coin)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }

    public void taskFifteen() {
        // Generate a lottery number
        int lottery = (int) (Math.random() * 1000);

        // Prompt the user to enter a guess
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = input.nextInt();

        // Get digits from lottery
        int lotteryDigit3 = lottery % 10;
        int lotteryDigit2 = (lottery / 10) % 10;
        int lotteryDigit1 = lottery - lotteryDigit2 * 10 - lotteryDigit3;

        Set<Integer> lotterySet = new HashSet<>();
        lotterySet.add(lotteryDigit1);
        lotterySet.add(lotteryDigit2);
        lotterySet.add(lotteryDigit3);

        // Get digits from guess
        int guessDigit3 = guess % 10;
        int guessDigit2 = (guess / 10) % 10;
        int guessDigit1 = guess - guessDigit2 * 10 - guessDigit3;

        System.out.println("The lottery number is " + lottery);

        // Check the guess
        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        } else if (lotterySet.contains(guessDigit1) && lotterySet.contains(guessDigit2) &&
            lotterySet.contains(guessDigit3)
        ) {
            System.out.println("Match all digits: you win $3,000");
        } else if (lotterySet.contains(guessDigit1) || lotterySet.contains(guessDigit2) ||
            lotterySet.contains(guessDigit3)) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry, no match");
        }
    }

    public void taskSixteen() {
        int minX = -50;
        int maxX = 50;
        int minY = -100;
        int maxY = 100;

        int randX = (int) ((Math.random() * (maxX - minX)) + minX);
        int randY = (int) ((Math.random() * (maxY - minY)) + minY);

        System.out.println("Random coordinate at (" + randX + "," + randY + ")");
    }

    public void taskSeventeen() {
        int min = 0;
        int max = 2;
        int computer = (int) ((Math.random() * (max - min)) + min);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Scissor(0), rock(1), paper(2): ");
        int player = scanner.nextInt();

        if (computer == player) {
            if (computer == 0) {
                System.out.println("Both of you are scissor! Draw.");
            } else if (computer == 1) {
                System.out.println("Both of you are rock! Draw.");
            } else {
                System.out.println("Both of you are paper! Draw.");
            }
        } else {
            if (computer == 0 && player == 1) {
                System.out.println("You win!");
            }
            if (computer == 0 && player == 2) {
                System.out.println("You lose!");
            }
            if (computer == 1 && player == 0) {
                System.out.println("You lose!");
            }
            if (computer == 1 && player == 2) {
                System.out.println("You win!");
            }
            if (computer == 2 && player == 0) {
                System.out.println("You lose!");
            }
            if (computer == 0 && player == 2) {
                System.out.println("You win!");
            }
        }
    }

    public void taskEighteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight of package: ");
        double weight = scanner.nextDouble();

        if (weight <= 0) {
            System.out.println("Invalid input!");
        } else if (weight > 20) {
            System.out.println("Package cannot be shipped!");
        } else {
            if (0 < weight && weight <= 1) {
                System.out.println("Shipping cost: " + 3.5);
            }
            if (1 < weight && weight <= 3) {
                System.out.println("Shipping cost: " + 5.5);
            }
            if (3 < weight && weight <= 10) {
                System.out.println("Shipping cost: " + 8.5);
            }
            if (10 < weight) {
                System.out.println("Shipping cost: " + 10.5);
            }
        }
    }

    public void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three edges of a triangle:");
        System.out.println("Edge 1 [x,y]: ");
        int aX = scanner.nextInt();
        int aY = scanner.nextInt();
        System.out.println("Edge 2 [x,y]: ");
        int bX = scanner.nextInt();
        int bY = scanner.nextInt();
        System.out.println("Edge 3 [x,y]: ");
        int cX = scanner.nextInt();
        int cY = scanner.nextInt();

        double area = 0.5 * (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY));
        if (area > 0) {
            double expression = Math.pow((bX - aX), 2) + Math.pow((bY - aY), 2);
            double perimeter = Math.sqrt(expression);

            expression = Math.pow((cX - bX), 2) + Math.pow((cY - bY), 2);
            perimeter += Math.sqrt(expression);

            expression = Math.pow((aX - cX), 2) + Math.pow((aY - cY), 2);
            perimeter += Math.sqrt(expression);

            System.out.println("Perimeter: " + perimeter);
        } else {
            System.out.println("Invalid input!");
        }
    }

    public void taskTwenty() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter temperature in Fahrenheit between -58F and +41F");
        double fahrenheit = scanner.nextDouble();
        System.out.println("Enter wind speed ( >= 2 ) in miles/hr: ");
        double windSpeed = scanner.nextDouble();

        if (fahrenheit < -58 || fahrenheit > 41) {
            System.out.println("Invalid temperature!");
            return;
        }
        if (windSpeed < 2) {
            System.out.println("Invalid windspeed!");
            return;
        }

        double windChillIndex = 35.74 + 0.6125 * fahrenheit - 35.75 * Math.pow(windSpeed, 0.16) +
            0.4275 * fahrenheit * Math.pow(windSpeed, 0.16);
        System.out.println("Wind chill index is: " + windChillIndex);
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
    }
}