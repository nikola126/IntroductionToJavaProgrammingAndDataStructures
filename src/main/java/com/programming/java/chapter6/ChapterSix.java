package com.programming.java.chapter6;

public class ChapterSix {
    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    public static int sumDigits(long n) {
        long sum = 0;

        if (n < 10)
            return (int) n;

        while (n > 9) {
            long digit = n % 10;
            sum += digit;
            n /= 10;
        }

        sum += n;
        return (int) sum;
    }

    public static int reverse(int number) {
        int sum = 0;

        while (number > 0) {
            int remainder = number % 10;
            sum = (sum * 10) + remainder;
            number /= 10;
        }

        return sum;
    }

    public static boolean isPalindrome(int number) {
        return reverse(number) == number;
    }

    public static void displayReversed(int number) {
        System.out.println(reverse(number));
    }

    public static void displaySortedNumbers(double num1, double num2, double num3) {
        if (num1 >= num2 && num2 >= num3) {
            System.out.printf("%f\t%f\t%f\n", num3, num2, num1);
        } else if (num1 >= num3 && num3 >= num2) {
            System.out.printf("%f\t%f\t%f\n", num2, num3, num1);
        } else if (num2 >= num1 && num1 >= num3) {
            System.out.printf("%f\t%f\t%f\n", num3, num1, num2);
        } else if (num2 >= num3 && num3 >= num1) {
            System.out.printf("%f\t%f\t%f\n", num1, num3, num2);
        } else if (num3 >= num1 && num1 >= num2) {
            System.out.printf("%f\t%f\t%f\n", num2, num1, num3);
        } else if (num3 >= num2 && num2 >= num1) {
            System.out.printf("%f\t%f\t%f\n", num1, num2, num3);
        }
    }

    public static void displayPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                System.out.print("  ");
            for (int j = i; j >= 0; j--)
                System.out.printf("%d ", j + 1);
            System.out.println();
        }
    }
}
