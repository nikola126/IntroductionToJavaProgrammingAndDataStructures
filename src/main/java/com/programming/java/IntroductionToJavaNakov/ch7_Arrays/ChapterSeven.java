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

    public static void maxPlatform3x3(int[][] matrix) {
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("The best platform is:");
        System.out.printf(" %d %d %d \n",
                matrix[bestRow][bestCol],
                matrix[bestRow][bestCol + 1],
                matrix[bestRow][bestCol + 2]);
        System.out.printf(" %d %d %d \n",
                matrix[bestRow + 1][bestCol],
                matrix[bestRow + 1][bestCol + 1],
                matrix[bestRow + 1][bestCol + 2]);
        System.out.printf(" %d %d %d \n",
                matrix[bestRow + 2][bestCol],
                matrix[bestRow + 2][bestCol + 1],
                matrix[bestRow + 2][bestCol + 2]);
        System.out.printf("The maximal sum is: %d%n", bestSum);
    }

    public static void taskEleven() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ROWS: ");
        int ROWS = scanner.nextInt();
        System.out.print("Enter COLS: ");
        int COLS = scanner.nextInt();

        int[][] array = new int[ROWS][COLS];

        System.out.println("Enter values for array: ");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("Enter number [%d/%d]: ", i * ROWS + j + 1, ROWS * COLS);
                array[i][j] = scanner.nextInt();
            }
        }
        maxPlatform3x3(array);
    }

    public static void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        int N = 'Z' - 'A';
        char[] alphabet = new char[N];
        for (int i = 0; i < N; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        System.out.print("Enter word: ");
        String word = scanner.next();

        for (char c : word.toCharArray()) {
            int index = 0;
            for (int i = 0; i < alphabet.length; i++) {
                char alpha = alphabet[i];
                if (alpha == Character.toUpperCase(c))
                    System.out.printf("%c is at index %d in the array.\n", c, i);
            }
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid])
                return mid;
            else if (target < array[mid]) {
                right = mid;
            } else
                left = mid + 1;
        }

        return -1;
    }

    public static void taskThirteen() {
        int[] array = new int[]{4, 8, 15, 16, 23, 42};
        int target = 23;
        int index = binarySearch(array, target);

        System.out.printf("Target %d is at index %d.\n", target, index);
    }

    public static void merge(int array[], int start, int mid, int end) {
        // https://www.javatpoint.com/merge-sort
        int i, j, k;
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] LeftArray = new int[n1];
        int[] RightArray = new int[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = array[start + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = array[mid + 1 + j];

        i = 0;
        j = 0;
        k = start;

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                array[k] = LeftArray[i];
                i++;
            } else {
                array[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = RightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int array[], int start, int end) {
        // https://www.javatpoint.com/merge-sort
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static int partition(int array[], int low, int high) {
        // https://www.geeksforgeeks.org/java-program-for-quicksort/
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {
        // https://www.geeksforgeeks.org/java-program-for-quicksort/
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void taskFourteen() {
        int N = 10;
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("Before sort: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        mergeSort(array, 0, array.length - 1);

        System.out.println("After merge sort: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void taskFifteen() {
        int N = 10;
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println("Before sort: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("After quick sort: ");
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static int[] sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeCount += 1;
            }
        }

        int[] primes = new int[primeCount];
        primeCount = 0;

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primes[primeCount++] = i;
        }

        return primes;
    }

    public static void taskSixteen() {
        int N = 10000000;
        int[] primes = sieveOfEratosthenes(N);

        for (int i = 0; i < primes.length; i++) {
            System.out.printf("%d ", primes[i]);
            if ((i + 1) % 5 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static int dfs(int[][] matrix, int target, int row, int col,
                          int ROWS, int COLS, boolean[][] visited) {
        if (row < 0 || row == ROWS)
            return 0;
        if (col < 0 || col == COLS)
            return 0;
        if (visited[row][col])
            return 0;
        if (matrix[row][col] != target)
            return 0;

        visited[row][col] = true;

        return 1 + dfs(matrix, target, row, col + -1, ROWS, COLS, visited) +
                dfs(matrix, target, row - 1, col, ROWS, COLS, visited) +
                dfs(matrix, target, row + 1, col, ROWS, COLS, visited) +
                dfs(matrix, target, row, col + 1, ROWS, COLS, visited);
    }

    public static int findMaxArea(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int maxArea = 0;
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                maxArea = Math.max(maxArea, dfs(matrix, matrix[i][j], i, j, ROWS, COLS, visited));

        return maxArea;
    }

    public static void taskSeventeen() {
        int ROWS = 5;
        int COLS = 6;
        int[][] matrix = new int[ROWS][COLS];

        matrix[0] = new int[]{1, 3, 2, 2, 2, 4};
        matrix[1] = new int[]{3, 3, 3, 2, 4, 4};
        matrix[2] = new int[]{4, 3, 1, 2, 3, 3};
        matrix[3] = new int[]{4, 3, 1, 3, 3, 1};
        matrix[4] = new int[]{4, 3, 3, 3, 1, 1};

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }

        int maxArea = findMaxArea(matrix);
        System.out.println("Max area: " + maxArea);
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
        taskSeventeen();
    }

    public static void main(String[] args) {
        printAll();
    }
}
