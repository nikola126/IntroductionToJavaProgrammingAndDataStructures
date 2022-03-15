package com.programming.java.chapter4;

import java.util.Scanner;

public class ChapterFour {
    public void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length from center to vertex: ");
        double r = scanner.nextDouble();

        double side = 2 * r * Math.sin(Math.PI / 5);
        double area = (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));

        System.out.printf("Area of pentagon is: %.2f\n", area);
    }

    public void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double radius = 6371.01;
        double distance = radius * Math.acos(Math.toRadians(Math.sin(x1) * Math.sin(x2) +
            Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)));

        System.out.println("Distance between two points is: " + distance + " km");
    }

    public void taskThree() {
        double charlotteX = 35.227;
        double charlotteY = -80.843;
        double savannahX = 32.083;
        double savannahY = -81.099;
        double orlandoX = 28.538;
        double orlandoY = -81.379;
        double atlantaX = 33.749;
        double atlantaY = -84.388;
        double radius = 6371.01;

        double distanceCS = radius * Math.acos(Math.toRadians(Math.sin(charlotteX) * Math.sin(savannahX) +
            Math.cos(charlotteX) * Math.cos(savannahX) * Math.cos(charlotteY - savannahY)));

        double distanceSO = radius * Math.acos(Math.toRadians(Math.sin(savannahX) * Math.sin(orlandoX) +
            Math.cos(savannahX) * Math.cos(orlandoX) * Math.cos(savannahY - orlandoY)));

        double distanceOA = radius * Math.acos(Math.toRadians(Math.sin(orlandoX) * Math.sin(atlantaX) +
            Math.cos(orlandoX) * Math.cos(atlantaX) * Math.cos(orlandoY - atlantaY)));

        double distanceAC = radius * Math.acos(Math.toRadians(Math.sin(atlantaX) * Math.sin(charlotteX) +
            Math.cos(atlantaX) * Math.cos(charlotteX) * Math.cos(atlantaY - charlotteY)));

        double distanceCO = radius * Math.acos(Math.toRadians(Math.sin(charlotteX) * Math.sin(orlandoX) +
            Math.cos(charlotteX) * Math.cos(orlandoX) * Math.cos(charlotteY - orlandoY)));

        double expression = charlotteX * (savannahY - orlandoY) + savannahX * (orlandoY - charlotteY) +
            orlandoX * (charlotteY - savannahY);
        double area = 0.5 * Math.abs(expression);

        expression = charlotteX * (atlantaY - orlandoY) + atlantaX * (orlandoY - charlotteY) +
            orlandoX * (charlotteY - atlantaY);
        area += 0.5 * Math.abs(expression);

        System.out.println("Area: " + area);
    }

    public void taskFour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the side: ");
        double side = scanner.nextDouble();
        double area = (6 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 6));
        System.out.println("Area of hexagon: " + area);
    }

    public void taskFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of sides: ");
        double n = scanner.nextDouble();
        System.out.println("Enter the side: ");
        double side = scanner.nextDouble();

        double area = (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
        System.out.println("Area: " + area);
    }
}
