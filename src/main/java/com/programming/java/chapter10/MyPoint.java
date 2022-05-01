package com.programming.java.chapter10;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }

    public double getDistance(MyPoint myPoint) {
        return Math.sqrt(Math.pow((this.x - myPoint.getX()), 2) + Math.pow((this.y - myPoint.getY()), 2));
    }

    public static double getDistance(MyPoint point1, MyPoint point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point2.getX() - point2.getY()), 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
