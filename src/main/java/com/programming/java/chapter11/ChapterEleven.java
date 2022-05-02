package com.programming.java.chapter11;

import com.programming.java.chapter10.Circle2D;
import com.programming.java.chapter10.MyDate;
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
}
