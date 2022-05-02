package com.programming.java.chapter10;

public class Circle2D {
    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    public double getArea() {
        return (Math.PI * radius * radius);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getDistanceBetweenPoints(double x1, double x2, double y1, double y2) {
        return (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow((y1 - y2), 2)));
    }

    public boolean contains(double x, double y) {
        return (getDistanceBetweenPoints(this.x, x, this.y, y) <= this.radius);
    }

    public boolean contains(Circle2D circle2D) {
        return (getDistanceBetweenPoints(this.x, circle2D.getX(), this.y, circle2D.getY()) <= this.radius);
    }

    public boolean overlaps(Circle2D circle2D) {
        return (getDistanceBetweenPoints(this.x, circle2D.getX(), this.y, circle2D.getY())
                <= (this.radius + circle2D.getRadius()));
    }

    @Override
    public String toString() {
        return "Circle2D{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
