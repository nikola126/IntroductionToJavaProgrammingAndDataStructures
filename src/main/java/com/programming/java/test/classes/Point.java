package com.programming.java.test.classes;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.x;
        result = prime * result + this.y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Point point;

        try {
            point = (Point) obj;
        } catch (ClassCastException e) {
            return false;
        }

        return this.x == point.getX() && this.y == point.getY();
    }
}
