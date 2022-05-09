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
        int[] array = new int[N];
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
        int[] array = new int[N];
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

    // Task Seven
    public static void selectionSort(int[] arr) {
        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[minElementIndex] > arr[j])
                    minElementIndex = j;
            }

            if (minElementIndex != i) {
                int swap = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = swap;
            }
        }
    }

    public static void taskSix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter K: ");
        int K = scanner.nextInt();

        System.out.printf("The K(%d) elements with maximum sum are:\n", K);
        for (int i = 0; i < K; i++) {
            System.out.printf("%d ", array[N - 1 - i]);
        }
        System.out.println();
    }

    public static void taskSeven() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] array = new int[N];

        System.out.println("Enter values for array: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        System.out.println("Sorted: ");
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void taskEight() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] array = new int[N];

        System.out.println("Enter values for array: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        int major = array[0];
        int count = 1;

        for (int i = 1; i < N; i++) {
            int current = array[i];
            if (current == major) {
                count += 1;
            } else {
                if (count == 0) {
                    major = array[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        System.out.println("Majority element: " + major);
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] array = new int[N];

        System.out.print("Enter target value: ");
        int target = scanner.nextInt();

        System.out.println("Enter values for array: ");
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter number [%d/%d]: ", i + 1, N);
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int currentSum = 0;
            for (int j = i; j < N; j++) {
                currentSum += array[j];
                if (currentSum > target)
                    break;
                else if (currentSum == target) {
                    System.out.print("Sum found: ");
                    for (int k = i; k <= j; k++)
                        System.out.printf("%d ", array[k]);
                    System.out.println();
                    break;
                }
            }
        }
    }

    public static void matrixFormatA(int[][] matrix) {
        int N = matrix.length;
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void matrixFormatB(int[][] matrix) {
        int N = matrix.length;
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if (row % 2 == 0) {
                    System.out.printf("%d ", matrix[row][col]);
                } else {
                    System.out.printf("%d ", matrix[row][N - 1 - col]);
                }
            }
            System.out.println();
        }
    }

    public static void matrixFormatC(int[][] matrix) {
        int N = matrix.length;
        int[][] formatted = new int[N][N];
        int i = 0;
        int j = 0;
        int row = N - 1 - j;
        int col = 0;

        while (i < N * N) {
            if (row < 0 || col < 0) {
                row++;
                col++;
                continue;
            }
            if (row == N || col == N) {
                j++;
                row = N - 1 - j;
                col = 0;
                continue;
            }
            formatted[row][col] = matrix[i / N][i % N];
            i++;
            row++;
            col++;
        }

        for (int rw = 0; rw < N; rw++) {
            for (int cl = 0; cl < N; cl++) {
                System.out.printf("%d ", formatted[rw][cl]);
            }
            System.out.println();
        }
    }

    public static void matrixFormatD(int[][] matrix) {
        int N = matrix.length;
        int[][] formatted = new int[N][N];
        int count = 0;
        int left = 0;
        int right = N;
        int top = 0;
        int bottom = N;

        while (left < right && top < bottom) {
            for (int i = top; i < bottom; i++) {
                formatted[i][top] = matrix[count / N][count % N];
                count++;
            }
            left += 1;

            for (int i = left; i < right; i++) {
                formatted[bottom - 1][i] = matrix[count / N][count % N];
                count++;
            }
            bottom -= 1;

            if (left < right && top < bottom) ;
            else
                break;

            for (int i = bottom - 1; i >= top; i--) {
                formatted[i][right - 1] = matrix[count / N][count % N];
                count++;
            }
            right -= 1;

            for (int i = right - 1; i >= left; i--) {
                formatted[top][i] = matrix[count / N][count % N];
                count++;
            }
            top += 1;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.printf("%d ", formatted[row][col]);
            }
            System.out.println();
        }
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                matrix[row][col] = row * N + col + 1;
            }
            System.out.println();
        }

        System.out.println("Format A:");
        matrixFormatA(matrix);
        System.out.println("Format B:");
        matrixFormatB(matrix);
        System.out.println("Format C:");
        matrixFormatC(matrix);
        System.out.println("Format D:");
        matrixFormatD(matrix);
    }

    public static void printAll() {
//        taskOne();
//        taskTwo();
//        taskThree();
//        taskFour();
//        taskFive();
//        taskSix();
//        taskSeven();
//        taskEight();
//        taskNine();
        taskTen();
    }

    public static void main(String[] args) {
        printAll();
    }
}
