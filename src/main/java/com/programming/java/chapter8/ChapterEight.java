package com.programming.java.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class ChapterEight {
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                if (col == columnIndex)
                    sum += m[row][col];
            }
        }

        return sum;
    }

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);

        int row = 3;
        int col = 4;
        System.out.printf("Enter %d*%d matrix row by row: \n", row, col);
        double[][] matrix = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        for (int j = 0; j < col; j++) {
            System.out.printf("Sum of elements in column %d is: %.2f\n", j + 1, sumColumn(matrix, j));
        }
    }

    public static double sumMajorDiagonal(double[][] m) {
        int N = m.length;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += m[i][i];
        }

        return sum;
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);

        int row = 3;
        int col = 3;
        System.out.printf("Enter %d*%d matrix row by row: \n", row, col);
        double[][] matrix = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.printf("Sum of elements along main diagonal is: %.2f\n", sumMajorDiagonal(matrix));
    }

    public static void bubbleSort2D(int[][] table) {
        int n = table.length;

        for (int i = 0; i < table.length - 1; i++) {
            if (table[i][1] > table[i + 1][1]) {
                int tempIndex = table[i][0];
                int tempScore = table[i][1];

                table[i][0] = table[i + 1][0];
                table[i + 1][0] = tempIndex;

                table[i][1] = table[i + 1][1];
                table[i + 1][1] = tempScore;
            }
        }
    }

    public static void gradeExam() {
        // Students' answers to the questions
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        // Key to the questions
        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        int[][] table = new int[answers.length][2];

        // Grade all answers
        for (int i = 0; i < answers.length; i++) {
            // Grade one student
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j])
                    correctCount++;
            }

            System.out.println("Student " + i + "'s correct count is " +
                    correctCount);
            table[i][0] = i;
            table[i][1] = correctCount;
        }

        bubbleSort2D(table);

        for (int[] ints : table) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void taskFour() {
        int EMPLOYEES = 7;
        int WEEK_DAYS = 7;
        int[][] table = {{2, 4, 3, 4, 5, 8, 8}, {2, 4, 3, 4, 5, 1, 8}, {2, 4, 3, 4, 5, 2, 8},
                {2, 4, 3, 4, 5, 3, 8}, {2, 4, 3, 4, 5, 4, 8}, {2, 4, 3, 4, 5, 5, 8},
                {2, 4, 3, 4, 5, 6, 8}};

        int[][] totals = new int[EMPLOYEES][2];

        int idx = 0;
        for (int[] employee : table) {
            int sum = 0;
            for (int hour : employee) {
                sum += hour;
            }
            totals[idx][0] = idx;
            totals[idx][1] = sum;
            idx += 1;
        }

        bubbleSort2D(totals);

        for (int i = 0; i < idx; i++) {
            System.out.println(Arrays.toString(totals[i]));
        }
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] sum = new double[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }

        return sum;
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);

        int row = 3;
        int col = 3;
        double[][] matrix1 = new double[row][col];
        double[][] matrix2 = new double[row][col];

        System.out.printf("Enter %d*%d matrix 1 row by row: \n", row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        System.out.printf("Enter %d*%d matrix 2 row by row: \n", row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Sum of matrix 1 and 2 is:");
        System.out.println(Arrays.deepToString(addMatrix(matrix1, matrix2)));
    }
}
