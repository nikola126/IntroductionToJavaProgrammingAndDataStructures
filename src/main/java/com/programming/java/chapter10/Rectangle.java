package com.programming.java.chapter10;

public class Rectangle {
    double x;
    double y;
    double width;
    double height;

    public Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        double botLeftX = this.x - width;
        double botLeftY = this.y - height;
        double topRightX = this.x + width;
        double topRightY = this.y + height;

        return ((x > botLeftX && x < topRightX) && (y > botLeftY && y < topRightY));
    }

    public boolean contains(Rectangle rectangle) {
        double botLeftX = this.x - width;
        double botLeftY = this.y - height;
        double topRightX = this.x + width;
        double topRightY = this.y + height;

        return ((rectangle.getX() > botLeftX && rectangle.getX() < topRightX)
                && (rectangle.getY() > botLeftY && rectangle.getY() < topRightY));
    }

    public boolean overlaps(Rectangle rectangle) {
        double botLeftX = rectangle.getX() - rectangle.getWidth();
        double botLeftY = rectangle.getY() - rectangle.getHeight();

        double botRightX = rectangle.getX() + rectangle.getWidth();
        double botRightY = rectangle.getY() + rectangle.getHeight();

        double topLeftX = rectangle.getX() - rectangle.getWidth();
        double topLeftY = rectangle.getY() + rectangle.getHeight();

        double topRightX = rectangle.getX() + rectangle.getWidth();
        double topRightY = rectangle.getY() + rectangle.getHeight();

        if (contains(botLeftX, botLeftY))
            return true;
        if (contains(botRightX, botRightY))
            return true;
        if (contains(topLeftX, topLeftY))
            return true;
        if (contains(topRightX, topRightY))
            return true;

        return false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
