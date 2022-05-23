package com.programming.java.IntroductionToJavaNakov.ch10_Recursion;

import java.util.*;

public class Labyrinth {
    private static char[][] lab = {
            {' ', '*', '*', ' '},
            {' ', ' ', ' ', ' '},
            {' ', ' ', '*', ' '},
            {'*', ' ', ' ', 'e'},
    };

    private static Queue<Coordinate> path = new LinkedList<>();
    private static List<Coordinate> backpath = new ArrayList<>();

    public static void main(String[] args) {
        findPath(0, 0);
    }

    public static void findPath(int startX, int startY) {
        path.add(new Coordinate(startX, startY, null));
        traverse();
    }

    public static void traverse() {
        while (!path.isEmpty()) {
            Coordinate current = path.remove();

            // check if out of bounds
            if (current.getX() < 0 || current.getX() >= lab.length)
                continue;
            if (current.getY() < 0 || current.getY() >= lab[0].length)
                continue;

            char currentCell = lab[current.getX()][current.getY()];

            // check if we have found the exit
            if (currentCell == 'e') {
                System.out.println("Exit found!");
                printLabyrinth();
                evaluateBacktrackPath(current);
                System.out.println("Shortest path: ");
                System.out.println(backpath);
                return;
            }

            // check if not free
            if (currentCell != ' ')
                continue;

            // mark cell as visited
            lab[current.getX()][current.getY()] = 's';

            // recursion in all possible directions
            path.add(new Coordinate(current.getX(), current.getY() - 1, current));
            path.add(new Coordinate(current.getX() - 1, current.getY(), current));
            path.add(new Coordinate(current.getX(), current.getY() + 1, current));
            path.add(new Coordinate(current.getX() + 1, current.getY(), current));

            // mark cell as free
            lab[current.getX()][current.getY()] = ' ';
        }

        System.out.println("No Exit found!");
        printLabyrinth();
    }

    public static void evaluateBacktrackPath(Coordinate last) {
        List<Coordinate> back = new ArrayList<>();
        Coordinate current = last;

        while (current != null) {
            back.add(current);
            current = current.getParent();
        }

        for (int i = back.size() - 1; i >= 0; i--)
            backpath.add(back.get(i));
    }

    public static void printLabyrinth() {
        for (char[] row : lab) {
            System.out.println(Arrays.toString(row));
        }
    }
}
