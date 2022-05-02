package com.programming.java.chapter11;

import com.programming.java.chapter10.Circle2D;
import com.programming.java.chapter10.MyDate;
import com.programming.java.chapter10.MyPoint;
import com.programming.java.chapter9.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ChapterEleven {
    public static void taskOne() {
        Triangle triangle = new Triangle(1, 2, 3);
        triangle.setColor("red");
        triangle.setFilled(true);

        System.out.println("Triangle: " + triangle);
    }

    public static void taskTwo() {
        Person person = new Person();
        person.setName("Person");

        Student student = new Student("Freshman");
        student.setName("Student");

        Employee employee = new Employee();
        employee.setName("Employee");

        Faculty faculty = new Faculty();
        faculty.setName("Faculty");

        Staff staff = new Staff();
        staff.setName("Staff");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }

    public static void taskThree() {
        Account account = new Account(0, 1000);
        CheckingAccount checkingAccount = new CheckingAccount(1, 1000, 50);
        SavingsAccount savingsAccount = new SavingsAccount(2, 1000);

        System.out.println(account);
        System.out.println(checkingAccount);
        System.out.println(savingsAccount);
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0)
            return null;

        int max = Integer.MIN_VALUE;
        for (int i : list)
            max = Math.max(max, i);

        return max;
    }

    public static void taskFour() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter number: (0 to stop)");
        int input = -1;
        while (input != 0) {
            System.out.print(">> ");
            input = scanner.nextInt();
            list.add(input);
        }

        System.out.println("Max: " + max(list));
    }

    public static void taskSix() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Person("John", "Newfoundland", "000", "john@mail.com"));
        list.add(new MyDate());
        list.add("Just a string");
        list.add(new Circle2D(0, 0, 1));

        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
    }

    public static void taskSeven() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(15);
        list.add(16);
        list.add(23);
        list.add(42);

        System.out.println("Before shuffle: " + list);
        shuffle(list);
        System.out.println("After shuffle: " + list);
    }

    public static void taskEight() {
        AccountWithHistory account = new AccountWithHistory(1122, "George", 1000.0);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);

        System.out.println(account);
    }

    public static void taskNine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int SIZE = scanner.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < SIZE; j++) {
                matrix.get(i).add((int) Math.round(Math.random()));
            }
        }

        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }

        int maxRow = 0, maxCol = 0, maxOnes = 0;

        for (int i = 0; i < SIZE; i++) {
            int current = 0;
            for (int j = 0; j < SIZE; j++) {
                current += matrix.get(i).get(j);
            }
            if (current >= maxOnes) {
                maxRow = i;
                maxOnes = current;
            }
        }

        maxOnes = 0;

        for (int j = 0; j < SIZE; j++) {
            int current = 0;
            for (int i = 0; i < SIZE; i++) {
                current += matrix.get(i).get(j);
                if (current >= maxOnes) {
                    maxCol = j;
                    maxOnes = current;
                }
            }
        }

        System.out.println("Max row index: " + maxRow);
        System.out.println("Max col index: " + maxCol);
    }

    public static void taskTen() {
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter string: ");
            String input = scanner.nextLine();
            myStack.push(input);
        }

        System.out.println("Popping: ");
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

    public static void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    public static void taskEleven() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(42);
        list.add(15);
        list.add(16);
        list.add(23);

        System.out.println("Before sort: " + list);
        sort(list);
        System.out.println("After sort: " + list);
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for (Double value : list)
            sum += value;
        return sum;
    }

    public static void taskTwelve() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(4.0);
        list.add(8.0);
        list.add(42.0);
        list.add(15.0);
        list.add(16.0);
        list.add(23.0);

        System.out.println("List: " + list);
        System.out.println("Sum: " + sum(list));
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> uniques = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if (!uniques.contains(value))
                uniques.add(value);
            else
                list.remove(i);
        }

        if (uniques.contains(list.get(list.size() - 1)))
            list.remove(list.size() - 1);
    }

    public static void taskThirteen() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(8);
        list.add(15);
        list.add(16);
        list.add(8);
        list.add(15);

        System.out.println("List: " + list);
        removeDuplicate(list);
        System.out.println("Without duplicates: " + list);
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> combined = new ArrayList<>();

        combined.addAll(list1);
        combined.addAll(list2);

        return combined;
    }

    public static void taskFourteen() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(8);
        list1.add(15);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(16);
        list2.add(23);
        list2.add(42);

        ArrayList<Integer> combined = union(list1, list2);
        System.out.println(combined);
    }

    public static double areaConvexPolygon(ArrayList<MyPoint> points) {
        int N = points.size();

        double leftSide = 0, rightSide = 0, area = 0;

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                leftSide += points.get(i).getX() * points.get(0).getY();
                rightSide += points.get(i).getY() * points.get(0).getX();
            } else {
                leftSide += points.get(i).getX() * points.get(i + 1).getY();
                rightSide += points.get(i).getY() * points.get(i + 1).getX();
            }
        }

        return Math.abs((1.0 / 2.0) * (leftSide - rightSide));
    }

    public static void taskFifteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of points: ");
        int n = scanner.nextInt();

        ArrayList<MyPoint> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.printf("Point [%d/%d]\n", i + 1, n);
            System.out.print("Enter x: ");
            double x = scanner.nextDouble();
            System.out.print("Enter y: ");
            double y = scanner.nextDouble();
            points.add(new MyPoint(x, y));
        }

        System.out.println("The total area is: " + areaConvexPolygon(points));
    }

    public static void taskSixteen() {
        final int NUMBER_OF_QUESTIONS = 5; // Number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();
        String output = " "; // output string is initially empty
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> previousAnswers = new ArrayList<>();

        // 1. Generate two random single-digit integers
        int number1 = (int) (1 + Math.random() * 14);
        int number2 = (int) (1 + Math.random() * 14);

        while (count < NUMBER_OF_QUESTIONS) {


            // 3. Prompt the student to answer "What is number1 + number2?"
            System.out.print(
                    "What is " + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            // 4. Grade the answer and display the result
            if (number1 + number2 == answer) {
                System.out.println("You are correct!");
                previousAnswers = new ArrayList<>();
                correctCount++; // Increase the correct answer count
                // Increase the question count
                count++;
                output += "\n" + number1 + "+" + number2 + "=" + answer + ((number1 + number2 == answer) ? " correct" : " wrong");
                // Generate new question
                number1 = (int) (1 + Math.random() * 14);
                number2 = (int) (1 + Math.random() * 14);
            } else {
                if (previousAnswers.contains(answer)) {
                    System.out.println("You already entered " + answer);
                } else {
                    previousAnswers.add(answer);
                    System.out.println("Your answer is wrong. Try again!");
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount +
                "\nTest time is " + testTime / 1000 + " seconds\n" + output);
    }

    public static ArrayList<Integer> getFactors(int m) {
        ArrayList<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (m != 1) {
            if (m % divisor == 0) {
                factors.add(divisor);
                m /= divisor;
            } else {
                divisor += 1;
            }
        }

        return factors;
    }

    public static ArrayList<Integer> getOddFactors(ArrayList<Integer> factors) {
        ArrayList<Integer> odds = new ArrayList<>();

        for (int factor : factors) {
            int count = 0;
            for (int f : factors) {
                if (f == factor)
                    count += 1;
            }
            if (count % 2 != 0)
                odds.add(factor);
        }

        removeDuplicate(odds);
        return odds;
    }

    public static void taskSeventeen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer M: ");
        int M = scanner.nextInt();

        ArrayList<Integer> factors = getFactors(M);
        ArrayList<Integer> oddFactors = getOddFactors(factors);

        int N = 1;
        for (int factor : oddFactors)
            N *= factor;

        System.out.println("The smallest number N for M*N to be a perfect square is " + N + ", M*N is " + (M * N));
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> asList = new ArrayList<>();
        for (char c : s.toCharArray())
            asList.add(c);

        return asList;
    }

    public static void taskEighteen() {
        System.out.println(toCharacterArray("abc"));
    }

    public static void taskNineteen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of objects: ");
        int N = scanner.nextInt();

        ArrayList<Integer> weights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            System.out.printf("Enter weight of object [%d/%d]: ", i + 1, N);
            weights.add(scanner.nextInt());
        }

        ArrayList<Integer> containers = new ArrayList<>();
        containers.add(10);
        ArrayList<ArrayList<Integer>> elements = new ArrayList<>();
        elements.add(new ArrayList<>());
        int containersCount = 0;

        for (int weight : weights) {
            int availableSpace = containers.get(containersCount);
            if (availableSpace < weight) {
                // not enough space
                containers.add(10 - weight);
                elements.add(new ArrayList<>());
                containersCount += 1;
                elements.get(containersCount).add(weight);
            } else {
                containers.set(containersCount, availableSpace - weight);
                elements.get(containersCount).add(weight);
            }
        }

        for (int i = 0; i < containersCount; i++) {
            System.out.println("Container " + (i + 1) + " contains objects with weight: " + elements.get(i));
        }
    }

    public static void printAll() {
        ChapterEleven.taskOne();
        ChapterEleven.taskTwo();
        ChapterEleven.taskThree();
        ChapterEleven.taskFour();
        ChapterEleven.taskSix();
        ChapterEleven.taskSeven();
        ChapterEleven.taskEight();
        ChapterEleven.taskNine();
        ChapterEleven.taskTen();
        ChapterEleven.taskEleven();
        ChapterEleven.taskTwelve();
        ChapterEleven.taskThirteen();
        ChapterEleven.taskFourteen();
        ChapterEleven.taskFifteen();
        ChapterEleven.taskSixteen();
        ChapterEleven.taskSeventeen();
        ChapterEleven.taskEighteen();
        ChapterEleven.taskNineteen();
    }

}
