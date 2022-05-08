package com.programming.java.IntroductionToJavaNakov.ch6_Loops;

import java.util.Random;
import java.util.Scanner;

public class ChapterSix {
    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.printf("Numbers between 1 and %d: \n", N);
        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ", i);
        }
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.println("Divisible by 3 and 7:");
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0 && i % 7 == 0)
                System.out.printf("%d ", i);
        }
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.println("Enter numbers (0 to stop): ");
        while (true) {
            System.out.print(">> ");
            int N = scanner.nextInt();
            if (N == 0)
                break;
            max = Math.max(max, N);
            min = Math.min(min, N);
        }

        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
    }

    public static void taskFour() {
        String[] suits = new String[]{"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] cards = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        System.out.println("Cards: ");
        for (String suit : suits) {
            for (String card : cards) {
                System.out.printf("%s of %s\n", suit, card);
            }
        }
    }

    public static int fibonacci(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;

        return fibonacci(N - 1) + fibonacci(N - 2);
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += fibonacci(i);
        }

        System.out.printf("Fibonacci sum from 1 to %d is: %d ", N, sum);
    }

    public static int factorial(int N) {
        if (N == 1)
            return 1;

        return N * factorial(N - 1);
    }

    public static long factorial(long N) {
        if (N == 1)
            return 1;

        return N * factorial(N - 1);
    }

    public static void taskSix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        System.out.print("Enter K: ");
        int K = scanner.nextInt();

        int result = factorial(N) / factorial(K);
        System.out.printf("%d!/%d! = %d\n", N, K, result);
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        System.out.print("Enter K: ");
        int K = scanner.nextInt();

        int result = (factorial(N) / factorial(K)) / (factorial(N - K));
        System.out.printf("%d!*%d!/(%d-%d)! = %d\n", N, K, N, K, result);
    }

    public static void taskEight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        long N = scanner.nextInt();
        System.out.print("Enter X: ");
        long X = scanner.nextInt();

        long S = 1;
        for (int i = 1; i <= N; i++) {
            S += (factorial(i) / Math.pow(X, i));
        }

        System.out.println("Sum of series: " + S);
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        long N = scanner.nextInt();

        long C = factorial(2 * N) / (factorial(N + 1) * factorial(N));

        System.out.printf("Catalan(%d) = %d\n ", N, C);
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N + i; j++) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }

    public static void taskEleven() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        int zeros = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0)
                zeros += 1;
        }

        System.out.println("Zeros in factorial: " + zeros);
    }

    public static String decimalToBinary(int N) {
        StringBuilder bin = new StringBuilder();

        while (N != 0) {
            if (N % 2 == 0)
                bin.append("0");
            else
                bin.append("1");
            N /= 2;
        }

        return bin.reverse().toString();
    }

    public static int binaryToDecimal(String bin) {
        int decimalValue = 0;
        int power = 0;

        for (int i = bin.length() - 1; i >= 0; i--) {
            char binChar = bin.charAt(i);
            if (binChar == '0' || binChar == '1') {
                decimalValue += Integer.parseInt(String.valueOf(binChar)) * Math.pow(2, power);
                power += 1;
            }
        }

        return decimalValue;
    }

    public static String decimalToHexadecimal(int N) {
        return Integer.toString(N, 16);
    }

    public static int hexadecimalToDecimal(String hexadecimal) {
        int decimalValue = 0;
        int power = 0;

        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            char binChar = Character.toUpperCase(hexadecimal.charAt(i));
            switch (binChar) {
                case 'A': {
                    decimalValue += 10 * Math.pow(16, power);
                    break;
                }
                case 'B': {
                    decimalValue += 11 * Math.pow(16, power);
                    break;
                }
                case 'C': {
                    decimalValue += 12 * Math.pow(16, power);
                    break;
                }
                case 'D': {
                    decimalValue += 13 * Math.pow(16, power);
                    break;
                }
                case 'E': {
                    decimalValue += 14 * Math.pow(16, power);
                    break;
                }
                case 'F': {
                    decimalValue += 15 * Math.pow(16, power);
                    break;
                }
                default: {
                    decimalValue += Integer.parseInt(String.valueOf(binChar)) * Math.pow(16, power);
                    break;
                }
            }
            power += 1;
        }

        return decimalValue;
    }

    public static void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter decimal integer: ");
        int N = scanner.nextInt();

        System.out.printf("%d in binary: %s\n", N, decimalToBinary(N));
    }

    public static void taskThirteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter binary integer: ");
        String N = scanner.next();

        System.out.printf("%s in decimal: %s\n", N, binaryToDecimal(N));
    }

    public static void taskFourteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter decimal integer: ");
        int N = scanner.nextInt();

        System.out.printf("%s in hexadecimal: %s\n", N, decimalToHexadecimal(N));
    }

    public static void taskFifteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hexadecimal integer: ");
        String N = scanner.next();

        System.out.printf("%s in decimal: %s\n", N, hexadecimalToDecimal(N));
    }

    public static void taskSixteen() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.printf("Random integer between 1 and %d: %d\n", N, random.nextInt(1, N));
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
        taskEleven();
        taskTwelve();
        taskThirteen();
        taskFourteen();
        taskFifteen();
        taskSixteen();
    }

    public static void main(String[] args) {
        printAll();
    }
}
