package com.programming.java.chapter12;

import com.programming.java.chapter11.GeometricObject;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() throws IllegalTriangleException {
        if (side1 + side2 <= side3)
            throw new IllegalTriangleException("Invalid sides!");
        if (side1 + side3 <= side2)
            throw new IllegalTriangleException("Invalid sides!");
        if (side2 + side3 <= side1)
            throw new IllegalTriangleException("Invalid sides!");

        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
    }

    @Override
    public String toString() {
        return super.toString() + "Triangle: side1 = " + side1 + " side2 = " + side2 +
                " side3 = " + side3;
    }
}
