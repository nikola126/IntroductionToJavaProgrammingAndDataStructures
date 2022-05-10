package com.programming.java.IntroductionToJavaNakov.ch15_TextFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChapterFifteen {
    public static final String HOME = "./src/main/resources/textFiles/";

    public static void taskOne() {
        String fileName = "sample2.txt";
        String file = HOME + fileName;
        Scanner fileReader = null;
        int lineNumber = 0;
        try {
            fileReader = new Scanner(new File(file));
            System.out.println("File " + fileName + " opened.");

            while (fileReader.hasNextLine()) {
                lineNumber++;
                if (lineNumber % 2 == 0)
                    System.out.printf("Line %d:%s%n",
                            lineNumber, fileReader.nextLine());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + fileName + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    public static void taskTwo() {
        String namesFile = "names.txt";
        String sortedFile = "sortedNames.txt";

        String file = HOME + namesFile;
        Scanner fileReader = null;

        List<String> names = new ArrayList<>();
        try {
            fileReader = new Scanner(new File(file));
            System.out.println("File " + namesFile + " opened.");

            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine().trim();
                names.add(name);
            }

            Collections.sort(names);

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + namesFile + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        file = HOME + sortedFile;
        PrintStream fileWriter = null;

        try {
            fileWriter = new PrintStream(file);
            System.out.println("File " + sortedFile + " opened.");

            for (String name : names) {
                fileWriter.println(name);
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + sortedFile + " could not be created");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }

    }

    public static void printAll() {
//        taskOne();
        taskTwo();
    }

    public static void main(String[] args) {
        printAll();
    }
}
