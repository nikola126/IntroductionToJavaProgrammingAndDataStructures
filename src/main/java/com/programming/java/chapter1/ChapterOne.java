package com.programming.java.chapter1;

public class ChapterOne {
    public void taskOne() {
        System.out.println("Welcome to Java");
        System.out.println("Welcome to Computer Science");
        System.out.println("Programming is fun");
    }

    public void taskTwo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Welcome to Java");
        }
    }

    public void taskThree() {
        System.out.println("    J    A    V     V    A   ");
        System.out.println("    J   A A    V   V    A A  ");
        System.out.println("J   J  AAAAA    V V    AAAAA ");
        System.out.println(" J J  A     A    V    A     A");
    }

    public void taskFour() {
        System.out.println("a\t\ta^2\t\tA^3");
        for (int i = 1; i < 5; i++) {
            System.out.println(i + "\t\t" + Math.pow(i, 2) + "\t\t" + Math.pow(i, 3));
        }
    }

    public void taskFive() {
        double expression = (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5);
        System.out.println(expression);
    }

    public void taskSix() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public void taskSeven(int approx) {
        int pi = 4;
        int sum = 0;
        int denom = 1;
        int sign = 1;
        for (int i = 1; i <= approx; i++) {
            if (i == 1) {
                sum += 1;
            } else {
                denom = i + 2;
                sum += (1 / denom * sign);
            }
            sign = -sign;
        }
        pi *= sum;
        System.out.println(pi);
    }

    public void taskEight() {
        double radius = 5;
        double perimeter = 2 * radius * Math.PI;
        double area = radius * radius * Math.PI;

        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }

    public void taskNine() {
        double width = 4.5;
        double height = 7.9;
        double area = width * height;
        System.out.println("Area: " + area);
    }

    public void taskTen() {
        double avgSpeed = (14 / 1.6) / (45.5 / 60);
        System.out.println(avgSpeed + " mph");
    }

    public void taskEleven() {
        double initial = 312032486;
        for (int year = 0; year < 5; year++) {
            double endOfYearDelta = 0;
            for (int i = 0; i < 365 * 24 * 60 * 60; i++) {
                if (i % 7 == 0) {
                    endOfYearDelta += 1;
                }
                if (i % 13 == 0) {
                    endOfYearDelta -= 1;
                }
                if (i % 45 == 0) {
                    endOfYearDelta += 1;
                }
            }
            initial += endOfYearDelta;
        }
        System.out.println(initial);
    }

    public void taskTwelve() {
        double avgSpeed = (24 * 1.6) / ((60 + 40 + 35.0 / 60) / 60);
        System.out.println(avgSpeed + " km/h");
    }

    public void taskThirteen() {
        double a = 3.4;
        double b = 50.2;
        double e = 44.5;
        double c = 2.1;
        double d = 0.55;
        double f = 5.9;

        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c);

        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    public void printAll() {
        System.out.println(this.getClass().getName());
        taskOne();
        System.out.println();
        taskTwo();
        System.out.println();
        taskThree();
        System.out.println();
        taskFour();
        System.out.println();
        taskFive();
        System.out.println();
        taskSix();
        System.out.println();
        taskSeven(5);
        taskSeven(6);
        System.out.println();
        taskEight();
        System.out.println();
        taskNine();
        System.out.println();
        taskTen();
        System.out.println();
        taskEleven();
        System.out.println();
        taskTwelve();
        System.out.println();
        taskThirteen();
    }
}
