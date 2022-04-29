package com.programming.java.chapter9;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        if (getDiscriminant() < 0)
            return 0;
        else
            return (-b + getDiscriminant()) / (2 * a);
    }

    public double getRoot2() {
        if (getDiscriminant() < 0)
            return 0;
        else
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
