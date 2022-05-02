package com.programming.java.chapter10;

import com.programming.java.chapter6.ChapterSix;
import com.programming.java.chapter9.Account;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChapterTen {
    public static void taskOne() {
        Time time1 = new Time();
        Time time2 = new Time(System.currentTimeMillis());
        Time time3 = new Time(16, 18, 0);

        System.out.printf("Currently: %2d:%2d:%2d\n", time1.getHour(), time1.getMinute(), time1.getSecond());
        System.out.printf("Currently: %2d:%2d:%2d\n", time2.getHour(), time2.getMinute(), time2.getSecond());
        System.out.printf("Currently: %2d:%2d:%02d\n", time3.getHour(), time3.getMinute(), time3.getSecond());
    }

    public static void taskThree() {
        MyInteger myInteger = new MyInteger(17);
        System.out.println(myInteger.getValue());
        System.out.println("Even: " + myInteger.isEven());
        System.out.println("Odd: " + myInteger.isOdd());
        System.out.println("Prime: " + myInteger.isPrime());
        System.out.println();
        char[] asArray = new char[]{'1', '8'};
        String asString = "19";
        System.out.println(MyInteger.parseInt(asArray));
        System.out.println(MyInteger.parseInt(asString));
    }

    public static void taskFour() {
        MyPoint point1 = new MyPoint(0, 0);
        MyPoint point2 = new MyPoint(10, 30.5);

        System.out.println("Distance between points: " + MyPoint.getDistance(point1, point2));
    }

    public static void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int divisor = 2;
        StackOfIntegers stack = new StackOfIntegers();

        while (number > 1) {
            if (number % divisor == 0) {
                stack.push(divisor);
                number /= divisor;
            } else {
                divisor += 1;
            }
        }

        System.out.print("Factors: ");
        while (!stack.empty()) {
            System.out.printf("%d ", stack.pop());
        }
    }

    public static void taskSix() {
        StackOfIntegers stack = new StackOfIntegers();

        for (int i = 2; i <= 120; i++) {
            if (ChapterSix.isPrime(i)) {
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            System.out.printf("%d ", stack.pop());
        }
    }

    public static void printMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public static void taskSeven() {
        int MAX_ACCOUNTS = 1;
        Account[] accounts = new Account[MAX_ACCOUNTS];
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            accounts[i] = new Account(i, 100.0);
        }

        Scanner scanner = new Scanner(System.in);
        int id, choice;
        double amount;

        while (true) {
            System.out.print("Enter an id: ");
            id = scanner.nextInt();
            if (0 <= id && id <= MAX_ACCOUNTS) {
                printMainMenu();
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println(accounts[id].getBalance());
                        break;
                    }
                    case 2: {
                        System.out.print("Enter amount: ");
                        amount = scanner.nextDouble();
                        accounts[id].withdraw(amount);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter amount: ");
                        amount = scanner.nextDouble();
                        accounts[id].deposit(amount);
                        break;
                    }
                    case 4: {
                        continue;
                    }
                }
            } else if (id == -1) {
                return;
            } else {
                continue;
            }
        }
    }

    public static void taskTen() {
        MyQueue myQueue = new MyQueue();

        for (int i = 1; i <= 20; i++) {
            myQueue.enqueue(i);
        }

        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d ", myQueue.dequeue());
        }
        System.out.println();
    }

    public static void taskEleven() {
        Circle2D circle1 = new Circle2D(2, 2, 5.5);
        System.out.println("Circle 1 Perimeter: " + circle1.getPerimeter());
        System.out.println("Circle 1 Area: " + circle1.getArea());
        System.out.println(circle1.contains(3, 3));
        System.out.println(circle1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(circle1.overlaps(new Circle2D(3, 5, 2.3)));
    }

    public static void taskThirteen() {
        MyRectangle2D rectangle = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println(rectangle.contains(3, 3));
        System.out.println(rectangle.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(rectangle.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }

    public static void taskFourteen() {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(561555550000L);
        System.out.println("Date 1: ");
        System.out.println(date1.getDay() + " " + date1.getMonth() + " " + date1.getYear());
        System.out.println("Date 2: ");
        System.out.println(date2.getDay() + " " + date2.getMonth() + " " + date2.getYear());
    }

    public static void taskFifteen() {
        double[][] points = new double[5][2];
        points[0] = new double[]{1.0, 2.5};
        points[1] = new double[]{3, 4};
        points[2] = new double[]{5, 6};
        points[3] = new double[]{7, 8};
        points[4] = new double[]{9, 10};

        MyRectangle2D bounding = MyRectangle2D.getRectangle(points);
        System.out.println("Bounding rectangle Center: " + bounding.getX() + " " + bounding.getY());
        System.out.println("Bounding rectangle Width: " + bounding.getWidth());
        System.out.println("Bounding rectangle Height: " + bounding.getHeight());
    }

    public static void taskSixteen() {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 0; i < 50; i++)
            sb.append("0");

        BigInteger bigInteger = new BigInteger(sb.toString());
        int numbers = 0;
        while (numbers < 10) {
            if (bigInteger.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) ||
                    bigInteger.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
                System.out.println(bigInteger);
                numbers += 1;
            }
            bigInteger = bigInteger.add(BigInteger.ONE);
        }
    }

    public static void taskSeventeen() {
        BigInteger bigInteger = new BigInteger(String.valueOf(Long.MAX_VALUE)).add(BigInteger.ONE);
        int numbers = 0;
        while (numbers < 10) {
            if (bigInteger.sqrtAndRemainder()[1].equals(BigInteger.ZERO)) {
                System.out.println(bigInteger);
                numbers += 1;
            }
            bigInteger = bigInteger.add(BigInteger.ONE);
        }
    }

    public static boolean isPrime(BigInteger value) {
        return value.isProbablePrime(1);
    }

    public static void taskEighteen() {
//        BigInteger bigInteger = BigInteger.TWO;
        BigInteger bigInteger = new BigInteger(String.valueOf(Long.MAX_VALUE)).add(BigInteger.ONE);
        int numbers = 0;
        while (numbers < 5) {
            if (isPrime(bigInteger)) {
                System.out.println("Prime: " + bigInteger);
                numbers += 1;
            }
            bigInteger = bigInteger.add(BigInteger.ONE);
        }
    }

    public static void taskNineteen() {
        BigInteger bigInteger;
        for (int p = 2; p <= 100; p++) {
            bigInteger = BigInteger.TWO.pow(p).subtract(BigInteger.ONE);
            if (isPrime(bigInteger))
                System.out.println(p + "\t" + bigInteger);
        }
    }

    public static BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ONE))
            return BigDecimal.ONE;

        return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
    }

    public static void taskTwenty() {
        BigDecimal exponent = new BigDecimal("1");
        for (int i = 100; i <= 1000; i += 100) {
            exponent = BigDecimal.ONE;
            for (int j = 1; j <= i; j++) {
                exponent = exponent.add(BigDecimal.ONE.divide(factorial(BigDecimal.valueOf(j)), 25, RoundingMode.HALF_UP));
            }
            System.out.println("E approximated: " + exponent);
        }
    }

    public static void taskTwentyOne() {

        BigInteger bigInteger = new BigInteger(String.valueOf(Long.MAX_VALUE)).add(BigInteger.ONE);
        int numbers = 0;
        while (numbers < 10) {
            if (bigInteger.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) ||
                    bigInteger.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO)) {
                System.out.println(bigInteger);
                numbers += 1;
            }
            bigInteger = bigInteger.add(BigInteger.ONE);
        }
    }

    public static String[] split(String s, String regex) {
        List<String> split = new ArrayList<>();
        List<Character> regexTokens = new ArrayList<>();
        for (char c : regex.toCharArray())
            regexTokens.add(c);

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (regexTokens.contains(c)) {
                // append token
                split.add(sb.toString());
                sb = new StringBuilder();
                // append delimiter
                sb.append(c);
                split.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        if (sb.toString().length() > 0)
            split.add(sb.toString());
        return split.toArray(String[]::new);
    }

    public static void taskTwentyFive() {
        System.out.println(Arrays.toString(split("ab#12#453", "#")));
        System.out.println(Arrays.toString(split("a?b?gf#e", "[?#]")));
    }

    public static void printAll() {
        ChapterTen.taskOne();
        ChapterTen.taskThree();
        ChapterTen.taskFour();
        ChapterTen.taskFive();
        ChapterTen.taskSix();
        ChapterTen.taskSeven();
        ChapterTen.taskTen();
        ChapterTen.taskEleven();
        ChapterTen.taskThirteen();
        ChapterTen.taskFourteen();
        ChapterTen.taskFifteen();
        ChapterTen.taskSixteen();
        ChapterTen.taskSeventeen();
        ChapterTen.taskEighteen();
        ChapterTen.taskNineteen();
        ChapterTen.taskTwenty();
        ChapterTen.taskTwentyOne();
        ChapterTen.taskTwentyFive();
    }

}
