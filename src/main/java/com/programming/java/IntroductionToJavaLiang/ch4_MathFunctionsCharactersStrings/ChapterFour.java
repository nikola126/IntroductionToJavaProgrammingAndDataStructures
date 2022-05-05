package com.programming.java.IntroductionToJavaLiang.ch4_MathFunctionsCharactersStrings;

import java.time.YearMonth;
import java.util.*;

public class ChapterFour {
    public void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length from center to vertex: ");
        double r = scanner.nextDouble();

        double side = 2 * r * Math.sin(Math.PI / 5);
        double area = (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));

        System.out.printf("Area of pentagon is: %.2f\n", area);
    }

    public void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double radius = 6371.01;
        double distance = radius * Math.acos(Math.toRadians(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)));

        System.out.println("Distance between two points is: " + distance + " km");
    }

    public void taskThree() {
        double charlotteX = 35.227;
        double charlotteY = -80.843;
        double savannahX = 32.083;
        double savannahY = -81.099;
        double orlandoX = 28.538;
        double orlandoY = -81.379;
        double atlantaX = 33.749;
        double atlantaY = -84.388;
        double radius = 6371.01;

        double distanceCS = radius * Math.acos(Math.toRadians(Math.sin(charlotteX) * Math.sin(savannahX) + Math.cos(charlotteX) * Math.cos(savannahX) * Math.cos(charlotteY - savannahY)));

        double distanceSO = radius * Math.acos(Math.toRadians(Math.sin(savannahX) * Math.sin(orlandoX) + Math.cos(savannahX) * Math.cos(orlandoX) * Math.cos(savannahY - orlandoY)));

        double distanceOA = radius * Math.acos(Math.toRadians(Math.sin(orlandoX) * Math.sin(atlantaX) + Math.cos(orlandoX) * Math.cos(atlantaX) * Math.cos(orlandoY - atlantaY)));

        double distanceAC = radius * Math.acos(Math.toRadians(Math.sin(atlantaX) * Math.sin(charlotteX) + Math.cos(atlantaX) * Math.cos(charlotteX) * Math.cos(atlantaY - charlotteY)));

        double distanceCO = radius * Math.acos(Math.toRadians(Math.sin(charlotteX) * Math.sin(orlandoX) + Math.cos(charlotteX) * Math.cos(orlandoX) * Math.cos(charlotteY - orlandoY)));

        double expression = charlotteX * (savannahY - orlandoY) + savannahX * (orlandoY - charlotteY) + orlandoX * (charlotteY - savannahY);
        double area = 0.5 * Math.abs(expression);

        expression = charlotteX * (atlantaY - orlandoY) + atlantaX * (orlandoY - charlotteY) + orlandoX * (charlotteY - atlantaY);
        area += 0.5 * Math.abs(expression);

        System.out.println("Area: " + area);
    }

    public void taskFour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the side: ");
        double side = scanner.nextDouble();
        double area = (6 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 6));
        System.out.println("Area of hexagon: " + area);
    }

    public void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of sides: ");
        double n = scanner.nextDouble();
        System.out.println("Enter the side: ");
        double side = scanner.nextDouble();

        double area = (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
        System.out.println("Area: " + area);
    }

    public void taskSix() {
        double radius = 40;
        double theta = Math.toRadians(Math.random() * (2 * 180));
        double pointOneX = radius * Math.cos(theta);
        double pointOneY = radius * Math.sin(theta);

        theta = Math.toRadians(Math.random() * (2 * 180));
        double pointTwoX = radius * Math.cos(theta);
        double pointTwoY = radius * Math.sin(theta);

        theta = Math.toRadians(Math.random() * (2 * 180));
        double pointThreeX = radius * Math.cos(theta);
        double pointThreeY = radius * Math.sin(theta);

        System.out.println("Three points on a circle (radius = " + radius + "):");
        System.out.printf("P1 [%4.2f, %4.2f]\n", pointOneX, pointOneY);
        System.out.printf("P2 [%4.2f, %4.2f]\n", pointTwoX, pointTwoY);
        System.out.printf("P3 [%4.2f, %4.2f]\n", pointThreeX, pointThreeY);
    }

    public void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the bounding circle: ");
        double radius = scanner.nextDouble();
        double[] theta = {30, 90, 120, 225, 315};

        System.out.println("The coordinates of 5 points on the pentagon are: ");
        for (int i = 0; i < 5; i++) {
            double pointX = radius * Math.cos(Math.toRadians(theta[i]));
            double pointY = radius * Math.sin(Math.toRadians(theta[i]));
            System.out.printf("(%4.2f, %4.2f)\n", pointX, pointY);
        }
    }

    public void taskEight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an ASCII code: ");

        int asInt = scanner.nextInt();

        System.out.println("The character for ASCII code " + asInt + " is: " + (char) asInt);
    }

    public void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");

        char c = scanner.next().charAt(0);

        System.out.println("The unicode for the character " + c + " is: " + (int) c);
    }

    public void taskTen() {
        String set1 = " 1 3 5 7\n" + " 9 11 13 15\n" + "17 19 21 23\n" + "25 27 29 31";

        String set2 = " 2 3 6 7\n" + "10 11 14 15\n" + "18 19 22 23\n" + "26 27 30 31";

        String set3 = " 4 5 6 7\n" + "12 13 14 15\n" + "20 21 22 23\n" + "28 29 30 31";

        String set4 = " 8 9 10 11\n" + "12 13 14 15\n" + "24 25 26 27\n" + "28 29 30 31";

        String set5 = "16 17 18 19\n" + "20 21 22 23\n" + "24 25 26 27\n" + "28 29 30 31";

        int day = 0;

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to answer questions
        System.out.print("Is your birthday in Set1?\n");
        System.out.print(set1);
        System.out.print("\nEnter N for No and Y for Yes: ");
        char answer = input.next().charAt(0);

        if (answer == 'Y') day += 1;

        // Prompt the user to answer questions
        System.out.print("\nIs your birthday in Set2?\n");
        System.out.print(set2);
        System.out.print("\nEnter N for No and Y for Yes: ");
        answer = input.next().charAt(0);

        if (answer == 'Y') day += 2;

        // Prompt the user to answer questions
        System.out.print("\nIs your birthday in Set3?\n");
        System.out.print(set3);
        System.out.print("\nEnter N for No and Y for Yes: ");
        answer = input.next().charAt(0);
        ;

        if (answer == 'Y') day += 4;


        // Prompt the user to answer questions
        System.out.print("\nIs your birthday in Set4?\n");
        System.out.print(set4);
        System.out.print("\nEnter N for No and Y for Yes: ");
        answer = input.next().charAt(0);

        if (answer == 'Y') day += 8;

        // Prompt the user to answer questions
        System.out.print("\nIs your birthday in Set5?\n");
        System.out.print(set5);
        System.out.print("\nEnter N for No and Y for Yes: ");
        answer = input.next().charAt(0);

        if (answer == 'Y') day += 16;

        System.out.println("\nYour birthday is " + day + "!");
    }

    public void taskEleven() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal value (0 to 15): ");
        int value = input.nextInt();
        char asHex;

        if (value < 0 || value > 15) {
            System.out.println(value + " is an invalid input!");
            return;
        }

        if (value < 10) {
            asHex = Integer.toString(value).charAt(0);
        } else asHex = (char) ('A' + value - 10);

        System.out.println("The hex value of " + value + " is: " + asHex);
    }

    public void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal value (0 to 15): ");
        String input = scanner.nextLine();
        if (input.length() > 1) {
            System.out.println(input + " is an invalid input!");
            return;
        }

        char asHex = Character.toUpperCase(input.charAt(0));
        int asInt;

        if ('A' <= asHex && asHex <= 'F') {
            asInt = asHex - 'A' + 10;
            System.out.println("The binary value is: " + Integer.toBinaryString(asInt));
        } else if (Character.isDigit(asHex)) {
            asInt = Integer.parseInt(String.valueOf(asHex));
            System.out.println("The binary value is: " + Integer.toBinaryString(asInt));
        }
    }

    public void taskThirteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char ch = scanner.next().charAt(0);

        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

        if (!Character.isAlphabetic(ch)) {
            System.out.println(ch + " is an invalid input!");
        } else if (vowels.contains(Character.toUpperCase(ch))) {
            System.out.println(ch + " is a vowel.");
        } else {
            System.out.println(ch + " is a consonant.");
        }
    }

    public void taskFourteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter grade: ");
        char ch = scanner.next().charAt(0);

        HashMap<Character, Integer> gradesMap = new HashMap<>();
        gradesMap.put('A', 4);
        gradesMap.put('B', 3);
        gradesMap.put('C', 2);
        gradesMap.put('D', 1);
        gradesMap.put('F', 0);

        if (gradesMap.containsKey(Character.toUpperCase(ch))) {
            System.out.println("The numeric value for grade " + ch + " is " + gradesMap.get(Character.toUpperCase(ch)));
        } else {
            System.out.println(ch + " is an invalid grade.");
        }
    }

    public void taskFifteen() {
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

        Scanner scanner = new Scanner(System.in);
        char ch = scanner.nextLine().charAt(0);

        if (keypad.containsKey(Character.toUpperCase(ch))) {
            System.out.println("The corresponding number is " + keypad.get(Character.toUpperCase(ch)));
        } else {
            System.out.println(ch + " is an invalid input!");
        }
    }

    public void taskSixteen() {
        char randLetter = (char) ('A' + Math.round(Math.random() * 25));
        System.out.println("Random uppercase letter: " + randLetter);
    }

    public void taskSeventeen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.print("Enter a month: ");
        String monthInput = scanner.next();

        Map<String, Integer> monthNames = new HashMap<>();
        monthNames.put("Jan", 1);
        monthNames.put("Feb", 2);
        monthNames.put("Mar", 3);
        monthNames.put("Apr", 4);
        monthNames.put("May", 5);
        monthNames.put("Jun", 6);
        monthNames.put("Jul", 7);
        monthNames.put("Aug", 8);
        monthNames.put("Sep", 9);
        monthNames.put("Oct", 10);
        monthNames.put("Nov", 11);
        monthNames.put("Dec", 12);

        if (monthNames.containsKey(monthInput)) {
            YearMonth yearMonth = YearMonth.of(year, monthNames.get(monthInput));
            System.out.println(monthInput + " " + year + " has " + yearMonth.lengthOfMonth() + " days");
        } else {
            System.out.println(monthInput + " is not a correct month name!");
        }
    }

    public void taskEighteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String userInput = scanner.next();

        char major = userInput.charAt(0);
        char stage = userInput.charAt(1);

        switch (major) {
            case 'M': {
                System.out.print("Mathematics ");
                break;
            }
            case 'C': {
                System.out.print("Computer Science ");
                break;
            }
            case 'I': {
                System.out.print("Information Technology ");
                break;
            }
            default: {
                System.out.println("Invalid input!");
            }
        }

        switch (stage) {
            case '1': {
                System.out.println("Freshman");
                break;
            }
            case '2': {
                System.out.println("Sophomore");
                break;
            }
            case '3': {
                System.out.println("Junior");
                break;
            }
            case '4': {
                System.out.println("Senior");
                break;
            }
            default: {
                System.out.println("Invalid input!");
            }
        }
    }

    public void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first 9 digits of an ISBN as string: ");
        String firstNine = scanner.nextLine();

        int last = (firstNine.charAt(0) + firstNine.charAt(1) * 2 + firstNine.charAt(2) * 3 +
                firstNine.charAt(3) * 4 + firstNine.charAt(4) * 5 + firstNine.charAt(5) * 6 +
                firstNine.charAt(6) * 7 + firstNine.charAt(7) * 8 + firstNine.charAt(8) * 9) % 11;

        String ISBN = firstNine + (char) last;
        System.out.println("The ISBN-10 number is: " + ISBN);
    }

    public void taskTwenty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Your string has length of " + input.length() + " and its first character is " +
                input.charAt(0) + ".");
    }

    public void taskTwentyOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a SSN (DDD-DD-DDDD): ");
        String input = scanner.nextLine();
        int N = input.length();

        for (int i = 0; i < N; i++) {
            if (i == 3 || i == 6) {
                if (input.charAt(i) != '-') {
                    System.out.println(input + " is not a valid SSN!");
                    return;
                }
            } else {
                if (!Character.isDigit(input.charAt(i))) {
                    System.out.println(input + " is not a valid SSN!");
                    return;
                }
            }
        }

        System.out.println(input + " is a valid SSN!");
    }

    public void taskTwentyTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string (1/2): ");
        String s1 = scanner.next();
        System.out.println("Enter string (2/2): ");
        String s2 = scanner.next();

        if (s1.contains(s2)) {
            System.out.println(s2 + " is a substring of " + s1);
        } else {
            System.out.println(s2 + " is not a substring of " + s1);
        }
    }

    public void taskTwentyThree() {
        Scanner scanner = new Scanner(System.in);

        String name;
        int weekWorkHours;
        double hourlyPayRate, federalTaxRate, stateTaxRate;

        System.out.print("Enter employee's name: ");
        name = scanner.next();
        System.out.print("Enter number of hours worked in a week: ");
        weekWorkHours = scanner.nextInt();
        System.out.print("Enter hourly pay rate: ");
        hourlyPayRate = scanner.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        federalTaxRate = scanner.nextDouble();
        System.out.print("Enter state tax withholding rate: ");
        stateTaxRate = scanner.nextDouble();

        double grossPay = weekWorkHours * hourlyPayRate;
        double federalWithholding = (federalTaxRate) * grossPay;
        double stateWithholding = (stateTaxRate) * grossPay;
        double totalDeduction = federalWithholding + stateWithholding;
        double netPay = grossPay - totalDeduction;

        System.out.println();
        System.out.println("Employee Name: " + name);
        System.out.println("Hours worked: " + weekWorkHours);
        System.out.printf("Pay Rate: $%4.2f\n", hourlyPayRate);
        System.out.printf("Gross Pay: $%4.2f\n", grossPay);
        System.out.println("Deductions:");
        System.out.printf("\tFederal Withholding (%4.1f%%): $%4.2f\n", federalTaxRate * 100, federalWithholding);
        System.out.printf("\tState Withholding (%4.1f%%): $%4.2f\n", stateTaxRate * 100, stateWithholding);
        System.out.printf("\tTotal Deduction: $%4.2f\n", totalDeduction);
        System.out.printf("Net Pay: $%4.2f\n", netPay);
    }

    public void taskTwentyFour() {
        Scanner scanner = new Scanner(System.in);
        String city1, city2, city3;

        System.out.print("Enter the first city: ");
        city1 = scanner.next();
        System.out.print("Enter the second city: ");
        city2 = scanner.next();
        System.out.print("Enter the third city: ");
        city3 = scanner.next();

        String[] cities = new String[3];
        cities[0] = city1;
        cities[1] = city2;
        cities[2] = city3;
        Arrays.sort(cities);

        System.out.println("The three cities in alphabetical order are: ");
        System.out.println(Arrays.toString(cities));
    }

    public void taskTwentyFive() {
        char randLetter;
        int randNumber;

        System.out.print("Random vehicle plate number: ");

        for (int i = 0; i < 7; i++) {
            if (i < 3) {
                randLetter = (char) ('A' + Math.round(Math.random() * 25));
                System.out.print(randLetter);
            } else {
                randNumber = (int) Math.round(Math.random() * 9);
                System.out.print(randNumber);
            }
        }
    }

    public void taskTwentySix() {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Receive the amount
        System.out.print("Enter an amount in digits, for example 11.56: ");
        String asString = input.next();
        int dotIndex = asString.indexOf('.');
        int dollarsInput = Integer.parseInt(asString.substring(0, dotIndex));
        int centsInput = Integer.parseInt(asString.substring(dotIndex + 1));

        int remainingAmount = dollarsInput * 100 + centsInput;

        int dollars = remainingAmount / 100;
        remainingAmount %= 100;

        int quarters = remainingAmount / 25;
        remainingAmount %= 25;

        int dimes = remainingAmount / 10;
        remainingAmount %= 10;

        int nickels = remainingAmount / 5;
        remainingAmount %= 5;

        // Display results
        System.out.println("Your amount " + asString + " consists of");
        System.out.println(" " + dollars + " dollars");
        System.out.println(" " + quarters + " quarters ");
        System.out.println(" " + dimes + " dimes");
        System.out.println(" " + nickels + " nickels");
        System.out.println(" " + remainingAmount + " pennies");
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
        System.out.println();
        taskTwentyFour();
        System.out.println();
        taskTwentyFive();
        System.out.println();
        taskTwentySix();
    }

}
