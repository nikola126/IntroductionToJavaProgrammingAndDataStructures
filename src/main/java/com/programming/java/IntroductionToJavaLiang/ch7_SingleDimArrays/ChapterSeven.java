package com.programming.java.IntroductionToJavaLiang.ch7_SingleDimArrays;

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

    public static void taskSix() {
        final int NUMBER_OF_PRIMES = 50; // Number of primes to display
        final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        int[] primes = new int[NUMBER_OF_PRIMES];
        int primeIdx = 0;

        System.out.println("The first 50 prime numbers are \n");

        // Repeatedly find prime numbers
        while (primeIdx < NUMBER_OF_PRIMES) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test whether number is prime
            for (int divisor = 2; divisor <= Math.floor(Math.sqrt(number)); divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Display the prime number and increase the count
            if (isPrime) {
                primes[primeIdx] = number;
                primeIdx += 1;
            }

            // Check if the next number is prime
            number++;
        }

        for (int prime : primes) {
            if (prime != 0) {
                System.out.printf("%d ", prime);
                count += 1;
                if (count == 10) {
                    System.out.println();
                    count = 0;
                }
            }
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

        while (start < end) {
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
        int N = 10;

        int[] intArray = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer value (%d/%d): ", i + 1, N);
            intArray[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(reverse(intArray)));
    }

    public static int getRandom(int start, int end, int... numbers) {
        int random = start + (int) (Math.random() * end);

        while (linearSearch(numbers, random) != -1) {
            random = start + (int) (Math.random() * end);
        }

        return random;
    }

    public static void taskThirteen() {
        int N = 45;
        int count = 0;

        int[] numbers = new int[45];
        for (int i = 0; i < N; i++) {
            numbers[i] = getRandom(1, 100, 4, 8, 95, 93);
        }

        for (int number : numbers) {
            System.out.printf("%4d ", number);
            count += 1;
            if (count == 15) {
                count = 0;
                System.out.println();
            }
        }

    }

    public static int gcd(int... numbers) {
        // https://www.geeksforgeeks.org/gcd-two-array-numbers/
        if (numbers.length == 2) {
            int a = numbers[0];
            int b = numbers[1];

            if (a == 0)
                return b;
            return gcd(b % a, a);
        } else {
            int result = numbers[0];
            for (int element : numbers) {
                result = gcd(result, element);

                if (result == 1) {
                    return 1;
                }
            }
            return result;
        }
    }

    public static void taskFourteen() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;

        int[] arrayInt = new int[N];
        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer value (%d/%d): ", i + 1, N);
            arrayInt[i] = scanner.nextInt();
        }
        System.out.printf("GCD of int array is: %d\n", gcd(arrayInt));
    }

    public static int[] eliminateDuplicates(int[] list) {
        int[] copy = new int[list.length];
        int count = 0;

        for (int i = 0; i < list.length; i++) {
            int number = list[i];
            if (linearSearch(copy, number) == -1) {
                copy[i] = number;
                count += 1;
            }
        }

        int[] distinct = new int[count];
        int idx = 0;
        for (int number : copy) {
            if (number != 0) {
                distinct[idx] = number;
                idx += 1;
            }
        }

        return distinct;
    }

    public static void taskFifteen() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        int[] arrayInt = new int[N];
        double[] doubleInt = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer value (%d/%d): ", i + 1, N);
            arrayInt[i] = scanner.nextInt();
        }
        System.out.println("The distinct numbers are: " + Arrays.toString(eliminateDuplicates(arrayInt)));
    }

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }

        return -low - 1; // Now high < low, key not found
    }

    public static void taskSixteen() {
        int N = 100000;
        int[] array = new int[N];
        int key = (int) (Math.random() * 10);

        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 10);
        }

        Arrays.sort(array);

        long startTime = System.nanoTime();
        linearSearch(array, key);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution time of linear search: " + executionTime);

        startTime = System.nanoTime();
        binarySearch(array, key);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;

        System.out.println("Execution time of binary search: " + executionTime);
    }

    public static void bubbleSort(double[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {

                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void bubbleSortExtended(double[] arr, String[] names) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    String tempName = names[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
    }

    public static void taskSeventeen() {
        Scanner scanner = new Scanner(System.in);
        int N = 3;

        double[] doubleArr = new double[N];
        String[] namesArr = new String[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleArr[i] = scanner.nextDouble();
            System.out.printf("Enter name (%d/%d): ", i + 1, N);
            namesArr[i] = scanner.next();
        }

        bubbleSortExtended(doubleArr, namesArr);

        System.out.printf("%s\t%s\n", "Name", "Grade");
        for (int i = N - 1; i >= 0; i--) {
            System.out.printf("%s\t%.2f\n", namesArr[i], doubleArr[i]);
        }
    }

    public static void taskEighteen() {
        Scanner scanner = new Scanner(System.in);
        int N = 10;

        double[] doubleArr = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleArr[i] = scanner.nextDouble();
        }

        bubbleSort(doubleArr);

        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(doubleArr));
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public static void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;

        int[] intArr = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter integer value (%d/%d): ", i + 1, N);
            intArr[i] = scanner.nextInt();
        }

        if (isSorted(intArr)) {
            System.out.println("The array is sorted!");
        } else {
            System.out.println("The array is NOT sorted!");
        }
    }

    public static void taskTwenty() {
        Scanner scanner = new Scanner(System.in);
        int N = 5;

        double[] doubleArr = new double[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter double value (%d/%d): ", i + 1, N);
            doubleArr[i] = scanner.nextDouble();
        }

        selectionSort(doubleArr);

        System.out.println("Sorted array: " + Arrays.toString(doubleArr));
    }

    public static void selectionSort(double[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            // Find the minimum in the list[i..list.length−1]
            double currentMax = list[i];
            int currentMaxIndex = i;

            for (int j = list.length - 2; j > i; j--) {
                if (currentMax > list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }

            // Swap list[i] with list[currentMinIndex] if necessary
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }

    public static void taskTwentyOne(String[] args) {
        int total = 0;
        for (String asString : args) {
            int value = Integer.parseInt(asString);
            total += value;
        }

        System.out.println("Total: " + total);
    }

    public static void taskTwentyTwo(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java taskTwentyTwo String");
            return;
        }

        int countUppercase = 0;
        for (char c : args[0].toCharArray()) {
            if (Character.isUpperCase(c))
                countUppercase += 1;
        }

        System.out.println("Uppercase letters in " + args[0] + ": " + countUppercase);
    }

    public static void printAll() {
        ChapterSeven.taskOne();
        ChapterSeven.taskTwo();
        ChapterSeven.taskThree();
        ChapterSeven.taskFour();
        ChapterSeven.taskFive();
        ChapterSeven.taskSix();
        ChapterSeven.taskSeven();
        ChapterSeven.taskEight();
        ChapterSeven.taskNine();
        ChapterSeven.taskTen();
        ChapterSeven.taskEleven();
        ChapterSeven.taskTwelve();
        ChapterSeven.taskThirteen();
        ChapterSeven.taskFourteen();
        ChapterSeven.taskFifteen();
        ChapterSeven.taskSixteen();
        ChapterSeven.taskSeventeen();
        ChapterSeven.taskEighteen();
        ChapterSeven.taskNineteen();
        ChapterSeven.taskTwenty();
        ChapterSeven.taskTwentyOne(new String[]{"1", "2", "3"});
        ChapterSeven.taskTwentyTwo(new String[]{"Hello World"});
    }

}
