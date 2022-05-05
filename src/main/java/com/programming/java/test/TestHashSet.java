package com.programming.java.test;

import com.programming.java.test.classes.Point;

import java.util.HashSet;

public class TestHashSet {
    public static void task() {
        HashSet<Point> set = new HashSet<>();
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(3, 4);
        Point point4 = new Point(1, 2);
        Point point5 = new Point(3, 4);

        set.add(point1);
        set.add(point2);
        set.add(point3);
        set.add(point4);
        set.add(point5);

        System.out.println("Size of set: " + set.size()); // should be 3

        Point point6 = new Point(5, 6);
        Point point7 = point6;

        set.add(point6);
        set.add(point7);

        System.out.println("Size of set: " + set.size()); // should be 4
    }
}
