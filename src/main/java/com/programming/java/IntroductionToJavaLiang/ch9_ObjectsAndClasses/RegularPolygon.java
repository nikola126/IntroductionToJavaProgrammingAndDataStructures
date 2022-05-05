package com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses;

public class RegularPolygon {
    private int sides;
    private double side;
    private double x;
    private double y;

    public RegularPolygon() {
        this.sides = 3;
        this.side = 1;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int sides, double side) {
        this.sides = sides;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int sides, double side, double x, double y) {
        this.sides = sides;
        this.side = side;
        this.x = x;
        this.y = x;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return sides * side;
    }

    public double getArea() {
        return (sides * Math.pow(side, 2)) / (4 * Math.tan(Math.toRadians(Math.PI) / sides));
    }
}
