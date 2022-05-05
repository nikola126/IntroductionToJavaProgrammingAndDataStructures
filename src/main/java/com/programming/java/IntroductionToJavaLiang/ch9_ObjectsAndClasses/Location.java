package com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses;

public class Location {
    public int row;
    public int column;
    public double maxValue;

    public Location(double[][] a) {
        row = 0;
        column = 0;
        maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] >= maxValue) {
                    maxValue = a[i][j];
                    row = i;
                    column = j;
                }
            }
        }
    }
}
