package com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.height = 1;
        this.width = 1;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }
}
