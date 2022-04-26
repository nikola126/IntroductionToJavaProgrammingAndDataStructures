package com.programming.java.chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class ChapterSeven {
    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scanner.nextInt();

        int[] scores = new int[N];
        int bestScore = -1;
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
            bestScore = Math.max(bestScore, scores[i]);
        }

        for (int i = 0; i < N; i++) {
            char grade;

            if (scores[i] <= bestScore - 10) {
                grade = 'A';
            } else if (scores[i] <= bestScore - 20) {
                grade = 'B';
            } else if (scores[i] <= bestScore - 30) {
                grade = 'C';
            } else if (scores[i] <= bestScore - 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.printf("Student %d score is %d and grade is %c\n", i, scores[i], grade);
        }
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;
        int[] digits = new int[N];
        System.out.printf("Enter %d digits: ", N);

        for (int i = 0; i < N; i++) {
            digits[i] = scanner.nextInt();
        }

        System.out.println("Reversed: ");
        for (int i = N - 1; i >= 0; i--) {
            System.out.printf("%d ", digits[i]);
        }
    }

    public static void taskThree() {
        Scanner scanner = new Scanner(System.in);
        int N = 100;
        int[] digits = new int[N];

        int input = -1;

        System.out.println("Enter digits between 1 and 100: ");
        while (input != 0) {
            input = scanner.nextInt();

            if (input == 0 || input < 1 || input > N)
                break;
            else {
                digits[input - 1] += 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (digits[i] != 0) {
                if (digits[i] == 1)
                    System.out.printf("%d occurs %d time.\n", i + 1, digits[i]);
                else
                    System.out.printf("%d occurs %d times.\n", i + 1, digits[i]);
            }
        }
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        int N = 100;
        int[] scores = new int[N];
        double sum = 0.0;
        int count = 0;
        double average = 0;

        int input = 0;
        System.out.println("Enter numbers (enter negative to stop): ");
        while (input >= 0) {
            input = scanner.nextInt();

            if (input < 0)
                break;

            scores[count] = input;
            sum += input;
            count += 1;
        }

        average = sum / count;
        int aboveAverage = 0, belowAverage = 0;

        for (int score : scores) {
            if (score < average)
                belowAverage += 1;
            else
                aboveAverage += 1;
        }

        System.out.println("Average: " + average);
        System.out.println("Above/equal to average: " + aboveAverage);
        System.out.println("Below average: " + belowAverage);
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[] numbers = new int[N];
        int input = 0;
        int distinct = 0;

        System.out.println("Enter " + N + " positive numbers: ");

        for (int i = 0; i < N; i++) {
            input = scanner.nextInt();
            if (linearSearch(numbers, input) == -1) {
                distinct += 1;
                numbers[i] = input;

            }
        }

        System.out.println("There are " + distinct + " distinct numbers");
        System.out.println("They are: ");
        Arrays.sort(numbers);
        for (int i = 0; i < N; i++) {
            if (numbers[i] != 0)
                System.out.printf("%d ", numbers[i]);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static void taskSeven() {
        int[] counts = new int[10];

        for (int i = 0; i < 100; i++) {
            int index = (int) (Math.random() * 10);
            counts[index] += 1;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("counts[" + i + "] = " + counts[i]);
        }
    }

    public static double average(int[] array) {
        double sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        return sum / array.length;
    }

    public static void taskEight() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        int[] arrayInt = new int[N];
        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer value (%d/%d): ", i + 1, N);
            arrayInt[i] = scanner.nextInt();
        }
        System.out.printf("Average of int array is: %.2f\n", average(arrayInt));

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleInt[i] = scanner.nextDouble();
        }
        System.out.printf("Average of double array is: %.2f\n", average(doubleInt));
    }

    public static double min(double[] array) {
        double min = array[0];
        for (double value : array) {
            min = Math.min(min, value);
        }
        return min;
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleInt[i] = scanner.nextDouble();
        }
        System.out.printf("Minimum of the array is: %.2f\n", min(doubleInt));
    }

    public static int indexOfSmallestElement(double[] array) {
        double min = array[0];
        int minIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] <= min) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleInt[i] = scanner.nextDouble();
        }
        System.out.printf("Index of smallest element is: %d\n", indexOfSmallestElement(doubleInt));
    }

    public static double deviation(double[] x) {
        double sum = 0;
        double n = x.length;
        double mean = mean(x);
        for (double value : x) {
            sum += Math.pow((value - mean), 2);
        }
        return Math.sqrt(sum / (n - 1));
    }

    public static double mean(double[] x) {
        double sum = 0;
        double n = x.length;
        for (double value : x)
            sum += value;
        return sum / n;
    }

    public static void taskEleven() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleInt[i] = scanner.nextDouble();
        }
        System.out.printf("The mean is: %.2f\n", mean(doubleInt));
        System.out.printf("The standard deviation is: %.2f\n", deviation(doubleInt));
    }

    public static int[] reverse(int[] list) {
        int start = 0;
        int end = list.length - 1;

        while(start < end) {
            int swap = list[start];
            list[start] = list[end];
            list[end] = swap;

            start++;
            end--;
        }
        return list;
    }

    public static void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        int N = 510;

        int[] intArray = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            intArray[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(reverse(intArray)));
    }



}
