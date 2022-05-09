package com.programming.java.IntroductionToJavaNakov.ch7_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ChapterSeven {
    public static void taskOne() {
        int N = 20;
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = i * 5;

        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] arrayOne = new int[N];
        int[] arrayTwo = new int[N];

        System.out.println("Enter values for array 1/2: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            arrayOne[i] = scanner.nextInt();
        }

        System.out.println("Enter values for array 2/2: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            arrayTwo[i] = scanner.nextInt();
        }

        boolean arraysEqual = true;
        for (int i = 0; i < N; i++) {
            if (arrayOne[i] != arrayTwo[i]) {
                arraysEqual = false;
                break;
            }
        }
        System.out.println("Arrays equal? " + arraysEqual);
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string 1/2: ");
        String input = scanner.next();
        char[] wordOne = input.toCharArray();

        System.out.print("Enter string 2/2: ");
        input = scanner.next();
        char[] wordTwo = input.toCharArray();

        int length = Math.min(wordOne.length, wordTwo.length);

        boolean wordOneEarlier = true;

        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(wordOne[i]) > Character.toUpperCase(wordTwo[i])) {
                wordOneEarlier = false;
                break;
            }
        }

        if (wordOneEarlier) {
            System.out.printf("%s is before %s lexicographically.\n",
                    Arrays.toString(wordOne), Arrays.toString(wordTwo));
        } else {
            System.out.printf("%s is before %s lexicographically.\n",
                    Arrays.toString(wordTwo), Arrays.toString(wordOne));
        }
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;
        int [] array = new int[N];
//        int[] array = new int[]{2, 1, 1, 2, 3, 3, 2, 2, 2, 1};
//        int[] array = new int[]{2, 1, 1, 3, 3, 3, 3, 2, 2, 1};

        System.out.println("Enter values for array: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        int endIndex = 0;
        int currentStreak = 1;
        int maxStreak = 0;

        for (int i = 0; i < N - 1; i++) {
            if (array[i] == array[i + 1]) {
                currentStreak += 1;
            } else {
                if (currentStreak >= maxStreak) {
                    maxStreak = currentStreak;
                    currentStreak = 1;
                    endIndex = i - currentStreak + 1;
                }
            }
        }

        System.out.println("Max streak with length " + maxStreak);
        int startIndex = endIndex - maxStreak + 1;

        for (int i = 0; i < N; i++) {
            if (i == startIndex || i == endIndex + 1)
                System.out.print("| ");
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;
        int [] array = new int[N];
//        int[] array = new int[]{3, 2, 3, 4, 2, 2, 4, 1, 1, 1};

        System.out.println("Enter values for array: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        int endIndex = 0;
        int currentStreak = 1;
        int maxStreak = 0;

        for (int i = 0; i < N - 1; i++) {
            if (array[i] < array[i + 1]) {
                currentStreak += 1;
            } else {
                if (currentStreak >= maxStreak) {
                    maxStreak = currentStreak;
                    currentStreak = 1;
                    endIndex = i - currentStreak + 1;
                }
            }
        }

        System.out.println("Max streak with length " + maxStreak);
        int startIndex = endIndex - maxStreak + 1;

        for (int i = 0; i < N; i++) {
            if (i == startIndex || i == endIndex + 1)
                System.out.print("| ");
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }



    public static void printAll() {
//        taskOne();
//        taskTwo();
//        taskThree();
//        taskFour();
        taskFive();
    }

    public static void main(String[] args) {
        printAll();
    }
}
