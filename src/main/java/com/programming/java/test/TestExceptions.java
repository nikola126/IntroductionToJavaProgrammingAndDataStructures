package com.programming.java.test;

import com.programming.java.test.classes.MyException;

public class TestExceptions {
    public static void task() {
        for (int i = 3; i >= 0; i--) {
            System.out.println("Divide by " + i);
            try {
                division(i);
            } catch (Exception e) {
                System.out.println("Exception caught in task()");
            } finally {
                System.out.println("Finally in task()");
            }
        }
    }

    public static void division(int n) throws MyException {
        try {
            int result = 10 / n;
        } catch (Exception e) {
            throw new MyException();
        } finally {
            System.out.println("Finally in division()");
        }
    }
}
