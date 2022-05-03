package com.programming.java.test;

public class TestEquality {

    public static void task() {
        Object o1 = new Object();
        Object o2 = o1;
        Object o3 = new Object();

        System.out.println("o1 == o2 ? " + (o1 == o2));
        System.out.println("o1 .equals o2 ? " + (o1.equals(o2)));
        System.out.println("o1 == o3 ? " + (o1 == o3));
        System.out.println("o1 .equals o3 ? " + (o1.equals(o3)));
    }
}
