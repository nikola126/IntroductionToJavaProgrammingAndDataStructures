package com.programming.java.IntroductionToJavaNakov.ch13_Strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChapterThirteen {

    public static final String HOME = "./src/main/resources/textFiles/";

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(input);
        System.out.println("In reverse: ");
        System.out.println(stringBuilder.reverse().toString());
    }

    public static void taskTwo() {
        String fileName = "yellow_submarine.txt";
        String file = HOME + fileName;
        Scanner fileReader = null;

        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new Scanner(new File(file));

            while (fileReader.hasNextLine()) {
                stringBuilder.append(fileReader.nextLine());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + fileName + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        String text = stringBuilder.toString().toLowerCase();
        String target = "in";
        int occurences = 0;
        int index = text.indexOf("in");
        while (index != -1) {
            occurences += 1;
            index = text.indexOf(target, index + 1);
        }

        System.out.printf("%s is seen in %s %d times.\n", target, fileName, occurences);
    }

    public static void taskThree() {
        String fileName = "yellow_submarine_tags.txt";
        String file = HOME + fileName;
        Scanner fileReader = null;

        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new Scanner(new File(file));

            while (fileReader.hasNextLine()) {
                stringBuilder.append(fileReader.nextLine());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + fileName + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        String text = stringBuilder.toString();
        String textUppercase = stringBuilder.toString().toUpperCase();

        int openingTagIndex = text.indexOf("<upcase>");
        int closingTagIndex = text.indexOf("</upcase");
        while (openingTagIndex != -1 && closingTagIndex != -1) {
            String tagContents = text.substring(openingTagIndex, closingTagIndex + 9);

            text = text.replace(tagContents, textUppercase.substring(openingTagIndex + 8, closingTagIndex));

            // update indices and the text itself after removing the tags
            textUppercase = text.toUpperCase();
            openingTagIndex = text.indexOf("<upcase>", openingTagIndex + 1);
            closingTagIndex = text.indexOf("</upcase", closingTagIndex + 1);
        }

        System.out.println(text);
    }

    public static void taskFour() {
        String fileName = "microsoft.txt";
        String file = HOME + fileName;
        Scanner fileReader = null;

        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new Scanner(new File(file));

            while (fileReader.hasNextLine()) {
                stringBuilder.append(fileReader.nextLine());
            }

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("File " + fileName + " not found.");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        String text = stringBuilder.toString();

        String bannedWords = "Java,JVM,Microsoft";
        String[] banned = bannedWords.split(",");

        for (String word : banned) {
            int index = text.indexOf(word);
            while (index != -1) {
                String censored = new String("*");
                censored = censored.repeat(word.length());
                text = text.replace(word, censored);
                index = text.indexOf(word, index + 1);
            }
        }

        System.out.println("Censored:");
        System.out.println(text);
    }

    public static void taskFive() {
        String URL = "http://www.devbg.org/forum/index.php";
        String protocol, server, resource;

        String[] parts = URL.split("[:////]");
        System.out.println(Arrays.toString(parts));

        protocol = parts[0];
        server = parts[3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        for (int i = 4; i < parts.length; i++) {
            stringBuilder.append(parts[i]);
            stringBuilder.append("/");
        }
        resource = stringBuilder.toString();

        System.out.println("URL: " + URL);
        System.out.println("Protocol: " + protocol);
        System.out.println("Server: " + server);
        System.out.println("Resource: " + resource);
    }

    public static void taskSix() {
        String sentence = "C# is not C++ and PHP is not Delphi.";
        String[] words = sentence.split("[ ,.!?]");
        List<Character> punctuation = new ArrayList<>();
        for (char c : sentence.toCharArray()) {
            if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?')
                punctuation.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();

        int j = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]);
            stringBuilder.append(punctuation.get(j));
            j++;
        }

        String reversed = stringBuilder.toString();
        System.out.println("Reversed: " + reversed);
    }

    public static void taskSeven() {
        String text = "one\two\three";
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c == '\t') {
                // form an escape sequence
                stringBuilder.append('\\');
                stringBuilder.append('t');
            }
            else
                stringBuilder.append(c);
        }
        text = stringBuilder.toString();
        String[] words = text.split("\\\\");
        System.out.println("Text: " + text);
        System.out.println("Words: " + Arrays.toString(words));
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
    }
}
