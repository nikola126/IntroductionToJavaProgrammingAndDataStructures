package com.programming.java.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ChapterTwelve {
    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);

        int operand1 = 0, operand2 = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter operand 1: ");
                operand1 = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }

        validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter operand 2: ");
                operand2 = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }

        System.out.printf("Sum of %d and %d is: %d\n", operand1, operand2, (operand1 + operand2));
    }

    public static void taskThree() {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++)
            array[i] = (int) Math.round(Math.random() + 1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index of the array (<100): ");
        try {
            int index = scanner.nextInt();
            System.out.printf("Array[%d] = %d\n", index, array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        }
    }

    public static void taskTen() {
        try {
            Integer[] array = new Integer[100000 * 100000];
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory! Stopping gracefully...");
        } finally {
            System.out.println("End of Program Reached");
        }
    }

    public static void taskThirteen() {
        File file = new File("scores.txt");

        Scanner input;
        int characters = 0, words = 0, lines = 0;

        // Create a Scanner for the file
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
            return;
        }

        // Read data from a file
        while (input.hasNext()) {
            String s = input.next();
            for (char c : s.toCharArray()) {
                if (c == '\n')
                    lines += 1;
                else
                    characters += 1;
            }
            words += 1;
        }

        // Close the file
        input.close();

        System.out.println(characters + " characters");
        System.out.println(words + " words");
        System.out.println(lines + " lines");
    }

    public static void taskFourteen() {
        File file = new File("scores.txt");

        Scanner input;
        int total = 0, count = 0;

        // Create a Scanner for the file
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
            return;
        }

        // Read data from a file
        while (input.hasNext()) {
            String score = input.next();
            try {
                total += Integer.parseInt(score);
                count += 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid score: " + score);
            }
        }

        // Close the file
        input.close();

        System.out.println("Total: " + total);
        System.out.println("Average: " + total / count);
    }

    public static void taskFifteen() {
        File file = new File("scores.text");
        Random random = new Random();

        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        // Create a file
        PrintWriter output;

        try {
            output = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // Write formatted output to the file
        for (int i = 0; i < 100; i++) {
            output.printf("%d ", random.nextInt(100));
        }

        // Close the file
        output.close();
    }
}
