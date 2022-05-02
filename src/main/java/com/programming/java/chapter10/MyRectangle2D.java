package com.programming.java.chapter10;

public class MyRectangle2D {
    double x;
    double y;
    double width;
    double height;

    public MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
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

    public boolean contains(MyRectangle2D myRectangle2D) {
        double botLeftX = this.x - width;
        double botLeftY = this.y - height;
        double topRightX = this.x + width;
        double topRightY = this.y + height;

        return ((myRectangle2D.getX() > botLeftX && myRectangle2D.getX() < topRightX)
                && (myRectangle2D.getY() > botLeftY && myRectangle2D.getY() < topRightY));
    }

    public boolean overlaps(MyRectangle2D myRectangle2D) {
        double botLeftX = myRectangle2D.getX() - myRectangle2D.getWidth();
        double botLeftY = myRectangle2D.getY() - myRectangle2D.getHeight();

        double botRightX = myRectangle2D.getX() + myRectangle2D.getWidth();
        double botRightY = myRectangle2D.getY() + myRectangle2D.getHeight();

        double topLeftX = myRectangle2D.getX() - myRectangle2D.getWidth();
        double topLeftY = myRectangle2D.getY() + myRectangle2D.getHeight();

        double topRightX = myRectangle2D.getX() + myRectangle2D.getWidth();
        double topRightY = myRectangle2D.getY() + myRectangle2D.getHeight();

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

    public static MyRectangle2D getRectangle(double[][] points) {
        double maxWidth = Integer.MIN_VALUE, minWidth = Integer.MAX_VALUE;
        double maxHeight = Integer.MIN_VALUE, minHeight = Integer.MAX_VALUE;

        int NUMBER_OF_POINTS = points.length;
        double avgWidth = 0, avgHeight = 0;

        for (double[] point : points) {
            maxWidth = Math.max(maxWidth, point[0]);
            minWidth = Math.min(minWidth, point[0]);
            maxHeight = Math.max(maxHeight, point[1]);
            minHeight = Math.min(minHeight, point[1]);

            avgWidth += point[0];
            avgHeight += point[1];
        }

        avgWidth = avgWidth / NUMBER_OF_POINTS;
        avgHeight = avgHeight / NUMBER_OF_POINTS;

        System.out.println("Max width: " + maxWidth);
        System.out.println("Min width: " + minWidth);
        System.out.println("Max height: " + maxHeight);
        System.out.println("Min height: " + minHeight);

        return new MyRectangle2D(avgWidth, avgHeight, maxWidth - minWidth, maxHeight - minHeight);
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
