package com.programming.java.IntroductionToJavaNakov.ch9_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class ChapterNine {
    public static void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.next();

        sayHello(name);
    }

    public static int getMax(int n1, int n2) {
        return Math.max(n1, n2);
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n1: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter n2: ");
        int n2 = scanner.nextInt();
        System.out.print("Enter n3: ");
        int n3 = scanner.nextInt();

        System.out.println("Max: " + getMax(getMax(n1, n2), n3));
    }

    public static void lastDigitEnglish(int n) {
        switch (n % 10) {
            case 0: {
                System.out.println("zero");
                break;
            }
            case 1: {
                System.out.println("one");
                break;
            }
            case 2: {
                System.out.println("two");
                break;
            }
            case 3: {
                System.out.println("three");
                break;
            }
            case 4: {
                System.out.println("four");
                break;
            }
            case 5: {
                System.out.println("five");
                break;
            }
            case 6: {
                System.out.println("six");
                break;
            }
            case 7: {
                System.out.println("seven");
                break;
            }
            case 8: {
                System.out.println("eight");
                break;
            }
            case 9: {
                System.out.println("nine");
                break;
            }
        }
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        lastDigitEnglish(N);
    }

    public static int countOccurences(int[] array, int target) {
        int count = 0;
        for (int number : array)
            if (number == target)
                count += 1;

        return count;
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter value [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter target: ");
        int target = scanner.nextInt();

        int occurences = countOccurences(array, target);
        System.out.printf("%d is in the array %d times.\n", target, occurences);
    }

    public static int isPeak(int[] array, int index) {
        if (index == 0 || index == array.length - 1)
            return 0;

        if (array[index - 1] < array[index] && array[index] > array[index + 1])
            return 1;
        if (array[index - 1] > array[index] && array[index] < array[index + 1])
            return -1;

        return 0;
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter value [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter target position: ");
        int target = scanner.nextInt();

        if (isPeak(array, target) == 1) {
            System.out.println(target + " is peak.");
        } else if (isPeak(array, target) == -1) {
            System.out.println(target + " is valley.");
        }
    }

    public static int findFirstPeak(int[] array) {
        int firstPeak = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (isPeak(array, i) == 1)
                return i;
        }
        return firstPeak;
    }

    public static void taskSix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter value [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        System.out.println("First peak at position " + findFirstPeak(array) + ".");
    }

    public static void reverseNumber(int N) {
        if (N == 0) {
            System.out.println(N);
            return;
        }
        while (N > 0) {
            System.out.print(N % 10);
            N /= 10;
        }
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        System.out.print(N + " in reverse: ");
        reverseNumber(N);
        System.out.println();
    }

    public static int[] multiply(int[] a, int[] b) {
        int BUFFER_SIZE = 200;
        int[] buffer = new int[BUFFER_SIZE];
        int offset = 0;
        int pos = offset;
        int maxPos = 0;
        int carry = 0;
        for (int j = b.length - 1; j >= 0; j--) {
            for (int i = a.length - 1; i >= 0; i--) {
                int digitA = a[i];
                int digitB = b[j];

                int calculation = digitA * digitB;

                int toPlace = buffer[pos] + calculation + carry;

                if (toPlace >= 10) {
                    carry = toPlace / 10;
                } else
                    carry = 0;
                buffer[pos] = toPlace % 10;
                pos += 1;
            }

            if (carry > 0) {
                buffer[pos] = carry;
                carry = 0;
                pos++;
            }

            maxPos = Math.max(maxPos, pos);
            offset += 1;
            pos = offset;
        }
        return Arrays.copyOfRange(reverseArray(buffer), BUFFER_SIZE - maxPos, BUFFER_SIZE);
    }

    public static int[] convertToArray(int N) {
        int BUFFER_SIZE = 200;
        int[] buffer = new int[BUFFER_SIZE];
        int i = BUFFER_SIZE - 1;
        int bufferLength = 0;

        while (N > 0) {
            buffer[i] = N % 10;
            N /= 10;
            i--;
            bufferLength += 1;
        }

        return Arrays.copyOfRange(buffer, BUFFER_SIZE - bufferLength, BUFFER_SIZE);
    }

    public static int[] reverseArray(int[] array) {
        int N = array.length;
        int[] reversed = new int[N];
        int pos = 0;
        for (int i = N - 1; i >= 0; i--) {
            reversed[pos] = array[i];
            pos += 1;
        }
        return reversed;
    }

    public static void normalPrint(int[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.printf("%d", array[i]);
        System.out.println();
    }

    public static void taskEight() {
        int targetFactorial = 100;
        int[] factorial = convertToArray(1);

        for (int i = 2; i <= targetFactorial; i++) {
            int[] next = convertToArray(i);
            factorial = multiply(factorial, next);
        }

        System.out.printf("Factorial of %d is: \n", targetFactorial);
        normalPrint(reverseArray(factorial));
    }

    public static void printMenu() {
        System.out.println("---------------------------");
        System.out.println("[1] - Reverse number");
        System.out.println("[2] - Calculate Average");
        System.out.println("[3] - Solve Linear Equation");
        System.out.println("[0] - Exit");
        System.out.println("---------------------------");
    }

    public static void getAverage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sequence length: ");
        int N = scanner.nextInt();
        float sum = 0;
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter value [%d/%d]: ", i + 1, N);
            values[i] = scanner.nextInt();
            sum += values[i];
        }

        float average = sum / N;
        System.out.println("Average of sequence: " + average);
    }

    public static void solveLinearEquation() {
        System.out.println("Ax + B = 0");
        System.out.println("----------");
        Scanner scanner = new Scanner(System.in);
        double A, B, X;
        System.out.print("Enter A: ");
        A = scanner.nextDouble();
        System.out.println("Enter B: ");
        B = scanner.nextDouble();
        X = -B / A;
        System.out.println("X = " + X);
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            printMenu();
            System.out.print("Enter command >> ");
            input = scanner.nextInt();
            switch (input) {
                case 1: {
                    System.out.print("Enter number: ");
                    input = scanner.nextInt();
                    if (input < 0)
                        System.out.println("Input must be non-negative!");
                    System.out.print(input + " in reverse: ");
                    reverseNumber(input);
                    System.out.println();
                    break;
                }
                case 2: {
                    getAverage();
                    break;
                }
                case 3: {
                    solveLinearEquation();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Unknown command!");
                }
            }
        }
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Example polynomial: [Ax + By + Cz]");

        int[] poly1 = new int[3];
        int[] poly2 = new int[3];

        System.out.println("Enter polynomial 1: ");
        System.out.print("A = ");
        poly1[0] = scanner.nextInt();
        System.out.print("B = ");
        poly1[1] = scanner.nextInt();
        System.out.print("C = ");
        poly1[2] = scanner.nextInt();

        System.out.println("Enter polynomial 2: ");
        System.out.print("A = ");
        poly2[0] = scanner.nextInt();
        System.out.print("B = ");
        poly2[1] = scanner.nextInt();
        System.out.print("C = ");
        poly2[2] = scanner.nextInt();

        // X^2 Y^2 Z^2 XY YZ XZ
        int[] product = new int[6];
        for (int i = 0; i < 3; i++) {
            int term1 = poly1[i];
            for (int j = 0; j < 3; j++) {
                int term2 = poly2[j];

                if (i == j)
                    product[i] += term1 * term2;
                if (i == 0 && j == 1)
                    product[3] += term1 * term2;
                if (i == 1 && j == 2)
                    product[4] += term1 * term2;
                if (i == 0 && j == 2)
                    product[5] += term1 * term2;
            }
        }

        System.out.printf("((%d)x + (%d)y + (%d)z) * ", poly1[0], poly1[1], poly1[2]);
        System.out.printf("((%d)x + (%d)y + (%d)z) =\n", poly2[0], poly2[1], poly2[2]);
        System.out.printf("= (%d)x^2 + (%d)y^2 + (%d)z^2 + (%d)xy + (%d)yz + (%d)xz\n",
                product[0], product[1], product[2], product[3], product[4], product[5]);
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
    }

    public static void main(String[] args) {
        printAll();
    }
}
