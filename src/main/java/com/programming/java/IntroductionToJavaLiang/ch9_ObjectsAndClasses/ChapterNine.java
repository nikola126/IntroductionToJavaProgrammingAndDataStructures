package com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses;

import java.util.*;

public class ChapterNine {
    public static void taskOne() {
        Rectangle rectangle1 = new Rectangle(40, 4);
        Rectangle rectangle2 = new Rectangle(35.9, 3.5);

        System.out.println("Rectangle 1");
        System.out.printf("Width: %.2f\tHeight: %.2f\n", rectangle1.getWidth(), rectangle1.getHeight());
        System.out.printf("Area: %.2f\tPerimeter: %.2f\n", rectangle1.getArea(), rectangle1.getPerimeter());

        System.out.println("Rectangle 2");
        System.out.printf("Width: %.2f\tHeight: %.2f\n", rectangle2.getWidth(), rectangle2.getHeight());
        System.out.printf("Area: %.2f\tPerimeter: %.2f\n", rectangle2.getArea(), rectangle2.getPerimeter());
    }

    public static void taskTwo() {
        Stock oracle = new Stock("ORCL", "Oracle Corporation");
        oracle.setPreviousClosingPrice(34.5);
        oracle.setCurrentPrice(34.35);
        System.out.println("Price-change % of ORCL: " + oracle.getChangePercent());
    }

    public static void taskThree() {
        Date date = new Date();
        for (long i = 10000; i < 1000000000; i *= 10) {
            date.setTime(i);
            System.out.println("Elapsed: " + i + "\t Date: " + date.toString());
        }
    }

    public static void taskFour() {
        Random random = new Random();
        random.setSeed(1000);

        for (int i = 0; i < 50; i++) {
            System.out.printf("%d ", random.nextInt(100));
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
    }

    public static void taskFive() {
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("Currently: ");
        System.out.println(calendar.get(GregorianCalendar.YEAR) + " "
                + calendar.get(GregorianCalendar.MONTH) + " "
                + calendar.get(GregorianCalendar.DAY_OF_MONTH));

        System.out.println("Time elapsed: ");
        calendar.setTimeInMillis(1234567898765L);

        System.out.println(calendar.get(GregorianCalendar.YEAR) + " "
                + calendar.get(GregorianCalendar.MONTH) + " "
                + calendar.get(GregorianCalendar.DAY_OF_MONTH));
    }

    public static void taskSix() {
        int size = 100000;
        int[] array = new int[size];
        Random random = new Random(200);

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }

        Stopwatch stopwatch = new Stopwatch();
        Arrays.sort(array);
        stopwatch.stop();

        System.out.println("Time required to sort " + size + " numbers:");
        System.out.println(stopwatch.getElapsedTime() + " ms");
    }

    public static void taskSeven() {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);

        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Monthly interest: " + account.getMonthlyInterest());
        System.out.println("Account creation date: " + account.getDateCreated().toString());
    }

    public static void taskEight() {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.println(fan1);
        System.out.println(fan2);
    }

    public static void taskNine() {
        RegularPolygon[] polygons = new RegularPolygon[3];
        polygons[0] = new RegularPolygon();
        polygons[1] = new RegularPolygon(6, 4);
        polygons[2] = new RegularPolygon(10, 4, 5.6, 7.8);

        for (RegularPolygon polygon : polygons) {
            System.out.println("Perimeter: " + polygon.getPerimeter());
            System.out.println("Area: " + polygon.getArea());
        }
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        double input;
        QuadraticEquation quadraticEquation = new QuadraticEquation();

        System.out.print("Enter A: ");
        input = scanner.nextDouble();
        quadraticEquation.setA(input);

        System.out.print("Enter B: ");
        input = scanner.nextDouble();
        quadraticEquation.setB(input);

        System.out.print("Enter C: ");
        input = scanner.nextDouble();
        quadraticEquation.setC(input);

        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("Root 1: " + quadraticEquation.getRoot1());
            System.out.println("Root 2: " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Root 1: " + quadraticEquation.getRoot1());
        } else {
            System.out.println("This equation has no real roots!");
        }
    }

    public static void taskEleven() {
        Scanner scanner = new Scanner(System.in);
        double input;
        double[] paramaters = new double[6];

        System.out.print("Enter A: ");
        input = scanner.nextDouble();
        paramaters[0] = input;

        System.out.print("Enter B: ");
        input = scanner.nextDouble();
        paramaters[1] = input;

        System.out.print("Enter C: ");
        input = scanner.nextDouble();
        paramaters[2] = input;

        System.out.print("Enter D: ");
        input = scanner.nextDouble();
        paramaters[3] = input;

        System.out.print("Enter E: ");
        input = scanner.nextDouble();
        paramaters[4] = input;

        System.out.print("Enter F: ");
        input = scanner.nextDouble();
        paramaters[5] = input;

        LinearEquation linearEquation = new LinearEquation(
                paramaters[0], paramaters[1], paramaters[2],
                paramaters[3], paramaters[4], paramaters[5]);

        if (linearEquation.isSolvable()) {
            System.out.println("X: " + linearEquation.getX());
            System.out.println("Y: " + linearEquation.getY());
        } else {
            System.out.println("This equation has no solution!");
        }
    }

    public static void taskTwelve() {
        Scanner scanner = new Scanner(System.in);
        double x1, x2, x3, x4;
        double y1, y2, y3, y4;

        System.out.print("Enter x1: ");
        x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        y2 = scanner.nextDouble();
        System.out.print("Enter x3: ");
        x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        y3 = scanner.nextDouble();
        System.out.print("Enter x4: ");
        x4 = scanner.nextDouble();
        System.out.print("Enter y4: ");
        y4 = scanner.nextDouble();

        double a = y1 - y2;
        double b = -(x1 - x2);
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double c = y3 - y4;
        double d = -(x3 - x4);
        double f = (y3 - y4) * x3 - (x3 - x4) * y3;

        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
        if (linearEquation.isSolvable()) {
            System.out.printf("Intersection at [%.2f,%.2f]\n", linearEquation.getX(), linearEquation.getY());
        } else {
            System.out.println("This equation has no solution!");
        }
    }

    public static void taskThirteen() {
        Scanner scanner = new Scanner(System.in);
        int rows = 0;
        int cols = 0;

        System.out.print("Enter number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter number of cols: ");
        cols = scanner.nextInt();

        double array[][] = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Array[%d][%d] = ", i, j);
                array[i][j] = scanner.nextDouble();
            }
        }

        Location location = new Location(array);
        System.out.printf("The largest element is %.2f at (%d, %d)\n", location.maxValue, location.row, location.column);
    }

    public static void printAll() {
        ChapterNine.taskOne();
        ChapterNine.taskTwo();
        ChapterNine.taskThree();
        ChapterNine.taskFour();
        ChapterNine.taskFive();
        ChapterNine.taskSix();
        ChapterNine.taskSeven();
        ChapterNine.taskEight();
        ChapterNine.taskNine();
        ChapterNine.taskTen();
        ChapterNine.taskEleven();
        ChapterNine.taskTwelve();
        ChapterNine.taskThirteen();
    }
}
