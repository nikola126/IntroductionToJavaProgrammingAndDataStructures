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

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] product = new double[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                product[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return product;
    }

    public static void taskSix() {
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

        System.out.println("Product of matrix 1 and 2 is:");
        System.out.println(Arrays.deepToString(multiplyMatrix(matrix1, matrix2)));
    }

    public static void taskSeven() {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
                {5.5, 4, -0.5}};

        double maxDistance = 0;

        for (int i = 0; i < points.length - 1; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + 1];

            double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) +
                    Math.pow(point2[1] - point1[1], 2) +
                    Math.pow(point2[2] - point1[2], 2));

            maxDistance = Math.max(maxDistance, distance);
        }

        System.out.println("Max distance: " + maxDistance);
    }

    public static void taskEight() {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2},
                {5.5, 4, -0.5}};

        double[] point1;
        double[] point2;

        double minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {
            point1 = points[i];
            point2 = points[i + 1];

            double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) +
                    Math.pow(point2[1] - point1[1], 2) +
                    Math.pow(point2[2] - point1[2], 2));

            minDistance = Math.min(minDistance, distance);
        }

        for (int i = 0; i < points.length - 1; i++) {
            point1 = points[i];
            point2 = points[i + 1];

            double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) +
                    Math.pow(point2[1] - point1[1], 2) +
                    Math.pow(point2[2] - point1[2], 2));

            if (distance == minDistance) {
                System.out.println("The closest two points are " + Arrays.toString(point1) + " and "
                        + Arrays.toString(point2));
            }
        }
        System.out.println("Min distance: " + minDistance);
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println("------------");
            System.out.print("|");
            for (char cell : row) {
                System.out.printf("% c |", cell);
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    public static boolean checkWin(char[][] board, char player) {
        int REQUIRED = board.length;
        int points = 0;

        // check rows
        for (char[] row : board) {
            points = 0;
            for (char cell : row) {
                if (cell == player)
                    points += 1;
            }
            if (points == REQUIRED)
                return true;
        }

        // check columns
        for (int col = 0; col < REQUIRED; col++) {
            points = 0;
            for (int row = 0; row < REQUIRED; row++) {
                if (board[row][col] == player)
                    points += 1;
            }
            if (points == REQUIRED)
                return true;
        }

        // check diagonals
        points = 0;
        for (int i = 0; i < REQUIRED; i++) {
            if (board[i][i] == player)
                points += 1;
        }
        if (points == REQUIRED)
            return true;

        points = 0;
        for (int i = REQUIRED - 1; i >= 0; i--) {
            if (board[i][i] == player)
                points += 1;
        }

        return points == REQUIRED;
    }

    public static int placeMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int SIZE = board.length;
        int row = 0;
        int col = 0;

        System.out.println("Enter a row (0, 1, 2) for player " + player);
        row = scanner.nextInt();

        if (row < 0 || row > SIZE) {
            System.out.println("INVALID MOVE!");
            return 0;
        }

        System.out.println("Enter a col (0, 1, 2) for player " + player);
        col = scanner.nextInt();

        if (col < 0 || col > SIZE) {
            System.out.println("INVALID MOVE!");
            return 0;
        }

        if (board[row][col] == ' ') {
            board[row][col] = player;
            return 1;
        }

        System.out.println("INVALID MOVE!");
        return 0;
    }

    public static void playGame() {
        int SIZE = 3;
        char[][] board = new char[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = ' ';
            }
        }

        int fullCells = 0;
        char player = 'X';
        while (fullCells < SIZE * SIZE) {
            int validMove = placeMove(board, player);
            if (validMove > 0) {
                fullCells += 1;
                if (checkWin(board, player)) {
                    System.out.println("Winner: " + player);
                    printBoard(board);
                    return;
                }
                if (player == 'X')
                    player = 'O';
                else
                    player = 'X';
            }
            printBoard(board);
        }
    }

    public static void taskNine() {
        playGame();
    }

    public static void printMatrix(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void taskTen() {
        int SIZE = 5;
        int[][] matrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = (int) (Math.round(Math.random()));
            }
        }

        printMatrix(matrix);
        int maxRowSum = 0, maxColSum = 0;
        int maxRowIndex = 0, maxColIndex = 0;

        for (int i = 0; i < SIZE; i++) {
            int rowSum = 0;
            for (int j = 0; j < SIZE; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum >= maxRowSum) {
                maxRowSum = rowSum;
                maxRowIndex = i;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int colSum = 0;
            for (int j = 0; j < SIZE; j++) {
                colSum += matrix[j][i];
            }
            if (colSum >= maxColSum) {
                maxColSum = colSum;
                maxColIndex = i;
            }
        }

        System.out.println("The largest row index: " + maxRowIndex);
        System.out.println("The largest col index: " + maxColIndex);
    }

    public static void printAll() {
        ChapterEight.taskOne();
        ChapterEight.taskTwo();
        ChapterEight.gradeExam();
        ChapterEight.taskFour();
        ChapterEight.taskFive();
        ChapterEight.taskSix();
        ChapterEight.taskSeven();
        ChapterEight.taskEight();
        ChapterEight.taskNine();
        ChapterEight.taskTen();
    }

}
