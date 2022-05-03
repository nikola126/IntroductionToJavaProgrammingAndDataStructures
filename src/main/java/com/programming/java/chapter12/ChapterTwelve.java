package com.programming.java.chapter12;

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
}
