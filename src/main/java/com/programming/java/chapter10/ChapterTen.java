package com.programming.java.chapter10;

import com.programming.java.chapter6.ChapterSix;
import com.programming.java.chapter9.Account;

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
}
